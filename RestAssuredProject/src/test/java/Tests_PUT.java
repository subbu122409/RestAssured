import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import static io.restassured.response.Response.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Tests_PUT {
	
	@Test
	public void test_03_PUT() {
	
	// Using Map topic we are preparing input payload JSON 
	
	JSONObject request = new JSONObject();
	
	  request.put("name", "Subbu");
	
	  request.put("Job", "Teacher");
	
   // System.out.println(request);
	
	System.out.println(request.toJSONString());
	
	
	  // Triggering PUT request using BDD
	
	   
	   given().
	          header("Content-Type","application/json").
	          contentType(ContentType.JSON).
	          accept(ContentType.JSON).	
	          body(request.toJSONString()).
	   
	   when().
	   
	         put("https://reqres.in/api/users/2").
	   
	   then().
		  
             statusCode(200).
             log().all();
             

	}
}
