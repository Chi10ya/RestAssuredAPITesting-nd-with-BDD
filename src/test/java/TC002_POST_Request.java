import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// API/WebServices Testing using RestAssured Part-1 - By SDET

public class TC002_POST_Request {
	 
//Post Request
	
	@Test
	void postRegistrationSuccessful(){
		
		// Specify base URI
			RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		// Request Object
			RequestSpecification httpRequest = RestAssured.given();
		
		// Request payload sending along with post request
			JSONObject requestParams = new JSONObject();
			requestParams.put("FirstName", "Alexandria");
			requestParams.put("LastName", "Dedario");
			requestParams.put("Username", "Alex");
			requestParams.put("Password", "Alex123");
			requestParams.put("Email", "Alex@gmail.com");
			
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(requestParams.toJSONString()); // attach data to the request
			
		// Response Object
			Response response=httpRequest.request(Method.POST, "/register");
									
		// Print Response in console window
			String responseBody = response.getBody().asString();
			System.out.println("Response body is : "+responseBody);
			Assert.assertTrue(responseBody!=null);
		
		// Status Code validation.
			int statusCode = response.getStatusCode();
			System.out.println("Status Code : "+statusCode);
			Assert.assertEquals(statusCode, 201);
					
			String successCode = response.jsonPath().get("SuccessCode");
			Assert.assertEquals(successCode, "OPERATION_SUCCESS");
			
	}

}


