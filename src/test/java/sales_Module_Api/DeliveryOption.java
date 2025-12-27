package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
public class DeliveryOption {

	@Test
	public void deliveryOptionApi()
	{
		//1.Get all Method .
		
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/DeliveryOption/Getall")
		.then().log().all().assertThat().statusCode(200);
		
		//2. Post Method .
	String response =	given().log().all().header("Content-Type","application/json").header("authorization",Authentication_Manual.Bearer())
		.body(Payload.deliveryOption())
			.when().post("/api/core/v1/DeliveryOption/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(response);
		String data =js.getString("data");
		
		//3. Patch Method .
		String remarks ="Good fine ";
		String deliveryname =" Dummy";
	String updated=	given().log().all().header("Content-Type","application/json")
			.header("authorization",Authentication_Dummy2.Bearer())
		.body("{\r\n"
				+ "  \"extId\": \""+data+"\",\r\n"
				+ "  \"deliveryOption\": {\r\n"
				+ "    \"salesEnquiryId\": 9503,\r\n"
				+ "    \"deliveryOptionName\": \""+deliveryname+"\",\r\n"
				+ "    \"remarks\": \""+remarks+"\"\r\n"
				+ "  }\r\n"
				+ "}")
		.when().patch("/api/core/v1/DeliveryOption/Patch")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
	   // 4.Get Method 
	String verified = given().log().all().pathParams("id","data").header("authorization",Authentication_Manual.Bearer())
	.when().get("/api/core/v1/DeliveryOption/Getbyid/{id}")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	JsonPath js1 =new JsonPath(verified);
		String remark= 	js1.getString("remarks");
		Assert.assertEquals(verified,remarks );
	
		
		
		
		
	}
}
