package sales_Module_Api;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Dummy2;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;

public class InstallationEquipment {
	
	@Test
	public void installationEquipmentApi()
	{
		
		//1.GetAll Method .
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
	
		String delete = given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/InstallationEquipment/GetAll")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
	
	// 2.Post Method .
	String response = given().log().all().header("Content-Type","application/json")
	.header("authorization",Authentication_Manual.Bearer())
	.body(Payload.installationEquipment())
    .when().post("/api/core/v1/InstallationEquipment/Create")
    .then().log().all().assertThat().statusCode(201).extract().response().asString();
	JsonPath js =new JsonPath(response)	;
String data =	js.getString("data");
System.out.println(data);

//3.patch Method 
String remark = "Update the patch ";
given().log().all().header("Content-Type","application/json")
.header("authorization",Authentication_Manual.Bearer())
.body("{\r\n"
		+ "  \"installationEquipment\": {\r\n"
		+ "    \"extId\": \""+data+"\",\r\n"
		+ "    \"equipmentName\": \"string\",\r\n"
		+ "    \"heightInstallation\": 9241.793805686271,\r\n"
		+ "    \"remarks\": \""+remark+"\"\r\n"
		+ "  }\r\n"
		+ "}")
	.when().patch("/api/core/v1/InstallationEquipment/Patch")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
//4.Get Method 
String update =given().log().all().header("authorization",Authentication_Manual.Bearer()).pathParams("id",data)
.when().get("/api/core/v1/InstallationEquipment/:id")
.then().log().all().assertThat().log().all().assertThat().statusCode(200).extract().response().asString();
JsonPath js1 =new JsonPath(update);
String verify= js1.getString("data.remarks");
Assert.assertEquals(verify, remark );
		
	}

}
