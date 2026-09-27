package com.api.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class BearerTokenAuthetication {
	
	@Test
	public void BearerAuthAPI () {
		
		given()
		
		.header("accept","application/json")
		.header("Authorization","Bearer 2345")
		
		
		.when()
		.get("https://httpbin.org/bearer")
		
		
		.then()
		
		.log().body()
		.statusCode(200)
		.time(Matchers.lessThan(4000L))
		.header("content-type", "application/json")
		.body("authenticated", equalTo(true));
	}

}
