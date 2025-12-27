package sales_Module_Api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

import static io.restassured.RestAssured.*;

public class IlumationType {
	
	@Test
	public void ilumationType()
	{
		//1.GetAll 
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/IlluminationType/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
String response =		given().log().all().header("Content-Type","application/json")
		.header("authorization",Authentication_Manual.Bearer())
		.body(Payload.iiumationType())
		.when().post("/api/core/v1/IlluminationType/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js =new JsonPath(response);
	String data =	js.getString("data");
	System.out.println(data);
	
	//3.Patch Method .
	String newname =" Name+ " +Reusablefields.randomAlphabetic(5);
	String update=	given().log().all().header("Content-Type","application/json")
		.header("authorization",Authentication_Manual.Bearer())
		.body("{\r\n"
				+ "  \"extId\": \""+data+"\",\r\n"
				+ "  \"patch\": {\r\n"
				+ "    \"illuminationTypeName\": \""+newname+"\",\r\n"
				+ "    \"remarks\": \".gGB<=x`.\"\r\n"
				+ "  }\r\n"
				+ "}")
		.when().patch("/api/core/v1/IlluminationType/Patch")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(update);
		
		//4.Get Method .
	String updated =given().header("authorization",Authentication_Manual.Bearer())
		.pathParams("id",data)
		.when().get("/api/core/v1/IlluminationType/{id}")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
	JsonPath js1 = new JsonPath(updated);
String verified=	js1.getString("data.illuminationTypeName");
Assert.assertEquals(newname,verified );
	
	
		}
	

}
