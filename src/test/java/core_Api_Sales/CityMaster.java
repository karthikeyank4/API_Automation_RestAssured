package core_Api_Sales;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Coreapi_Payload;
import reuseable_fields.Reusablefields;

public class CityMaster {
	
	@Test
	public void cityMaster()
	{
		//1 .Get all City 
		RestAssured.baseURI ="https://core-api-dev.colanapps.in/";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all()
		.when().get("api/v1/cityMaster/getAllCity")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method . 
		// Status  code issue - in the Response body update as 201.
	String response =given().log().all().header("Content-Type","application/json")
			.body(Coreapi_Payload.cityMaster())
		.when().post("api/v1/cityMaster/createCity")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
	  JsonPath js =new JsonPath( response);
	String ext_id  = js.getString("result");
	System.out.println("The ext_id is :"+ ext_id);
	
	//3 .Patch Method .
	String cityname ="city"+Reusablefields.randomAlphabetic(5);
	String postalcode="code"+Reusablefields.randomAlphabetic(4);
String update =	given().log().all().header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"stateId\": 0,\r\n"
			+ "  \"cityName\": \""+cityname+"\",\r\n"
			+ "  \"postalCode\": \""+postalcode+"\",\r\n"
			+ "  \"extId\": \"90c6a5a0-c6fe-444a-84b2-63ffa6aa640a\"\r\n"
			+ "}")
	 .when().patch("api/v1/cityMaster/updateCityById")
	 .then().log().all().assertThat().statusCode(200).extract().response().asString();

//          //4. Get By id .
//       given().log().all().pathParam("extId", ext_id)
//       .when().get("api/v1/cityMaster/getCityById{extId}")
//       .then().assertThat().statusCode(200);

	 


	
	
	  
		
		
	}

}
