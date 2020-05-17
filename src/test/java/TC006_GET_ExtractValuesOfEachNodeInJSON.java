import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//API/WebServices Testing using RestAssured Part-2 - By SDET

public class TC006_GET_ExtractValuesOfEachNodeInJSON {

	// Get - Request : Extract Values of Each Node in JSON.
		
	@Test
	public void GetWeatherDetails(){
		// Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	
	// Request Object
		RequestSpecification httpRequest = RestAssured.given();
	
	// Response Object
		Response response=httpRequest.request(Method.GET,"/Ireland");
		
		JsonPath jsonPath = response.jsonPath();

		System.out.println(jsonPath.get("City"));
		System.out.println(jsonPath.get("Temperature"));
		System.out.println(jsonPath.get("Humidity"));
		System.out.println(jsonPath.get("WeatherDescription"));
		System.out.println(jsonPath.get("WindSpeed"));
		System.out.println(jsonPath.get("WindDirectionDegree"));
		
		Assert.assertEquals(jsonPath.get("Temperature"), "39 Degree celsius");
			
	}

}

