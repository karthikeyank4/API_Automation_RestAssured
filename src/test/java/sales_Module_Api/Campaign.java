package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;
public class Campaign {
	
	@Test
	public void campaignTypeApi() {
		
		//1.Get All Method .
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/Campaign/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2. Post Method 
	String response =	given().log().all().header("Content-Type","application/json").header("authorization",Authentication_Manual.Bearer())
		.body(Payload.campaignType())
		.when().post("/api/core/v1/Campaign/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js =new JsonPath(response);
	String data =	js.getString("data");
	System.out.println(data);
	 
	//3. Patch Method 
	
	String name ="name" + Reusablefields.randomAlphabetic(5);
	String type ="Type" + Reusablefields.randomAlphabetic(4);
	String update = given().log().all().header("Content-Type", "application/json").header("authorization",Authentication_Manual.Bearer())
.body("{\r\n"
		+ "  \"extId\": \""+data+"\",\r\n"
		+ "  \"dto\": {\r\n"
		+ "    \"screenId\": 6319,\r\n"
		+ "    \"campaignName\": \""+name+"\",\r\n"
		+ "    \"campaignType\": \""+type+"\",\r\n"
		+ "    \"description\": \"string\",\r\n"
		+ "    \"startDate\": \"2021-12-04T20:05:40.245Z\",\r\n"
		+ "    \"endDate\": \"2024-03-07T13:48:17.937Z\",\r\n"
		+ "    \"ownerId\": 1609\r\n"
		+ "  }\r\n"
		+ "}")	
 .when().patch("/api/core/v1/Campaign/Patch")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
      //4. Get Method 
String updated =	given().log().all().header("authorization",Authentication_Manual.Bearer()).pathParam("id",data)
	.when().get("/api/core/v1/Campaign/GetById/{id}")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
System.out.println(updated);

JsonPath js1 = new JsonPath(updated);
 String verify =js1.getString("data.campaignName");
 Assert.assertEquals(verify, name );

	

		
		
	}

}
