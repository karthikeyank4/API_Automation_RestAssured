package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;

public class ItemWiseTarget {
	@Test
	public void itemWiseTarget()
	{
		//1.Get All Method.
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/ItemWiseTargets/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2. Post Method 
		
		
		
	}

}
