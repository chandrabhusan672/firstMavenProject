package com.api.testing;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class BasicAuthetication {

	@Test

	public void BasicAuthAPI () {
		
		
		 given()
		
		.header("Accept" ,"application/json")
		.auth().basic("user", "passwd")
		
		
		.when()
		.get("https://httpbin.org/basic-auth/user/passwd")
		
		
		
		.then()
		.log().body()
		.log().ifStatusCodeIsEqualTo(200)
		.time(Matchers.lessThan(3000L))
		.header("content-type", "application/json")
		.body("authenticated", equalTo(true));
		
		
	}
}
