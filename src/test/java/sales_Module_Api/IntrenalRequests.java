package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;

public class IntrenalRequests {

	@Test
	public  void internalRequest()
	{
		//1.Get all method 
		
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/InternalRequests/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
	   

      
		
		
		
	}
}
