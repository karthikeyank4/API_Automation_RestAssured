package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Payload;

public class ClothType {
	
	@Test
	public void clothTypeApi() {
		
		//1.Get ALL Method 
		
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Dummy2.Bearer())
		.when().get("/api/core/v1/ClothType/GetAll_Cloth_Type")
		.then().log().all().assertThat().statusCode(200);
		
		//2. Post Method .
	String response =	given().log().all().header("Content-Type","application/json")
		.header("authorization",Authentication_Dummy2.Bearer()).body(Payload.clothType())
	    .when().post("/api/core/v1/ClothType/Create_Cloth_Type")
	    .then().log().all().assertThat().statusCode(200).extract().response().asString();
	JsonPath js =new JsonPath(response);
	
	
		
		
		
		
		
		
		
	}

}
