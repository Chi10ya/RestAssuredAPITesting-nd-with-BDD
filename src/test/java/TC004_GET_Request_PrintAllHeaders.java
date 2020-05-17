import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// API/WebServices Testing using RestAssured Part-2 - By SDET

public class TC004_GET_Request_PrintAllHeaders {
	
	// GET Request capturing all the headers from response.
	
	@Test
	public void GetWeatherDetails(){
		// Specify base URI
		RestAssured.baseURI="https://maps.googleapis.com";
	
	// Request Object
		RequestSpecification httpRequest = RestAssured.given();
	
	// Response Object
		Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,15101957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

	// Print Response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is : "+responseBody);
		
		Headers allHeaders = response.headers(); // capture all the headers from response
		
		for (Header header:allHeaders)
		{
			System.out.println(header.getName());
			System.out.println(header.getValue());
			
		}
	
	}

}
