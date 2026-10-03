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


public class E2EAPIChaninig {
	
	
	                        // Create User 
	int ExtractedID;
	@Test (priority =1)
	public void createuser() {
		
		Faker faker = new Faker ();
		
		JSONObject requestbody = new JSONObject ();
		
		      requestbody.put("name", faker.name().fullName());
		      requestbody.put("email",faker.internet().emailAddress());
		      requestbody.put("gender",faker.demographic().sex());
		      requestbody.put("status", "active");
		      
		      ExtractedID= given()
	     
	         .header("Accept","application/json")
	         .header("Content-Type","application/json")
	         .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56") 
	    
	     .when()
	     
	         .body(requestbody.toString())
	         .post("https://gorest.co.in/public/v2/users")
	         .jsonPath().getInt("id");
	         
	     //.then()
	     
	     // .log().body()
	     // .log().status()
	     // .statusCode(201);
	      
		
		
	}

	                            // Get created Users
	
	@Test (priority =2)
	public void GetCreatedUser() {
		
		given()
		
		  .header("Accept","application/json")
		  .header("Content-Type","application/json")
		  .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
		  
		
		.when()
		
	        .get("https://gorest.co.in/public/v2/users/"+ExtractedID)
		
		.then()
		
		.log().body()
		.statusCode(200);
		//System.out.println("Created user is "+ExtractedID);
	}
	
	
	
	                   // Update the created user 
	@Test (priority =3)
	public void UpdateUsers() {
		
		     Faker faker = new Faker ();
		     
		     JSONObject requestbody = new JSONObject ();
		     
		     requestbody.put ("name",faker.name().fullName());
		     requestbody.put("email", faker.internet().emailAddress());
		     requestbody.put("gender",faker.demographic().sex());
		     requestbody.put("status", "active");
		     	      
		
		given()
		 
		  .header("Accept","application/json")
		  .header("Content-Type","application/json")
		  .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
		
		.when()
		   
		.body(requestbody.toString())
		.put("https://gorest.co.in/public/v2/users/"+ExtractedID)
		
		.then()
		
		.log().body()
		.statusCode(200);
		System.out.println("Updated user is"+ExtractedID);
		
		
	}
	
	
	
                   // Get the updated user 
	
	@Test (priority=4)
	public void GetUpdatedUser() {
		
		given()
		
		  .header("Accept","application/json")
		  .header("Content-Type","application/json")
		  .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
		  
		
		.when()
		
	        .get("https://gorest.co.in/public/v2/users/"+ExtractedID)
		
		.then()
		
		.log().body()
		.statusCode(200);
		System.out.println("Get Updated user is "+ExtractedID);
	}
	
	
	
	
	               // Delete user 
	
	@Test (priority =5)
	public void DeleteUser() {
		
		given()
		
		  .header("Accept","application/json")
		  .header("Content-Type","application/json")
		  .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
		  
		
		.when()
		
	        .delete("https://gorest.co.in/public/v2/users/"+ExtractedID)
		
		.then()
		
		.log().body();
		//.statusCode(200);
		System.out.println("Deleted user is "+ExtractedID);
		
			
		
	}
	
	
	                 // Verify the deleted user 
	
	@Test (priority =6)
	public void VeirfyDeletedUser() {
		
		given()
		
		  .header("Accept","application/json")
		  .header("Content-Type","application/json")
		  .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
		  
		
		.when()
		
	        .get("https://gorest.co.in/public/v2/users/"+ExtractedID)
		
		.then()
		
		.log().body();
		//.statusCode(200);
		System.out.println("Verify deleted  user is "+ExtractedID);
	}
}
