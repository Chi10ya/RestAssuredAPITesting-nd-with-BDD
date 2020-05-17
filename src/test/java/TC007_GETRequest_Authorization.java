import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GETRequest_Authorization {
	
	//API/WebServices Testing using RestAssured Part-2 - By SDET

	// Get Request - Authorization
	
		@Test
		void getWeatherDetails(){
			
			// Specify base URI
				RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";

			// Basic Authentication
				PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
				authScheme.setUserName("ToolsQA");
				authScheme.setPassword("TestPassword");
				RestAssured.authentication=authScheme;
				
			// Request Object
				RequestSpecification httpRequest = RestAssured.given();
			
			// Response Object
				Response response=httpRequest.request(Method.GET,"/");

			// Print Response in console window
				String responseBody = response.getBody().asString();
				System.out.println("Response body is : "+responseBody);
			
			// Status Code validation.
				int statusCode = response.getStatusCode();
				System.out.println("Status Code : "+statusCode);
				Assert.assertEquals(statusCode, 200);
		}
}
