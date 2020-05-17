package restAssuredTest_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.testng.annotations.Test;

/* API Automation Testing using Rest Assured (BDD Approach) - By SDET
 * 
 * given()
 * 	set cookies, add auth, add param, set headers info etc
 * 
 * when()
 * 	get, post, put, delete
 * 
 * then()
 * 	validate status code, extract response, extract headers cookies & response body
 * 
 * Validations
 * -	Status Code
 * -	Status Line
 * -	Response Body
 * -	Header
 * 
 *  */
// Tutorial 2: --- GET Request *************************

public class Demo1_Get_Request {
	
	public static HashMap map = new HashMap();
	
	@Test
	public void getWeatherDetails()
	{
		given()
		
		.when()
				.get("http://restapi.demoqa.com/utilities/weather/city/Cork")
		
		.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("City",  equalTo("Cork"))
				.header("Content-Type",  "application/json")
				.log().all();
	}

// Tutorial 3:	--- POST Request *************************************
	
	@Test
	public void Demo2_Post_Request() {
	
		map.put("FirstName", RestAPIBDD_Utils_DataGeneration.getFirstName());		
		map.put("LastName", RestAPIBDD_Utils_DataGeneration.getLastName());
		map.put("UserName", RestAPIBDD_Utils_DataGeneration.getUserName());
		map.put("Password", RestAPIBDD_Utils_DataGeneration.getPassword());
		map.put("Email", RestAPIBDD_Utils_DataGeneration.getEmail());
	
			RestAssured.baseURI = "http://restapi.demoqa.com/customer";
			RestAssured.basePath = "/register";
	}
	
	@Test
	public void testPost() {
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.and()
			.body("SuccessCode", equalTo("OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation completed successfully"))
			.log().all();
	}


// Tutorial 4:	--- PUT Request *************************************
	
	@Test
	public void putData(){
		String empName = RestAPIBDD_Utils_DataGeneration.empName();
		String empSalary = RestAPIBDD_Utils_DataGeneration.empSal();
		String empAge = RestAPIBDD_Utils_DataGeneration.empAge();
		int empID = 11254;
				
		map.put("name", empName);
		map.put("salary",empSalary);
		map.put("age", empAge);
			
			RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
			RestAssured.basePath = "/update/"+empID;		
	}
	
	@Test
	public void testPut(){
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
	}
	
// Tutorial 5:	--- DELETE Request *************************************	

	@Test
	public void deleteEmployeeRecord(){
		//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/delete/11493";		
		
		Response response=
		
		given()
			.when()
				.delete()
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();			
		
		String jsonAsString= response.asString();
		Assert.assertEquals(jsonAsString, contains("successfully! deleted Records"), true);
	}
	
/*
 * 	Tutorial 6: --- API/Webservices testing using RestAssured BDD approach | Validations in JSON response.
 * 	1: Test status code
 * 	2: Log Response
 * 	3: Verifying singe content in response body
 * 	4: Verifying multiple content in response body
 * 	5: Setting parameters & headers
 */
	
	@Test
	public void testStatusCode(){
		// 1: Test Status Code
		
		given()
			.when()
				.get("http://jsonplaceholder.typicode.com/posts/5")
			.then()
				.statusCode(200)
				.log().all();
	}
	
	@Test
	public void testLoggingResponse(){
		// 2: Log Response
		
		given()
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
				.statusCode(200)
				.log().all();
	}
	
	@Test
	public void testSingleContentInResponse(){
		// 3: Verifying singe content in response body
		
		given()
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
				.statusCode(200)
				.body("RestResponse.result.name", equalTo("India"))
				.log().all();
	}
	
	@Test
	public void testMultipleContentInResponse(){
		// 4: Verifying multiple content in response body
		
		given()
			.when()
				.get("http://services.groupkt.com/country/get/all")
			.then()
				.statusCode(200)
				.body("RestResponse.result.name", hasItems("India", "UAE", "Ireland", "Canada", "United States of America"))
				.log().all();
	}
	
	@Test
	public void testParametersAndHeaders(){
		// 5: Setting parameters & headers
		
		given()
			.param("MyName", "Chaitanya")
			.header("MyHeader", "Indian")
			.when()
				.get("http://services.groupkt.com/country/get/iso2code/IN")
			.then()
				.statusCode(200)
				.log().all();
	}
	
/*
 * Tutorial 7 : -- API/Webservices testing using RestAssured BDD approach | Validations in XML response.
 * 1: Verifying single content in XML response
 * 2: Verifying multiple contents in XML response
 * 3: Verifying all the content in XML response in one go
 * 4: Find all values using XML path in XML response
 * 5: XPath with text() function
 */
	
	@Test
	public void testSingleContent(){
		// 1: Verifying single content in XML response
		given()
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
			.then()
				.body("CUSTOMER.ID", equalTo("15"))
				.log().all();		
	}
	
	@Test
	public void testMultipleContents(){
		// 2: Verifying multiple contents in XML response
		given()
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
			.then()
				.body("CUSTOMER.ID", equalTo("15"))
				.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
				.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
				.body("CUSTOMER.STREET", equalTo("319 Upland P1."))
				.body("CUSTOMER.CITY", equalTo("Seattle"))
				.log().all();
	}

	@Test
	public void testMultipleContentsInOneGo(){
		given()
		.when()
		.then()
		.log().all();
	}
	
		
/*
* Tutorial 9 - API / Webservices testing using RestAssured BDD | Serialization & De-serialization JSON
*  
*/
	
	// With HasMap and without Serialization and De-serialization
	
	@Test
	public void createNewStudent(){
	//POST request
		
		map.put("id", 101);
		map.put("firstName", "Chaitanya");
		map.put("lastName", "Kumar");
		map.put("email", "abc@xyz.com");
		map.put("programme", "Manager");
		
			ArrayList<String> coursesList = new ArrayList<String>();
			coursesList.add("Java");
			coursesList.add("Selenium");
			
		map.put("courses", coursesList);
			
			given()
				.contentType(ContentType.JSON)
				.body(map)
			.when()
				.post("http://localhost:8085/student")
			.then()
				.statusCode(201)
				.assertThat()
				.body("msg", equalTo("Student added"));
	}
	
	@Test
	public void getStudentRecord(){
	//GET request
		
		given()
			.when()
				.get("http://localhost:8085/student/101")
			.then()
				.statusCode(200)
				.assertThat()
				.body("id", equalTo(101))
				.log().all();
	}

	
	// With Serialization and De-serialization
	@Test
	// Serialization
	public void createNewStudentSerialization(){
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
			Student stu = new Student();
			stu.setId(101);
			stu.setFirstName("Chaitanya");
			stu.setLastName("Mohammad");
			stu.setEmail("abc@gmail.com");
			stu.setPrograme("Computer Science");
			stu.setCourses(coursesList);
			
			given()
				.contentType(ContentType.JSON)
				.body(stu)
			.when()
				.post("http://localhost:8085/student")
			.then()
				.statusCode(201)
				.assertThat().body("msg", equalTo("Student added"));
	}
		
	@Test
	// Deserialization
	public void getStudentRecordDeSerialization(){
		Student stu = get("http://localhost:8085/student/101").as(Student.class);
		System.out.println("Student # :"+stu.getId());
		Assert.assertEquals(stu.getId(),101);
	}
	
/*
* Tutorial 10 - API / Webservices testing using RestAssured BDD | Serialization & De-serialization XML
*/
	
	
	
	
}


