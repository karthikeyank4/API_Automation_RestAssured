package sales_Module_Api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;

import static  io.restassured.RestAssured.*;

public class PaymentTerms {
	
	@Test
	public void paymentTerms()
	{
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/PaymentTerms/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.paymentTerms())
		.when().post("/api/core/v1/PaymentTerms/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
				
		
	}
	

}
