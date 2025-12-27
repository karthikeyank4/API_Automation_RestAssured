package reuseable_fields;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class Authentication_Manual {
 
	// one package  - Authentication , payloads & utilies
	//Requests 
	
	// Authentication - One class
	// Payload - one class - For post methods 
	//Utilies -one class
		     @Test
	         public static String auth_login()
	         {
	        	 RestAssured.baseURI ="https://sales-api-dev.colanapps.in";
	        	 RestAssured.useRelaxedHTTPSValidation();
	        String	response = given().log().all().header("Content-Type" , "application/json")
	        		.body("{\r\n"
	        				+ "  \"usernameOrEmail\": \"karthik@colan.com\",\r\n"
	        				+ "  \"password\": \"1234\"\r\n"
	        				+ "}")
	        	 .when().post("/api/transaction/v1/Auth/login")
	        	 .then().log().all().assertThat().statusCode(200).extract().response().asString();
	        	 JsonPath js= new JsonPath(response);
	        String ext_id =	 js.getString("result.accessToken");
	        	 System.out.println("the ext_id is:"+ext_id);
	        	 return ext_id ;
	        
	         }
		     
		     
//		     public static String newauth() {
//		    	 
//		    	 return "ext_id" ;
//		     }
//			
			public static String auth() 
			{
				
				return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI0IiwidW5pcXVlX25hbWUiOiJrYXJ0aGlrIiwiZW1haWwiOiJrYXJ0aGlrQGNvbGFuLmNvbSIsIm5iZiI6MTc2NTk4MDUzNywiZXhwIjoxNzY1OTkxMzM3LCJpYXQiOjE3NjU5ODA1MzcsImlzcyI6Ik15QXBwIiwiYXVkIjoiTXlBcHBDbGllbnRzIn0.s5QMBdeCARp4RWd03nz2pKPrp6H5u-Zt56cdkZzn_pw";
			}
			
			public static String Bearer()
			{
				
				return" Bearer " + auth() ;
				
			}
			
			
			
		
			 public static String randomAlphabetic(int length) 
			 {
				String chars ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" ;
				StringBuilder sb = new StringBuilder();
				Random random = new Random();
				
				for (int i = 0; i < length; i++) {
		            int index = random.nextInt(chars.length());  // pick random position
		            sb.append(chars.charAt(index)); 	
		           
				
			  }
				return sb.toString();
			 }
				
			
			

       
	
}


	



