package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

public class Invoicerefrence {

	@Test
	public void invoicerefrence() {
		
		//1.Get  All Method .
		
		RestAssured .baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		given().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/InvoiceReferences/GetAll")
		.then().log().all().assertThat().statusCode(200);
		
		//2.Post Method 
		
	String response =	given().log().all().header("Content-Type","application/json")
		.header("authorization",Authentication_Manual.Bearer())
		.body(Payload.invoiceRefrence())
		.when().post("/api/core/v1/InvoiceReferences/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(response);
	String data =	js.getString("data");
	System.out.println(data);
	
	// 3.Patch method 
	String type = "Update the patch method"+ Reusablefields.randomAlphabetic(5);
String update =	given().log().all().header("Content-Type","application/json")
	.header("authorization",Authentication_Manual.Bearer())
	.body("{\r\n"
			+ "  \"extId\": \""+data+"\",\r\n"
			+ "  \"invoiceRefernces\": {\r\n"
			+ "    \"invoiceType\": \""+type+"\",\r\n"
			+ "    \"invoiceId\": 4143,\r\n"
			+ "    \"invoiceDate\": \"1973-08-09T03:13:36.821Z\",\r\n"
			+ "    \"amount\": 9962.895876376535\r\n"
			+ "  }\r\n"
			+ "}")
	.when().patch("/api/core/v1/InvoiceReferences/Patch")
	.then().log().all().extract().response().asString();
System .out.println (update);
JsonPath js1 = new JsonPath(update);
String verify =js1.get("data.invoiceType");
Assert.assertEquals(verify,  type);

//4.Get Method .
String updated =given().log().all().header("authorization",Authentication_Manual.Bearer())
.pathParams("id",data)
.when().get("/api/core/v1/InvoiceReferences/GetById/{id}")
.then().log().all().assertThat().statusCode(200).extract().response().asString();
System.out.println(updated);


		
	}
}
