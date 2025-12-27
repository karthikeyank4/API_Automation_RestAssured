package sales_Module_Api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class MediaType {
	
	@Test
	public void mediaType()
	{
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/MediaType/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.mediaType())
		.when().post("/api/core/v1/MediaType/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
	JsonPath js =new JsonPath(response);
	String data =js.getString("result");
	System.out.println(data);
	
	//3.Patch Method
	String mediaType ="media"+ Reusablefields.randomAlphabetic(4);
	String  remarks ="reamrks"+Reusablefields.randomAlphabetic(5);
String update =	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"extId\": \""+data+"\",\r\n"
			+ "  \"mediaType\": {\r\n"
			+ "    \"mediaTypeName\": \""+mediaType+"\",\r\n"
			+ "    \"remarks\": \""+ remarks+"\"\r\n"
			+ "  }\r\n"
			+ "}")
	.when().patch("/api/core/v1/MediaType/Patch")
	.then().log().all().assertThat().statusCode(200).body("message", equalTo("Media Type updated successfully.")).extract().response().asString();
//	JsonPath js1 =new JsonPath(update);

//Get by Id Method

given().log().all().header("authorization",Authentication_Manual.Bearer())
.pathParams("id",data)
.when().get("/api/core/v1/MediaType/GetById/{id}")
.then().log().all().assertThat().statusCode(200);

//Delete Method
given().log().all().header("authorization",Authentication_Manual.Bearer())
.pathParams("id",data)
.when().delete("/api/core/v1/MediaType/Delete/{id}")
.then().log().all().assertThat().statusCode(200).body("message", equalTo("Media Type deleted successfully."));
	
	
		
		
	}

}
