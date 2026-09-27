package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import groovy.util.logging.Log;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


public class CreateRandomUserJavaFakeLibrary {
	
	Faker faker = new Faker ();
	
	@Test
	public void CreateUsers() {
		
		HashMap<String, String> requestBody = new HashMap<String, String>();
		
		 requestBody.put("name", faker.name().fullName());
		 requestBody.put("email", faker.internet().emailAddress());
		 requestBody.put("gender", faker.demographic().sex());
		 requestBody.put("status", "active");
		 
		 Response response = given()
	     .header("Accept","application/json")
	     .header("Content-Type","application/json")
	     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
	
        .when()
	     .body(requestBody)
	     .post("https://gorest.co.in/public/v2/users");
		 
		 Assert.assertEquals(response.getStatusCode(), 201);
		 Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
		 Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
		 
		 System.out.println("Status Code is >>"+response.getStatusCode());
		 System.out.println("Status line"+response.getStatusLine());
		 System.out.println("Response time"+response.getTime());
		 System.out.println("ResponseBody"+response.getBody());
	     
	//.then()
	    // .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("PostAPIJsonSchemaValidator.json"))
	     //.log().body()
	   // .statusCode(201)
	   //  .log().headers()
	   //  .header("Content-Type","application/json; charset=utf-8");
	     //.body("[0].name", equalTo("SonnyHaves"))
	     //.body("[1].status", equalTo("active"));
		
	}

}
