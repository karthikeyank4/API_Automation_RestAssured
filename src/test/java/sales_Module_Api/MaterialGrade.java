package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;
public class MaterialGrade {
	
	@Test
	public void materialGrade()
	{
		//1.Get All Method 
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/MaterialGrade/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		// 2.Post Method
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.materialGrade())
		.when().post("/api/core/v1/MaterialGrade/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
	JsonPath js =new JsonPath(response);
String data = 	js.getString("result");
System.out.println(data);

      //3 .Patch Method
    String materialname ="Material"+Reusablefields.randomAlphabetic(5);
    String remarks ="remarks"+Reusablefields.randomAlphabetic(5);
    
String Update =	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "    \"dto\": {\r\n"
			+ "        \"id\": 754,\r\n"
			+ "        \"extId\": \""+data+"\",\r\n"
			+ "        \"salesEnquiryMainId\": 7962,\r\n"
			+ "        \"materialGradeName\": \""+materialname+"\",\r\n"
			+ "        \"remarks\": \""+remarks+"\",\r\n"
			+ "        \"materialId\": 1910,\r\n"
			+ "        \"isActive\": false,\r\n"
			+ "        \"updatedBy\": 2607,\r\n"
			+ "        \"updatedAt\": \"1952-01-29T20:32:56.643Z\",\r\n"
			+ "        \"screenId\": 8077\r\n"
			+ "    }\r\n"
			+ "}")
		.when().patch("/api/core/v1/MaterialGrade/Update")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();

             //4.Get Method By Id
String updated =	 given().log().all().header("authorization",Authentication_Manual.Bearer())
	 .pathParams("id",data)
	 .when().get("api/core/v1/MaterialGrade/GetById/{id}")
	 .then().log().all().assertThat().statusCode(200).extract().response().asString();
	Assert.assertEquals(updated, materialname); 
	 
	//5.Delete Method
	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.pathParam("id", data)
	.when().delete("/api/core/v1/MaterialGrade/Delete/{id}")
	.then().log().all().assertThat().statusCode(200);
	}

	
}
