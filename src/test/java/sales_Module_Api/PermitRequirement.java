package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;

public class PermitRequirement {
	
	@Test
	public void permitRequirement()
	{
		//1.Get All Method 
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/PermitRequirement/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
String response = given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.permitRequirement())
		.when().post("/api/core/v1/PermitRequirement/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
JsonPath js = new JsonPath(response);
String data =js.getString("result");
System.out.println( "The ext_id is" +data);
		
 //3.Patch Method
String permitRequirementName ="permit"+ Authentication_Manual.randomAlphabetic(5);
String remarks ="remarks"+ Authentication_Manual.randomAlphabetic(6);
  given().log().all().header("authorization",Authentication_Manual.Bearer())
  .header("Content-Type","application/json")
  .body("{\r\n"
  		+ "  \"extId\": \""+data+"\",\r\n"
  		+ "  \"permitRequirement\": {\r\n"
  		+ "    \"permitRequirementName\": \""+permitRequirementName+"\",\r\n"
  		+ "    \"remarks\": \""+remarks+"\"\r\n"
  		+ "  }\r\n"
  		+ "}")
  .when().patch("/api/core/v1/PermitRequirement/Patch")
  .then().log().all().assertThat().statusCode(200);
  
  //4.Get by Id Method
  given().log().all().header("authorization",Authentication_Manual.Bearer())
  .pathParams("id",data)
  .when().get("/api/core/v1/PermitRequirement/GetById/{id}")
  .then().log().all().assertThat().statusCode(200);
  
  //5.Delete Method
  given().log().all().header("authorization",Authentication_Manual.Bearer())
  .pathParams("id",data)
  .when().delete("/api/core/v1/PermitRequirement/Delete/{id}")
  .then().log().all().assertThat().statusCode(200);
 
		
		
	}
	

}
