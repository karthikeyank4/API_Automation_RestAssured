package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

public class MaterialSpecification {

	@Test
	public void materialSpecification()
	{
		//Get Method
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();

		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/MaterialSpecification/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method
	String Response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.materialSpecification())
		.when().post("/api/core/v1/MaterialSpecification/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
	 JsonPath js = new JsonPath(Response);
	String result = js.getString("result");
	System.out.println(result);
	
	//3.Patch Method .
	String previousCostingEstimationNumber  ="Costing"+ Reusablefields.randomAlphabetic(5);
	String lpoNumber ="iponumber" +Reusablefields.randomAlphabetic(4);
	String competitor ="competitor"+Reusablefields.randomAlphabetic(5);
	String specificInfoRemarks ="remarks" +Reusablefields.randomAlphabetic(5);
String upadte =	given().log().all().header("authorization",Authentication_Manual.Bearer())
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "  \"materialSpecification\": {\r\n"
			+ "    \"id\": 271,\r\n"
			+ "    \"extId\": \""+result+"\",\r\n"
			+ "    \"salesEnquiryMainId\": 6838,\r\n"
			+ "    \"materialId\": 9747,\r\n"
			+ "    \"previousCostingEstimationNumber\": \""+previousCostingEstimationNumber+"\",\r\n"
			+ "    \"quotationId\": 9564,\r\n"
			+ "    \"lpoNumber\": \""+lpoNumber+"\",\r\n"
			+ "    \"competitor\": \""+competitor+"\",\r\n"
			+ "    \"specificInfoRemarks\": \""+specificInfoRemarks+"\",\r\n"
			+ "    \"updatedBy\": 3006\r\n"
			+ "  }\r\n"
			+ "}")
	.when().patch("/api/core/v1/MaterialSpecification/Patch")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();

//4 .Get Method by id
given().log().all().header("authorization",Authentication_Manual.Bearer())
.pathParams("id",result)
.when().get("/api/core/v1/MaterialSpecification/GetById/{id}")
.then().log().all().assertThat().statusCode(200);

// 5.Delete Method by id
given().log().all().header("authorization",Authentication_Manual.Bearer())
.pathParams("id",result)
.when().delete("/api/core/v1/MaterialSpecification/Delete/{id}")
.then().log().all().assertThat().statusCode(200);
	
		
		
	}
}
