package restAssuredTest_BDD;

import org.apache.commons.lang3.RandomStringUtils;

public class RestAPIBDD_Utils_DataGeneration {
	
	public static String getFirstName(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
	}
	
	public static String getLastName(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Kenedy"+generatedString);
	}
	
	public static String getUserName(){
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("John"+generatedString);
	}
	
	public static String getPassword(){
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("John"+generatedString);
	}
	
	public static String getEmail(){
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return (generatedString+"_John"+"@gmail.com");
	}
	
	public static String empName(){
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
	}
	
	public static String empSal(){
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString);
	}
	
	public static String empAge(){
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}

}
