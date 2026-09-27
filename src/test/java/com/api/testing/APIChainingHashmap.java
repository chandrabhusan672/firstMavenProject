package com.api.testing;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import groovy.util.logging.Log;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class APIChainingHashmap {

	// Create user 
	
	Faker faker = new Faker ();
	int extractedID;
	
	@Test (priority = 1)
	public void CreateUser () {
		
		HashMap<String, String> requestBody = new HashMap<String, String>();
		
		 requestBody.put("name", faker.name().fullName());
		 requestBody.put("email", faker.internet().emailAddress());
		 requestBody.put("gender", faker.demographic().sex());
		 requestBody.put("status", "active");
		 
		 extractedID=given ()
		
		     .header("Accept","application/json")
		     .header("Content-Type","application/json")
		     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
		
		    .when()
		
		      .body(requestBody)
		     .post("https://gorest.co.in/public/v2/users")
		     .jsonPath().getInt("id");
		     
		//.then()
		  //  .log().body()
		  //  .log().status()
		    // .statusCode(200)
		   //  .time(Matchers.lessThan(2000L))
			 //.time(Matchers.both(Matchers.greaterThanOrEqualTo(1000L)).and(Matchers.lessThanOrEqualTo(2000L)));
}
	
	
	// Update the users details 
	
	@Test (priority = 2)
	public void UdpateUser () {
		
		
		HashMap<String, String> requestBody = new HashMap<String, String>();
		
		 requestBody.put("name", faker.name().fullName());
		 requestBody.put("email", faker.internet().emailAddress());
		 requestBody.put("gender", faker.demographic().sex());
		 requestBody.put("status", "active");
		 
		given ()
		
		     .header("Accept","application/json")
		     .header("Content-Type","application/json")
		     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
		
		.when()
		
		   .body(requestBody)
		     .patch("https://gorest.co.in/public/v2/users/"+extractedID)
		
		.then()
		    .log().body()
		    .log().status()
		     .statusCode(200)
		     .time(Matchers.lessThan(5000L));
			 //.time(Matchers.both(Matchers.greaterThanOrEqualTo(1000L)).and(Matchers.lessThanOrEqualTo(6000L)));
	}
	
	
	// Delete User

	@Test (priority = 3)
public void DeleteUsers () {
		
		
		given ()
		
	     .header("Accept","application/json")
	     .header("Content-Type","application/json")
	     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
	
	.when()
	     .delete("https://gorest.co.in/public/v2/users/"+extractedID)
	
	.then()
	     .log().body()
	     .log().status()
	     .statusCode(204)
	     .time(Matchers.lessThan(5000L));
		 //.time(Matchers.both(Matchers.greaterThanOrEqualTo(1000L)).and(Matchers.lessThanOrEqualTo(6000L)));
		
		
	}
}	
	
