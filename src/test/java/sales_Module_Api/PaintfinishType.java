package sales_Module_Api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseable_fields.Authentication_Manual;
import reuseable_fields.Payload;
import reuseable_fields.Reusablefields;

public class PaintfinishType {
	
	
	String data ;
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://sales-api-dev.colanapps.in";
		RestAssured.useRelaxedHTTPSValidation();
		
	}
	
	
	@Test(priority=1)
	public void paintfinishType_Getall() 
	{
		//1.GetAll Method
		
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.when().get("/api/core/v1/PaintFinishType/GetAll")
		.then().log().all().assertThat().statusCode(200);
		}
 
	@Test(priority=2,dependsOnMethods= "paintfinishType_Getall()")
	public void paintfinishType_Post() 
	{
		//2.Post Method
	String response =	given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body(Payload.paintfinishType())
		.when().post("/api/core/v1/PaintFinishType/Create")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js =new JsonPath(response);
		 data = js.getString("result");
		System.out.println("The ext_id is :"+ data);   
	}
	
	@Test(priority=3 ,dependsOnMethods= "paintfinishType_Post()")
	public void paintfinishType_Patch() 
	{
		//3.Patch Method
		String paintFinishType ="paint"+ Reusablefields.randomAlphabetic(4);
		 String  remarks ="reamrks"+Reusablefields.randomAlphabetic(4);
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"paintFinishType\": {\r\n"
				+ "    \"paintFinishTypeName\": \""+paintFinishType+"\",\r\n"
				+ "    \"remarks\": \""+remarks+"\",\r\n"
				+ "    \"salesEnquiryMainId\": 1081\r\n"
				+ "  },\r\n"
				+ "  \"extId\": \""+data+"\"\r\n"
				+ "}")
		.when().patch("/api/core/v1/PaintFinishType/Patch")
		.then().log().all().assertThat().statusCode(200);
			}
	
	//4.Get by Id Method
	@Test(priority=4,dependsOnMethods= "paintfinishType_Patch()")
	public void paintfinishType_GetById()
	{
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.pathParams("id",data)
		.when().get("/api/core/v1/PaintFinishType/GetById/{id}")
		.then().log().all().assertThat().statusCode(200);		
	}
	
	//5.Delete Method
	@Test(priority=5,dependsOnMethods= "paintfinishType_GetById()")
	public void painfinishType_delete()
	{
		
		given().log().all().header("authorization",Authentication_Manual.Bearer())
		.pathParams("id",data)
		.when().delete("/api/core/v1/PaintFinishType/Delete/{id}")
		.then().log().all().assertThat().statusCode(200);
	}
	
	
	
}
