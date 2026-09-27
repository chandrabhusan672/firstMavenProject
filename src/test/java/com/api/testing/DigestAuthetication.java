package com.api.testing;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.*;
public class DigestAuthetication {
	
	@Test
	
	public void DigestAuthAPI () {
		
		given()
		
		.header("accept","application/json")
		.auth().digest("user", "passwd")
		
		
		.when()
		.get("https://httpbin.org/digest-auth/auth/user/passwd")
		
		
		.then()
		
		.log().body()
		.statusCode(200)
		.time(Matchers.lessThan(3000L))
		.header("content-type", "application/json")
		.body("authenticated", equalTo(true));
		
	}
	
	public class DigestAutheticationAPI2 {
		
		@Test
		
		public void DigestAuthAPI () {
			
			given()
			
			.header("accept","application/json")
			.auth().digest("user", "passwd")
			
			
			.when()
			.get("https://httpbin.org/digest-auth/auth/user/passwd/MD5")
			
			
			.then()
			
			.log().body()
			.statusCode(200)
			.time(Matchers.lessThan(4000L))
			.header("content-type", "application/json")
			.body("authenticated", equalTo(true));
			
		}

}
	
public class DigestAutheticationAPI3 {
		
		@Test
		
		public void DigestAuthAPI () {
			
			given()
			
			.header("accept","application/json")
			.auth().digest("user", "passwd")
			
			
			.when()
			.get("https://httpbin.org/digest-auth/auth/user/passwd/MD5/never")
			
			
			.then()
			
			.log().body()
			.statusCode(200)
			.time(Matchers.lessThan(4000L))
			.header("content-type", "application/json")
			.body("authenticated", equalTo(true));
			
		}

}
}
