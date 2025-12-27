package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;



public class ProductType {
	
	@Test
	public void productType(){
		
		//1.Get All Method 
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/ProductType/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.productType())
		.when().post("/api/core/v1/ProductType/Create")
		.then().log().all().extract().response().asString();
	JsonPath js = new JsonPath(response);
	String data = js.getString("result");
	System.out.println( "The ext_id is:"+ data);
	
	//3.Patch Method .
	String productTypeName ="product"+ Reusablefields.randomAlphabetic(5);
	String remarks ="remarks"+Reusablefields.randomAlphabetic(5);
	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"productType\": {\r\n"
			+ "    \"id\": 558,\r\n"
			+ "    \"extId\": \""+data+"\",\r\n"
			+ "    \"salesEnquiryMainId\": 9125,\r\n"
			+ "    \"productTypeName\": \""+productTypeName+"\",\r\n"
			+ "    \"remarks\": \""+remarks+"\",\r\n"
			+ "    \"updatedBy\": 5345\r\n"
			+ "  }"
			+ "}")
	
		.when().patch("/api/core/v1/ProductType/Patch")
		.then().log().all().assertThat().statusCode(200);
	
	//4.Get By id .
	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.pathParam("id", data)
	.when().get("/api/core/v1/ProductType/GetById/{id}")
	.then().log().all().assertThat().statusCode(200);
	
	// 5.delete id .
	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.pathParam("id", data)
	.when().delete("/api/core/v1/ProductType/Delete/{id}")
	.then().log().all().assertThat().statusCode(200);
	
	}

}
