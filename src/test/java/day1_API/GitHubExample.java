package day1_API;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GitHubExample {
  @Test(enabled = false,description = "Getting all repositories")
  public void getAllRepo() {
	  given()
	      .auth() //Specifying authentication needed
	      .oauth2("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")//Github Token
	  .when()
	    .get("https://api.github.com/user/repos")
	  .then()
	     .log()
	     .body()
	     .statusCode(200)
	     .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS );

  }
  
  @Test(enabled = true,description = "Getting all repositories")
  public void addRepository() {
	  JSONObject js = new JSONObject();
	  js.put("name", "tsl968 restAssured");
	  js.put("description", "I am created by restAssured");
	  js.put("homepage", "https://github.com/Hrushi159");


	  given()
	      .auth() //Specifying authentication needed
	      
	      .oauth2("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")//Github Token
          .header("Content-Type","application/json")
          .body(js.toJSONString())
	      .when()
	    .post("https://api.github.com/user/repos")
	  .then()
	     .log()
	     .body()
	     .statusCode(201)
	     .time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS );

  }
}
