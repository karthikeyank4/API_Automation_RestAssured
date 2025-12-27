package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

public class SampleLocation {
	
	@Test
	public void samplelocation()
	{
		//1.Get All Method 
				RestAssured.baseURI="https://sales-api-dev.colanapps.in";
				RestAssured.useRelaxedHTTPSValidation();
				given().log().all().header("authorization",Authentication_Manual.Bearer())
				.when().get("/api/core/v1/SampleLocation/GetAll")
				.then().log().all().assertThat().statusCode(200);
				
				//2. Post Method .
				String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
						.header("Content-Type","application/json")
						.body(Payload.sampleLocation())
						.when().post("/api/core/v1/SampleLocation/Create")
						.then().log().all().assertThat().statusCode(201).extract().response().asString();
						JsonPath js =new JsonPath(response);	
					String data =	js.getString("result");
					System.out.println("The Ext_id is :"+ data);
					
					//3.Patch Method .
					String locationname ="location"+Reusablefields.randomAlphabetic(4);
				    String remarks ="remarks"+Reusablefields.randomAlphabetic(5);
		 	given().log().all().header("Content-Type","application/json").header("authorization",Authentication_Manual.Bearer())
					.body("{\r\n"
							+ "  \"extId\": \""+data+"\",\r\n"
							+ "  \"sampleLocation\": {\r\n"
							+ "    \"locationName\": \""+locationname+"\",\r\n"
							+ "    \"remarks\": \""+remarks+"\"\r\n"
							+ "  }\r\n"
							+ "}")
					.when().patch("/api/core/v1/SampleLocation/Patch")
					.then().assertThat().statusCode(200).extract().response().asString();
		
	
	//4.Get Method 
	given().log().all().pathParam("id", data).header("authorization",Authentication_Manual.Bearer())
	.when().get("/api/core/v1/SampleLocation/GetById/{id}")
	.then().log().all().assertThat().statusCode(200);
	
	//5.Delete Method 
	given().log().all().pathParam("id", data).header("authorization",Authentication_Manual.Bearer())
	.when().delete("/api/core/v1/SampleLocation/Delete/{id}")
	.then().log().all().assertThat().statusCode(200);
		
	}

}
