package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
public class MaterialCategory {
	
	@Test
	public void materialCategory()
	{
		//1.Get All Method .
	RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
	RestAssured.useRelaxedHTTPSValidation();
	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.when().get("/api/core/v1/MaterialCategory/GetAll")
	.then().log().all().assertThat().statusCode(200);
	
	//2.Post Method 
String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.header("Content-Type","application/json")
	.body(Payload.materialCategory())
	.when().post("/api/core/v1/MaterialCategory/Create")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
JsonPath js = new JsonPath(response);
String data =js.getString("data");
System.out.println(data);

//3. patch Method.
String name = "materialCategory" + Authentication_Manual.randomAlphabetic(4);
String desc = "desc" + Authentication_Manual.randomAlphabetic(4);
given().log().all().header("authorization",Authentication_Manual.Bearer())
.header("Content-Type","application/json")
 .body("{\r\n"
 		+ "  \"materialCategory\": {\r\n"
 		+ "    \"id\": 6321,\r\n"
 		+ "    \"extId\": \""+data+"\",\r\n"
 		+ "    \"salesEnquiryMainId\": 7560,\r\n"
 		+ "    \"categoryName\": \""+name+"\",\r\n"
 		+ "    \"categoryDescription\": \""+desc+"\",\r\n"
 		+ "    \"materialId\": 4557,\r\n"
 		+ "    \"updatedBy\": 695\r\n"
 		+ "  }\r\n"
 		+ "}")
.when().patch("/api/core/v1/MaterialCategory/Patch")
.then().log().all().assertThat().statusCode(200);

//4.Get by Id Method.
given().log().all().header("authorization",Authentication_Manual.Bearer())
.pathParams("id","data")
.when().get("/api/core/v1/MaterialCategory/GetById/{id}")
.then().log().all().assertThat().statusCode(200);

// 5.Delete Method.
given().log().all().header("authorization",Authentication_Manual.Bearer())
.pathParams("id",data)
.when().delete("/api/core/v1/MaterialCategory/Delete/{id}")
.then().log().all().assertThat().statusCode(200);


		
	}

}
