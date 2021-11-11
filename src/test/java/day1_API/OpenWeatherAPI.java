package day1_API;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherAPI {
	@Test(enabled = false,description = "Getting weather API information generally")
	public void getWeatherInfo() {
//	  Given > Pre-condition like content type ,Authentication
//	  when > User performs somthing
//	  Then > expected outcome
		RestAssured.given()
		.when()
		 .get("http://api.openweathermap.org/data/2.5/weather?q=Pune&appid=c4153df7d29195116ba523d10f388d8d")
		.then()
		 .log()
		 .body()
		 .statusCode(200);

	}
	@Test(enabled = false,description = "Getting weather API information generally")
	public void getWeatherInfo2() {
//	  Given > Pre-condition like content type ,Authentication
//	  when > User performs somthing
//	  Then > expected outcome
	Response res=	RestAssured.given()
		          .when()
		           .get("http://api.openweathermap.org/data/2.5/weather?q=Pune&appid=c4153df7d29195116ba523d10f388d8d");
		
		 
		 System.out.println(res.prettyPrint());
	     System.out.println(res.getTime());
	     System.out.println(res.getStatusCode());
	     System.out.println(res.getContentType());

	}
	
	@Test(enabled = false,description = "Getting weather API information generally")
	public void getWeatherInfo3() {
//	  Given > Pre-condition like content type ,Authentication
//	  when > User performs somthing
//	  Then > expected outcome
		RestAssured.given()
		  .queryParam("q", "Pune")
		  .queryParam("appid", "c4153df7d29195116ba523d10f388d8d")
		.when()
		 .get("http://api.openweathermap.org/data/2.5/weather")
		.then()
		 .log()
		 .body()
		 .statusCode(200);

	}
	@Test(enabled = true,description = "Getting weather API information generally")
	public void getWeatherInfo4() {
//	  Given > Pre-condition like content type ,Authentication
//	  when > User performs somthing
//	  Then > expected outcome
		Map<String, String> param = new HashMap<String, String>();
		param.put("q", "Pune");
		param.put("appid", "c4153df7d29195116ba523d10f388d8d");
		RestAssured.given()
//		  .queryParam("q", "Pune")
//		  .queryParam("appid", "c4153df7d29195116ba523d10f388d8d")
		.when()
		 .get("http://api.openweathermap.org/data/2.5/weather")
		.then()
		 .log()
		 .body()
		 .statusCode(200);

	}
}
