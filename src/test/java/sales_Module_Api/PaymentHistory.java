package sales_Module_Api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;

import static io.restassured.RestAssured.*;

public class PaymentHistory {
	
	@Test
	public void paymentHistory()
	{
		//1.Get all Method
		RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/PaymentHistory/GetAll")
		.then().log().all().assertThat().statusCode(200) .extract().response().asString();
	JsonPath js = new JsonPath(response);
String data =	js.getString("result[0].extId");
System.out.println(data);

		//2.Get by Id Method
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.pathParams("id",data)
		.when().get("/api/core/v1/PaymentHistory/GetById/{id}")
		.then().log().all().assertThat().statusCode(200);
	}

}
