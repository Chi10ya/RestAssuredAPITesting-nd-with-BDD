import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//  API/WebServices Testing using RestAssured Part-2 - By SDET


public class TC005_GET_ValidatingJSONResponseBody {
	
	// Get - Request : Validating JSON Response Body
		
	@Test
	public void GetWeatherDetails(){
		// Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	
	// Request Object
		RequestSpecification httpRequest = RestAssured.given();
	
	// Response Object
		Response response=httpRequest.request(Method.GET,"/Ireland");

	// Print Response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is : "+responseBody);
		
		Assert.assertEquals(responseBody.contains("Ireland"), true);
			
	}

}
