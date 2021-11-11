package day1_API;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PositiveTest {
	String id;

	@Test(enabled = true,description = "For getting all contact list")
	public void getAllContactList() {
		given()
		.when()
		.get("http://3.13.86.142:3000/contacts")
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	@Test(enabled = true,description = "Adding contact")
	public void addContact() {
		JSONObject loc = new JSONObject();

		loc.put("city", "Pune");
		loc.put("country","India");
		JSONObject emp = new JSONObject();

		emp.put("jobTitle","Automation Tester");
		emp.put("company","LTI");
		JSONObject ob = new JSONObject();

		ob.put("firstName","Hrushi");
		ob.put("lastName","Bhalerao");
		ob.put("email","asmith@thinkingtester.com");
		ob.put("location",loc);
		ob.put("employee",emp);
		
		 id = given()
				.header("Content-Type","application/json")
				.body(ob.toJSONString())
				.when()
				  .post("http://3.13.86.142:3000/contacts")
				.then()
				  .log()
				  .body()
				  .statusCode(200)
				  .extract()
				  .jsonPath()
				  .get("id");


        System.out.println("Id is "+id);

		

				
	}
	@Test(enabled = true,dependsOnMethods = "addContact",description = "Getting specific contact")
	public void getSpecificContact() {
		given()
		  .when()
		      .get("http://3.13.86.142:3000/contacts/"+id)
		  .then()
		    .log()
		    .body()
		    .statusCode(200);
	}

}
