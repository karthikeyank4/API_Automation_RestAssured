package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import reuseable_fields.Authentication_Manual;

public class SalesmanMasters {

	@Test
	public void salesManMaster()
	{
		
		// 1. Get Method - Salesman Master
		
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().queryParam("PageNumber", "9615").queryParam("PageSize", "9615")
		.header("authorization" ,Authentication_Manual.Bearer() )
		.when().get("/api/core/v1/SalesmanMasters/GetAll?PageNumber=9615&PageSize=9615")
		.then().log().all().assertThat().statusCode(200);
		
	}
}
