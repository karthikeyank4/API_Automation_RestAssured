package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Payload;
public class EmbroideryType {
	
	
	

	@Test
	public  void embroideryTypeAPI()
	{
		//post Method 
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
	String response	=given().log().all().header("Content-Type","application/json").header("Authorization",Authentication_Manual.Bearer())
		.body(Payload.embroideryPayload())
		.when().post("/api/core/v1/EmbroideryType/Create")
		.then().assertThat().statusCode(201).extract().response().asString();
	System.out.println(response);
	
	JsonPath js = new JsonPath(response);
	String data =js.get("data");
	System.out.println("the data is ");
	System.out.println(data);
	
	// patch Request 
	String embroideryName ="karthik";
	String newremarks =" Updated the new Changee";
	 String Updated= given().log().all().header("Content-Type","application/json").header("authorization" ,Authentication_Manual.Bearer())
	.body("{\r\n"
			+ "  \"extId\": \""+data+"\",\r\n"
			+ "  \"dto\": {\r\n"
			+ "    \"embroideryName\": \""+embroideryName+"\",\r\n"
			+ "    \"remarks\": \""+newremarks+"\",\r\n"
			+ "    \"screenId\": 1982,\r\n"
			+ "    \"salesEnquiryMainId\": 541\r\n"
			+ "  }\r\n"
			+ "}")
	.when().patch("/api/core/v1/EmbroideryType/Patch")
	.then().assertThat().statusCode(200) .extract().response().asString();
	 System.out.println(Updated);
	
	
	
	
	
	
	
	}
	
	
}
	

