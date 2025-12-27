package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;

public class FacilityType {
	
	@Test
	public void facilityTypeApi() {
		
		//1. Get all method .
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/FacilitySite/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
	String response =given().log().all().header("Content-Type","application/json").header("authorization",Authentication_Manual.Bearer())
		.body(Payload.facilityType())
		.when().post("/api/core/v1/FacilitySite/Create")
		.then().assertThat().statusCode(201).extract().response().asString();
	
	JsonPath js =new JsonPath(response);
	String data =js.getString("data");
	System.out.println(data);
	
	//3.Patch Method 
	String name ="Updated the Patch Method ";
	String Update =given().log().all().header("Content-Type","application/json")
	.header("authorization",Authentication_Manual.Bearer())
	.body("{\r\n"
			+ "  \"extId\": \""+data+"\",\r\n"
			+ "  \"facilitySiteDTO\": {\r\n"
			+ "    \"optionName\": \""+name+"\",\r\n"
			+ "    \"description\": \"string\",\r\n"
			+ "    \"salesEnquiryMainId\": 8543\r\n"
			+ "  }\r\n"
			+ "}")
	.when().patch("/api/core/v1/FacilitySite/Patch")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	//4.Get Method 
String updated =	given().header("authorization ",Authentication_Manual.Bearer())
	.pathParams("id",data)
	.when().get("/api/core/v1/FacilitySite/GetById/{id}")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();

   JsonPath js1 = new JsonPath(updated);
  String verified = js1.getString("data.remarks");
  System.out.println(verified);
  Assert.assertEquals(verified,name);
   
	
			
	}

}
