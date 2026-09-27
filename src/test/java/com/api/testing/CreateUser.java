package com.api.testing;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import groovy.util.logging.Log;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


public class CreateUser {
	
	@Test
	public void CreateUsers() {
		
		HashMap<String, String> requestBody = new HashMap<String, String>();
		
	
		
		 requestBody.put("name", "Joshuvaa");
		 requestBody.put("email", "F14@example.com");
		 requestBody.put("gender", "male");
		 requestBody.put("status", "active");
		 
		 given()
	     .header("Accept","application/json")
	     .header("Content-Type","application/json")
	     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
	
	.when()
	     .body(requestBody)
	     .post("https://gorest.co.in/public/v2/users")
	     
	.then()
	     .log().body()
	     .statusCode(201)
	   //  .log().headers()
	     .header("Content-Type","application/json; charset=utf-8");
	     //.body("[0].name", equalTo("SonnyHaves"))
	     //.body("[1].status", equalTo("active"));
		
	}

}
