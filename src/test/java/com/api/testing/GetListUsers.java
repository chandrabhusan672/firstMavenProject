package com.api.testing;

import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetListUsers {
	
    private RequestSpecification header;

	@Test
	public void ListUsers() {
    	
    	given()
    	     .header("Accept","application/json")
    	     .header("Content-Type","application/json")
    	     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
    	
    	.when()
    	     .get("https://gorest.co.in/public/v2/users/")
    	     
    	.then()
    	     .log().body()
    	     .log().ifStatusCodeIsEqualTo(200)
    	   //  .log().headers()
    	     //.body("gender",hasItems("female","male"))
    	     //.body("status", hasItems("active","inactive"))
    	     .header("Content-Type","application/json; charset=utf-8");
    	    // .body("[0].name", equalTo("Ganak Johar DVM"))
    	     //.body("[1].status", equalTo("inactive"));
    	     
    	  
    	 
    	  
		    
	}
}
