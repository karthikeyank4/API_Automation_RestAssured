package dummy;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Oauth {

	@Test
	public void oauthExample()
	{
		RestAssured.baseURI ="https://rahulshettyacademy.com/";
	String response =	given().formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParams("scope","trust")
		.formParams("grant_type","client_credentials")
		.when().post("oauthapi/oauth2/resourceOwner/token")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
	JsonPath js = new JsonPath(response);
String accesstoken=	js.getString("access_token");
System.out.println(accesstoken);

// get Method 
given().queryParams("access_token",accesstoken)
.when().get("oauthapi/getCourseDetails")
.then().log().all();
	
	
	
	}
	
	
}
