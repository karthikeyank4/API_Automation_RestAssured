package reuseable_fields;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
public class Authentication {
	
	
	// Store tokens and time
    private static String accessToken = null;
    private static String refreshToken = null;
    private static long tokenCreatedTime = 0;
    
 // Access token valid for 3 hours
    private static final long EXPIRY_TIME = 3 * 60 * 60 * 1000;

    //BaseURL 
    private static final String BASE_URL = "https://sales-api-dev.colanapps.in";
    
    //  // 👉 Main method to get access token
    public static String getAccessToken() {

        // If no token OR token expired → get new one
        if (accessToken == null || isTokenExpired()) {
            System.out.println("🔁 Token expired or missing, trying refresh...");

            // Try refreshing using refresh token first
            if (!tryRefreshToken()) {
                System.out.println("⚠️ Refresh failed. Logging in again...");
                loginAndGetTokens(); // Get new tokens via login
            }
        } else {
            System.out.println("✅ Using existing access token");
        }

        return accessToken;
    }
 // Check if 3 hours are over
    private static boolean isTokenExpired() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - tokenCreatedTime) > EXPIRY_TIME;
    }

    // Login API (runs first time or if refresh fails)
    private static void loginAndGetTokens() {
        RestAssured.baseURI = BASE_URL;

        String response = given()
                .header("Content-Type", "application/json")
                .body("{\"usernameOrEmail\": \"karthik@colan.com\", \"password\": \"1234\"}")
                .when().post("/api/transaction/v1/Auth/login")
                .then().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        accessToken = js.getString("data.accessToken");
        refreshToken = js.getString("data.refreshToken");
        tokenCreatedTime = System.currentTimeMillis();

        System.out.println("✅ Logged in successfully & tokens stored");
    }
    
 // Refresh API (runs when access token expired)
    private static boolean tryRefreshToken() {
        if (refreshToken == null) {
            System.out.println("⚠️ No refresh token available.");
            return false;
        }

        try {
            RestAssured.baseURI = BASE_URL;

            String response = given()
                    .header("Content-Type", "application/json")
                    .body("{\"refreshToken\": \"" + refreshToken + "\"}")
                    .when().post("/api/transaction/v1/Auth/refresh")
                    .then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            String newAccessToken = js.getString("data.accessToken");
            String newRefreshToken = js.getString("data.refreshToken");

            // If refresh token API fails
            if (newAccessToken == null || newAccessToken.isEmpty()) {
                return false;
            }

            accessToken = newAccessToken;
            if (newRefreshToken != null && !newRefreshToken.isEmpty()) {
                refreshToken = newRefreshToken;
            }

            tokenCreatedTime = System.currentTimeMillis();
            System.out.println("✅ Access token refreshed successfully");
            return true;

        } catch (Exception e) {
            System.out.println("❌ Error while refreshing token: " + e.getMessage());
            return false;
        }
    }

    // To be used in all API headers
    public static String Bearer() {
        return "Bearer " + getAccessToken();
    }
    
	
}
