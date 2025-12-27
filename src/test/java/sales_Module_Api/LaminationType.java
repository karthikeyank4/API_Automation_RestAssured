package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;
public class LaminationType {

	@Test
	public void laminationType() 
	{
		//1. Get ALL Method 
	    RestAssured .baseURI ="https://sales-api-dev.colanapps.in";
	    RestAssured.useRelaxedHTTPSValidation();
	    given().log().all().header("authorization",Authentication_Manual.Bearer())
	    .when().get("/api/core/v1/LaminationType/GetAll")
	    .then().log().all().assertThat().statusCode(200);
	    
	   //2 .Post Method 
	String response =    given().log().all().header("authorization",Authentication_Manual.Bearer())
	    .header("Content-Type","application/json")
	    .body(Payload.LaminationType())
	    .when().post("/api/core/v1/LaminationType/Create")
	    .then().log().all().assertThat().statusCode(201).extract().response().asString();
	    JsonPath js = new JsonPath(response);
	   String data = js.getString("result");
	   System.out.println(data);
	   
	   // 3.Patch Method.
	   String laminationtype ="name"+Reusablefields.randomAlphabetic(5);
String update =	   given().log().all().header("authorization",Authentication_Manual.Bearer())
	   .header("Content-Type","application/json")
	   .body("{\r\n"
	   		+ "  \"extId\": \""+data+"\",\r\n"
	   		+ "  \"laminationType\": {\r\n"
	   		+ "    \"laminationTypeName\": \""+ laminationtype+"\",\r\n"
	   		+ "    \"remarks\": \"string\",\r\n"
	   		+ "    \"salesEnquiryMainId\": 3304\r\n"
	   		+ "  }\r\n"
	   		+ "}")
	   .when().patch("/api/core/v1/LaminationType/Patch")
	   .then().log().all().extract().response().asString();

	   //Get Method 
 String updated =   given().log().all().header("authorization",Authentication_Manual.Bearer())
    .when().get("/api/core/v1/LaminationType/GetById/:id")
    .then().log().all().assertThat().statusCode(200).extract().response().asString();
 JsonPath js1 = new JsonPath(updated);
System.out.println(updated);

	  
	   
	    
	    
	    
		
		
		
		
		
}
	
	
	
	
	
	
	
}