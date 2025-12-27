package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;

public class Materials {

	@Test
	public void materials()
	{
		//1 .Get Method .
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/Materials/GetAll").
		then().log().all().assertThat().statusCode(200);
		
		// 2.Post Method 
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.materials())
		.when().post("/api/core/v1/Materials/Create").
		then().log().all().assertThat().statusCode(201).extract().response().asString();
	
	JsonPath js = new JsonPath(response);
String data=	js.getString("result");
System.out.println(data);

// 3.Patch Method .
String materialName_patch = "Patch" + Authentication_Manual.randomAlphabetic(4);
String update =	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"extId\": \""+data+"\",\r\n"
			+ "  \"material\": {\r\n"
			+ "    \"materialName\": \""+materialName_patch+"\",\r\n"
			+ "    \"remarks\": \"string\",\r\n"
			+ "    \"materialCategory\": 3311\r\n"
			+ "  }\r\n"
			+ "}")
	.when().patch("/api/core/v1/Materials/Patch")
	.then().log().all().assertThat().statusCode(200).body("message", equalTo("Material updated successfully.")).extract().response().asString();
JsonPath js1 = new JsonPath(update);


// 4.Get by Id Method .
given().log().all().header("authorization",Authentication_Manual.Bearer())
.pathParams("id",data)
.when().get("/api/core/v1/Materials/GetById/{id}")
.then()	.log().all().assertThat().statusCode(200).body("result.materialName", equalTo(materialName_patch));
 
// 5.Delete Method .
given().log().all().header("authorization",Authentication_Manual.Bearer())
.pathParams("id",data)
.when().delete("/api/core/v1/Materials/Delete/{id}")
.then().log().all().assertThat().statusCode(200).body("message", equalTo("Material deleted successfully."));
	

		
	}
}
