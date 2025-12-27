package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
public class LetterRun {
	
	@Test
	public void letterRunApi()
	{
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/LetterReturn/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
	String resonse =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"letterReturnValue\": 1946.4847436097266,\r\n"
				+ "  \"salesEnquiryMainId\": 1830595741,\r\n"
				+ "  \"screenId\": 1302965496,\r\n"
				+ "  \"unitOfMeasure\": \"Yn\",\r\n"
				+ "  \"remarks\": \"D\"\r\n"
				+ "}")
		.when().post("/api/core/v1/LetterReturn/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
	JsonPath js = new JsonPath(resonse);
	String data =js.getString("data");
		
		//3 .Patch Method 
String update =	  given().log().all().header("authorization",Authentication_Manual.Bearer())
	  .body("{\r\n"
	  		+ "  \"extId\": \""+data+"\",\r\n"
	  		+ "  \"patch\": {\r\n"
	  		+ "    \"letterReturnValue\": 5044.869978221027,\r\n"
	  		+ "    \"unitOfMeasure\": \"yV5 Rxp6/\",\r\n"
	  		+ "    \"remarks\": \"^\"\r\n"
	  		+ "  }\r\n"
	  		+ "}")
	  .when().patch("/api/core/v1/LetterReturn/Patch")
	  .then().log().all().assertThat().statusCode(200).extract().response().asString();

          // Get Method .
         given().log().all().header("authorization",Authentication_Manual.Bearer())
         .when().get("/api/core/v1/LetterReturn/GetById/{id}")
         .then().log().all().assertThat().statusCode(200);
         
         
         
	
		
		
		
	}

}
