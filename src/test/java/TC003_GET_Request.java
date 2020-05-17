import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// API/WebServices Testing using RestAssured Part-1 - By SDET

public class TC003_GET_Request {
	
	// Get Request validating the Headers part
	
		@Test
		void getWeatherDetails(){
			
			// Specify base URI
				RestAssured.baseURI="https://maps.googleapis.com";
			
			// Request Object
				RequestSpecification httpRequest = RestAssured.given();
			
			// Response Object
				Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,15101957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

			// Print Response in console window
				String responseBody = response.getBody().asString();
				System.out.println("Response body is : "+responseBody);
			
			// Verifying the header part. For to know the headers that are being used, copy the above provide complete URL and post it in PostMan.
			// Capture details of headers from response and verifying the Content Type
				String contentType = response.header("Content-Type");
				System.out.println("Content Type is :"+contentType);
				Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
						
			// Capture details of headers from response and verifying the Content Encoding
				String contentEncoding = response.header("Content-Encoding");
				System.out.println("Content Type is :"+contentEncoding);
				Assert.assertEquals(contentType, "gzip");
							
		}

	}


