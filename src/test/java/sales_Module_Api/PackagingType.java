package sales_Module_Api;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;
import static org.hamcrest.Matchers.*;

public class PackagingType {
	
	@Test
	public void packagingType() {
		
		//1.GetAll Method
		
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/PackagingType/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.packagingType())
		.when().post("/api/core/v1/PackagingType/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
	JsonPath js =new JsonPath(response);	
String data =	js.getString("result");
System.out.println("The Ext_id is :"+ data);

//Patch Method 
String newPackagingType ="packaging"+ Reusablefields.randomAlphabetic(5);
String  newRemarks ="remarks"+Reusablefields.randomAlphabetic(6);
 String update = given().log().all().header("authorization",Authentication_Manual.Bearer())
.header("Content-Type","application/json")
.body("{\r\n"
		+ "  \"extId\": \""+data+"\",\r\n"
		+ "  \"packagingType\": {\r\n"
		+ "    \"packagingTypeName\": \""+newPackagingType+"\",\r\n"
		+ "    \"remarks\": \""+newRemarks+"\",\r\n"
		+ "    \"salesEnquiryMainId\": 7528\r\n"
		+ "  }\r\n"
		+ "}")
.when().patch("/api/core/v1/PackagingType/Patch")
.then().log().all().assertThat().statusCode(200).body("message", equalTo("Packaging Type updated successfully.")).extract()
.response().asString();
 
 //4.Get by Id Method
 given().log().all().header("authorization",Authentication_Manual.Bearer())
 .pathParams("id",data)
 .when().get("/api/core/v1/PackagingType/GetById/{id}")
 .then().log().all().assertThat().statusCode(200);
 
 //5.Delete Method
 given().log().all().header("authorization",Authentication_Manual.Bearer())
 .pathParams("id",data)
 .when().delete("/api/core/v1/PackagingType/Delete/{id}")
 .then().log().all().assertThat().statusCode(200).body("message", equalTo("Packaging Type deleted successfully."));
		
		
		
		
		
		
	}

}
