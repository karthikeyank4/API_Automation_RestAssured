package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

public class Materialtype {
	
	@Test
	public void materialtype()
	{
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/MaterialType/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.materialType())
		.when().post("/api/core/v1/MaterialType/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
	JsonPath js = new JsonPath(response);
String result =	js.getString("result");
 System.out.println(result);
 
 // 3.Patch Method 
 String materialtype = "type"+Reusablefields.randomAlphabetic(5);
 String remarks = "remarks"+Reusablefields.randomAlphabetic(4);
String update = given().log().all().header("authorization",Authentication_Manual.Bearer())
 .header("Content-Type","application/json")
 .body("{\r\n"
 		+ "  \"dto\": {\r\n"
 		+ "    \"id\": 7865,\r\n"
 		+ "    \"extId\": \""+result+"\",\r\n"
 		+ "    \"salesEnquiryMainId\": 3809,\r\n"
 		+ "    \"materialType\": \""+materialtype+"\",\r\n"
 		+ "    \"remarks\": \""+remarks+"\",\r\n"
 		+ "    \"materialCategory\": 3954,\r\n"
 		+ "    \"materialId\": 1980,\r\n"
 		+ "    \"isActive\": false,\r\n"
 		+ "    \"updatedBy\": 6771,\r\n"
 		+ "    \"updatedAt\": \"2023-05-09T17:52:38.212Z\",\r\n"
 		+ "    \"screenId\": 598\r\n"
 		+ "  }\r\n"
 		+ "}")
		.when().patch("/api/core/v1/MaterialType/Update")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
  //4.Get Method 
 String updated = given().log().all().header("authorization",Authentication_Manual.Bearer())
 .pathParams("id", result)
 .when().get("/api/core/v1/MaterialType/GetById/{id}")
 .then().log().all().assertThat().statusCode(200).extract().response().asString();
 //Assert.assertEquals(updated,materialtype );

		
	}

}
