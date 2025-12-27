package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import  static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

public class SampleMain {

	@Test
	public void sampleMain()
	{
		//1.Get All Method .
		RestAssured .baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/SampleMain/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
		String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
				.header("Content-Type","application/json")
				.body(Payload.SampleMain())
				.when().post("/api/core/v1/SampleMain/Create")
				.then().log().all().assertThat().statusCode(201).extract().response().asString();
				JsonPath js =new JsonPath(response);	
			String data =	js.getString("result");
			System.out.println("The Ext_id is :"+ data);
			
			//3. patch Method.
			
			String samplename ="sample"+Reusablefields.randomAlphabetic(4);
		    
 	given().log().all().header("Content-Type","application/json").header("authorization",Authentication_Manual.Bearer())
			.body("{\r\n"
					+ "  \"extId\": \""+data+"\",\r\n"
					+ "  \"sampleMain\": {\r\n"
					+ "    \"sampleName\": \""+samplename+"\",\r\n"
					+ "    \"availability\": false\r\n"
					+ "  }\r\n"
					+ "}")
			.when().patch("/api/core/v1/SampleMain/Patch")
			.then().assertThat().statusCode(200).extract().response().asString();
 	
 	     //4.Get Method 
 		given().log().all().pathParam("id", data).header("authorization",Authentication_Manual.Bearer())
 		.when().get("/api/core/v1/SampleMain/GetById/{id}")
 		.then().log().all().assertThat().statusCode(200);
 		
 		//5.Delete Method 
 		given().log().all().pathParam("id", data).header("authorization",Authentication_Manual.Bearer())
 		.when().delete("/api/core/v1/SampleMain/Delete/{id}")
 		.then().log().all().assertThat().statusCode(200);
		
	}
}
