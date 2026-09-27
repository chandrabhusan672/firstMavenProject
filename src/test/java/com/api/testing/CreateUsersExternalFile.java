package com.api.testing;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class CreateUsersExternalFile {
	
	@Test
	public void createUsersExtfile () throws FileNotFoundException {
		
		File file = new File(".\\src\\test\\resources\\UpdateUsers.json"); // locate the file 
		FileReader fr = new FileReader (file);                         // open + read the file 
		JSONTokener jt = new JSONTokener(fr);                         // Read the json file as byte streams
		JSONObject requestBody = new JSONObject(jt);                    // Read the json file as json schema
		
		
		
		 given()
	     .header("Accept","application/json")
	     .header("Content-Type","application/json")
	     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
	
	.when()
	     .body(requestBody.toString())
	     .post("https://gorest.co.in/public/v2/users")
	     
	.then()
	     .log().body()
	     .statusCode(201)
	   //  .log().headers()
	     .header("Content-Type","application/json; charset=utf-8")
		 //.body("name",equalTo("haves"))
		 .time(Matchers.lessThan(2000L))
		 // response time >1  second but less than 2 seconds
		 .time(Matchers.both(Matchers.greaterThanOrEqualTo(1000L)).and(Matchers.lessThanOrEqualTo(2000L)));
	   
		
	}

}
