package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Payload;
public class DigitalPrintOption {
	//static String data;
    //static String newremark = "Great Work Karthikeyan k";


	@Test(priority=1)
	public void DigitalPrintPostPatchGet() 
	{
		// TODO Auto-generated method stub
		
		//Post Method .
		
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
	String response =	given().log().all().header("Content-Type","application/json")
		.body(Payload.digitalPrintPayload()).header("authorization",Authentication_Manual.Bearer())
		.when().post("/api/core/v1/DigitalPrintOption/Create")
		.then().assertThat().statusCode(200).extract().response().asString();
	
	      System.out.println(response);
	    JsonPath js =new JsonPath(response);
	   String data = js.getString("data");
	   System.out.println("Created extId: " + data);
	
	  
	   String newremark = "Great Work Karthikeyan k";
	   
	  String update = given().log().all().header("authorization", Authentication_Manual.Bearer())
	   .header("Content-Type","application/json")
	   .body("{\r\n"
	   		+ "  \"extId\": \""+ data +"\",\r\n"
	   		+ "  \"dto\": {\r\n"
	   		+ "    \"salesEnquiryMainId\": 1443,\r\n"
	   		+ "    \"digitalPrintName\": \"string\",\r\n"
	   		+ "    \"remarks\": \""+newremark +"\",\r\n"
	   		+ "    \"screenId\": 2139\r\n"
	   		+ "  }\r\n"
	   		+ "}")
	   .when().patch("/api/core/v1/DigitalPrintOption/Patch")
	   .then().assertThat().statusCode(200).extract().response().asString();
	  System.out.println(update);
	   
	 
	     //Get Method .
	String updated =  given().log().all().pathParam("id",data).header("authorization",Authentication_Manual.Bearer())
	  .when().get("/api/core/v1/DigitalPrintOption/Getbyid/{id}")
	  .then().assertThat().statusCode(200).extract().response().asString();
	System.out.println(updated);
	JsonPath js1 = new JsonPath(updated);
	String verify =js1.get("data.remarks");
	System.out.println(verify);
	Assert.assertEquals(verify,newremark);
	
}	
	
}	
		

	


