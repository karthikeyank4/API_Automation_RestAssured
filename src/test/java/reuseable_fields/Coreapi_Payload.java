package reuseable_fields;

public class Coreapi_Payload {
	
	
	public static String cityMaster()
	{
		String  Cityname ="city"+Reusablefields.randomAlphabetic(5);
		String postal ="post"+Reusablefields.randomAlphabetic(4);
		return"{\r\n"
				+ "  \"stateId\": 0,\r\n"
				+ "  \"cityName\": \""+Cityname+"\",\r\n"
				+ "  \"postalCode\": \""+postal +"\"\r\n"
				+ "}";
	}
	
	
	

}
