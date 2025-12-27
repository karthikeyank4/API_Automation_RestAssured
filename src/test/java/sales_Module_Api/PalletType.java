package sales_Module_Api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

import static  io.restassured.RestAssured.*;
public class PalletType {
	
	
	@Test
	public void palletType()
	{
		
		//1.Get All Pallet Type
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/PalletType/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method Pallet Type
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.palletType())
		.when().post("/api/core/v1/PalletType/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js =new JsonPath(response);
	String data =	js.getString("result");
	System.out.println("The ext_id is" +data);
	
	// 3. patch method Pallet Type
	String palletTypeName = "pallettype"+Reusablefields.randomAlphabetic(5);
	String Remarks = "remarks"+Reusablefields.randomAlphabetic(5);
String update =	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"pallet\": {\r\n"
			+ "    \"id\": 345,\r\n"
			+ "    \"extId\": \""+data+"\",\r\n"
			+ "    \"salesEnquiryMainId\": 6557,\r\n"
			+ "    \"palletTypeName\": \""+palletTypeName+"\",\r\n"
			+ "    \"remarks\": \""+Remarks+"\",\r\n"
			+ "    \"updatedBy\": 7320\r\n"
			+ "  }\r\n"
			+ "}")
	.when().patch("/api/core/v1/PalletType/Patch")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
          //4.Get by id 
		  given().log().all().header("authorization",Authentication_Manual.Bearer())
		  .pathParam("id",data)
		  .when().get("/api/core/v1/PalletType/GetById/{id}")
		  .then().log().all().assertThat().statusCode(200);
		  
		  //5.Delete Method Pallet Type
		  given().log().all().header("authorization",Authentication_Manual.Bearer())
		  .pathParam("id",data)
		  .when().delete("/api/core/v1/PalletType/Delete/{id}")
		  .then().log().all().assertThat().statusCode(200);
	
	}

}
