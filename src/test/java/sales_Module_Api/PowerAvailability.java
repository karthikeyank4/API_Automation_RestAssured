package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;
public class PowerAvailability {
	
	@Test
	public void powerAvailability() 
	{
		//1.GetAll Method
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/PowerAvailability/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.powerAvailability())
		.when().post("/api/core/v1/PowerAvailability/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js =new JsonPath(response);	
	String data =	js.getString("result");
	System.out.println("The Ext_id is :"+ data);
	
	//3.Patch Method
	String powerAvailabilityTypeName ="power"+Reusablefields.randomAlphabetic(5);
	 String remarks ="remarks"+Reusablefields.randomAlphabetic(6);
	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"extId\": \""+data+"\",\r\n"
			+ "  \"powerAvailability\": {\r\n"
			+ "    \"powerAvailabilityTypeName\": \""+powerAvailabilityTypeName+"\",\r\n"
			+ "    \"isGeneratorRequired\": true,\r\n"
			+ "    \"remarks\": \""+remarks+"\"\r\n"
			+ "  }\r\n"
			+ "}")
		.when().patch("/api/core/v1/PowerAvailability/Patch")
		.then().log().all().assertThat().statusCode(200);
	
	//4.Get by Id Method
	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.pathParams("id",data)
			.when().get("/api/core/v1/PowerAvailability/GetById/{id}")
			.then().log().all().assertThat().statusCode(200);
	
	//5.Delete Method
	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.pathParams("id",data)	
			.when().delete("/api/core/v1/PowerAvailability/Delete/{id}")
			.then().log().all().assertThat().statusCode(200);
	}

}
