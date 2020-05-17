import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


//API/WebServices Testing using RestAssured Part-1 - By SDET

public class TC001_GET_Request {
	
// Get Request - Validating Status code and Status Line
	
	@Test
	void getWeatherDetails(){
		
		// Specify base URI
			RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		// Request Object
			RequestSpecification httpRequest = RestAssured.given();
		
		// Response Object
			Response response=httpRequest.request(Method.GET,"/Ireland");

		// Print Response in console window
			String responseBody = response.getBody().asString();
			System.out.println("Response body is : "+responseBody);
			Assert.assertTrue(responseBody!=null);
		
		// Status Code validation.
			int statusCode = response.getStatusCode();
			System.out.println("Status Code : "+statusCode);
			Assert.assertEquals(statusCode, 200);
			
		// Status Line verfification
			String statusLine=response.getStatusLine();
			System.out.println("Status Line : "+statusLine);
			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			
	}

}
