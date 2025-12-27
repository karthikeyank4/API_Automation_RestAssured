package reuseable_fields;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Authentication_Dummy2 {
	
	// Step 1: Store token and the time it was created
	
    private static String accesstoken = null;
    private static long tokenTime = 0;
    
 // Step 2: Set expiry time to 3 hours (in milliseconds)
    
    private static final long EXPIRY_TIME = 3 * 60 * 60 * 1000;

	 // Post Method for Authentication
	 
	 public static String getAccessToken()
	 
	 {
	  
		 

	        // Step 4: Check — if token is empty OR expired, get a new one
	        if (accesstoken == null || isTokenExpired()) {
	            System.out.println("🔁 Token missing or expired. Logging in again...");
	            accesstoken = generateNewToken();   // Call API to get a new token
	            tokenTime = System.currentTimeMillis();  // Save the current time
	        } else {
	            System.out.println("✅ Using existing token.");
	        }

	        return accesstoken;  // Return token for use in other APIs
	    }
		 
	 
	// Step 5: Check if 3 hours are passed
	    private static boolean isTokenExpired() {
	        long current = System.currentTimeMillis();
	        return (current - tokenTime) > EXPIRY_TIME;
	    }
	    
	    private static String generateNewToken() {
	   RestAssured.baseURI = "https://sales-api-dev.colanapps.in";
	String response =   given().header("Content-Type","application/json").log().all()
	   .body("{\r\n"
	   		+ "  \"usernameOrEmail\": \"karthik@colan.com\",\r\n"
	   		+ "  \"password\": \"1234\"\r\n"
	   		+ "}")
	   .when().post("/api/transaction/v1/Auth/login").then()
	   .assertThat().statusCode(200).extract().response().asString();
	System.out.println("🔹 Response body: " + response);
	
	JsonPath js = new JsonPath(response);
	String  accesstoken =js.getString("data.accessToken");
	System.out.println(accesstoken);
	 return accesstoken;
	 
}

	// Bearer 
	public static String Bearer() 
	{
		return "Bearer  " + getAccessToken()  ;
		
		
		
	}
	
	
	
}

	
	


