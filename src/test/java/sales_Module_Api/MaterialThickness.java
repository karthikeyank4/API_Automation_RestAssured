package sales_Module_Api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;

import static io.restassured.RestAssured.*;

public class MaterialThickness {
	
	
	@Test
	public void materialThickness() 

	{
		//1.Get All Methodnn
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/MaterialThickness/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		// 2. Post Method
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.materialThickness())
		.when().post("/api/core/v1/MaterialThickness/Create")
		.then().log().all().assertThat().statusCode(200);
		
		
	}
}
