package core_Api_Sales;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class City {
	
	@Test
	public void city()
	{
		//1 .Get all City Master
		RestAssured.baseURI="https://core-api-dev.colanapps.in/";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().queryParam("PageNumber","1")
		.queryParam("PageSize","10")
		.when().get("/api/v1/city/getAllCityMater?PageNumber=1&PageSize=10")
		.then().log().all().assertThat().statusCode(200);
		
		//2. Create City Master
		
		
		
		
	}

}
