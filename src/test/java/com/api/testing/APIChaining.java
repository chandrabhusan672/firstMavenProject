package com.api.testing;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import groovy.util.logging.Log;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

@Epic("E2E API Chanining")
@Feature("This features shows the create update and delete user in app")
public class APIChaining {

	// Create user 
	
	int extractedID;

	@Story("User story: Creating users randomly")
	@Step("Enter name email gemder status")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority = 1)
	public void CreateUser () {
		
		Faker faker = new Faker ();
		
		JSONObject requestBody = new JSONObject();
		
		 requestBody.put("name", faker.name().fullName());
		 requestBody.put("email", faker.internet().emailAddress());
		 requestBody.put("gender", faker.demographic().sex());
		 requestBody.put("status", "active");
		 
		 extractedID=given ()
		
		     .header("Accept","application/json")
		     .header("Content-Type","application/json")
		     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
		
		    .when()
		
		      .body(requestBody.toString())
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
	

	@Story("User story: Updating the users ")
	@Step("Enter the data to update the data")
	@Severity(SeverityLevel.CRITICAL)
	@Test (priority = 2)
	public void UdpateUser () {
		
		Faker faker = new Faker ();
		
		JSONObject requestBody = new JSONObject();
		
		 requestBody.put("name", faker.name().fullName());
		 requestBody.put("email", faker.internet().emailAddress());
		 requestBody.put("gender", faker.demographic().sex());
		 requestBody.put("status", "active");
		 
		given ()
		
		     .header("Accept","application/json")
		     .header("Content-Type","application/json")
		     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
		
		.when()
		
		   .body(requestBody.toString())
		     .patch("https://gorest.co.in/public/v2/users/"+extractedID)
		
		.then()
		    .log().body()
		    .log().status()
		     .statusCode(200)
		     .time(Matchers.lessThan(2000L));
			 //.time(Matchers.both(Matchers.greaterThanOrEqualTo(1000L)).and(Matchers.lessThanOrEqualTo(2000L)));
	}
	
	
	// Delete User

	@Test (priority = 3)
	@Story("User story: delete the users ")
	@Step("Enter the id to delete the users")
	@Severity(SeverityLevel.BLOCKER)
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
	     .time(Matchers.lessThan(2000L));
		// .time(Matchers.both(Matchers.greaterThanOrEqualTo(1000L)).and(Matchers.lessThanOrEqualTo(2000L)));
		
		
	}
}	
	
