package com.api.testing;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import groovy.util.logging.Log;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


public class CreateusersDDTApprocah2 {
	
	@DataProvider (name ="ddt")
	public Object DDT () {
		
		Object  [] [] requestBody = new Object[4][4];
		
		Faker faker = new Faker ();
		
		requestBody[0][0]=faker.name().fullName();
		requestBody[0][1]=faker.internet().emailAddress();
		requestBody[0][2]=faker.demographic().sex();
		requestBody[0][3]="Active";
		
		requestBody[1][0]=faker.name().fullName();
		requestBody[1][1]=faker.internet().emailAddress();
		requestBody[1][2]=faker.demographic().sex();
		requestBody[1][3]="Active";
		
		return requestBody;
	}
	
	@Test (dataProvider ="ddt")
	public void CreateUsersDDT (String name, String email, String gender,String status) {
		
		JSONObject requestBody = new JSONObject();
		

	      requestBody.put("name", name);
	      requestBody.put("email",email);
	      requestBody.put("gender",gender);
	      requestBody.put("status", status);
	      
	      given()
   
       .header("Accept","application/json")
       .header("Content-Type","application/json")
       .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56") 
  
   .when()
   
       .body(requestBody.toString())
       .post("https://gorest.co.in/public/v2/users")
     
	 .then()
	 
	 .log().body()
	 .statusCode(201);
	  
		
	}
	
	@Test (priority =2)
	public void ListUsers() {
    	
    	  given()
    	     .header("Accept","application/json")
    	     .header("Content-Type","application/json")
    	     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
    	
    	.when()
    	     .get("https://gorest.co.in/public/v2/users")
    	     
    	.then()
    	     .log().body();
}
}