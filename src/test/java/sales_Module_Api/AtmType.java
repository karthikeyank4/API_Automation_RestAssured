package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;

public class AtmType {
	
	@Test
	public void atmTypeAPI()
	{
		
		// 1.Get all Method 
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/AtmType/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		// 2.Post Method 
	
	String response=	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json").body(Payload.atmTypePayload())
		.when().post("/api/core/v1/AtmType/Create")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
	//System.out.println(response);
	JsonPath js = new JsonPath(response);
	//js.getString()
	
		
		
		
		
	}

}
