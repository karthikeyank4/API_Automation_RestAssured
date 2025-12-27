package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

public class ReflectiveOption {
	
	@Test
	public void reflectiveOption()
	{
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
	    .when().get("/api/core/v1/ReflectiveOption/GetAll")
	    .then().log().all().assertThat().statusCode(200);
		
		//2 .Post Method 
String response =given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.ReflectiveOption())
		.when().post("/api/core/v1/ReflectiveOption/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(response);
	String data =js.getString("result");
	System.out.println(data);
	
	//3.Patch Method 
	String reflectiveOptionName ="reflective"+Reusablefields.randomAlphabetic(5);
	String remarks ="remarks"+Reusablefields.randomAlphabetic(4);
	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"extId\": \""+data+"\",\r\n"
			+ "  \"dto\": {\r\n"
			+ "    \"reflectiveOptionName\": \""+remarks+"\",\r\n"
			+ "    \"remarks\": \"string\"\r\n"
			+ "  }\r\n"
			+ "}")
	.when().patch("/api/core/v1/ReflectiveOption/Patch")
	.then().log().all().assertThat().statusCode(200);
	
	//4.Get by Id Method
		given().log().all().header("authorization",Authentication_Manual.Bearer())
			.pathParams("id",data)
				.when().get("/api/core/v1/ReflectiveOption/GetById/{id}")
				.then().log().all().assertThat().statusCode(200);
		
		//5.Delete Method
		given().log().all().header("authorization",Authentication_Manual.Bearer())
			.pathParams("id",data)	
				.when().delete("/api/core/v1/ReflectiveOption/Delete/{id}")
				.then().log().all().assertThat().statusCode(200);
	
	
	
	}
	

}
