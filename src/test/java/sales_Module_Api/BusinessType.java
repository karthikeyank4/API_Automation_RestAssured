package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

public class BusinessType {
	
	
	@Test
	public void businessTypeApi() {
		
		//  1.Get all Method 
		
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/BusinessType/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
		String response =given().log().all().header("Content-Type","application/json").header("authorization",Authentication_Manual.Bearer())
		.body(Payload.BusinessType()).when().post("/api/core/v1/BusinessType/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(response);
	String data =	js.getString("data");
	System.out.println(data);
	
	// 3.Patch Method 
	String name ="name" + Reusablefields.randomAlphabetic(5);
	
String Updated =	given().log().all().header("Content-Type","application/json")
	.header("authorization",Authentication_Dummy2.Bearer())
	.body("{\r\n"
			+ "  \"businessType\":{\r\n"
			+ "    \"businessTypeName\": \""+name+"\",\r\n"
			+ "    \"extId\": \""+data+"\"\r\n"
			+ "  }\r\n"
			+ "}")
	.when().patch("/api/core/v1/BusinessType/Patch")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();

        //4.Get Method 
  String updated =  given().log().all().header("authorization",Authentication_Manual.Bearer()).pathParam("id", data)
    .when().get("/api/core/v1/BusinessType/GetById/{id}")
    .then().assertThat().statusCode(200).log().all() .extract().response().asString();
  System.out.println(updated);
	
	
		
		
		
		
	}

}
