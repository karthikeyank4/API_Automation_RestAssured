package reuseable_fields;

import java.util.Random;

public class Reusablefields {
	
	
	
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
