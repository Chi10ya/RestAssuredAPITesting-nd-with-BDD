package data.driven.pkg;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

//API/WebServices Testing using RestAssured Part-3 | Data Driven Testing - By SDET

public class DataDrivenTest_AddNewEmployees {
		
	@Test(dataProvider="empdataprovider")
	
	void postNewEmployees(String eName, String empSal, String empAge){
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		
		// Here we created data which we can send along with the post request.
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name",eName);
		requestParams.put("salary",empSal);
		requestParams.put("age",empAge);
		
		// Add a header stating the request body is a JSON
		httpRequest.header("Content-Type", "application/json");
		
		// Add the JSON to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//Post Request
		Response response = httpRequest.request(Method.POST, "/create");
		
		// Capture response body to perform the validations
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body : "+responseBody);
		
		
		Assert.assertEquals(responseBody.contains(eName), true);
		Assert.assertEquals(responseBody.contains(empSal), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);		
	}
	
	@DataProvider(name="empdataprovider")
	
	String[][] getEmpData(){ // This is data provider method 
		
		// For (Excell Util) to read the data from Excel file and passing the values to the array. Watch the video API/Webservices Testing using RestAssured Part-3 | Data Driven Testing from 40 mins onwards
		
		/* 
		 * String exlPath = System.getProperty("user.dir")+"/src/test/java/data/driven/pkg/empData.xlsx";
		 * 
		 *  int rowCount=XLUtils.getRowCount(exlPath, "Sheet1");
		 *  int colCount=XLUtils.getCellCount(exlPath, "Sheet1", 1);
		 *  
		 *  String empData[][]=new String[rownCount][colCount];
		 *  
		 *  for (int i=1; i<=rowCount; i++){
		 *  	for(int j=0; j<colCount; j++){
		 *  		empData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
		 *  	}
		 *  }
		 */
		
		String empData[][] = {{"Alexandria Dedario", "30000", "40"}, {"Kaira Advani", "40000", "30"}};
		return (empData);
	}
}
