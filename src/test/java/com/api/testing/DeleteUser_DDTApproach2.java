package com.api.testing;

import java.util.HashMap;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DeleteUser_DDTApproach2 {
	
	@DataProvider (name ="ddt")
	public Object [] DDT () {
		
		return new Object [] {
					8528526,8528527	       
	};
		
}
	
	@Test (dataProvider = "ddt")
	public void DeleteUsers (Object idToDelete) {
		
		
		given ()
		
	     .header("Accept","application/json")
	     .header("Content-Type","application/json")
	     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
	
	.when()
	     .delete("https://gorest.co.in/public/v2/users/"+idToDelete)
	
	.then()
	    .log().body()
	    .log().status()
	     .statusCode(204);
	     //.time(Matchers.lessThan(2000L));
		System.out.println("Deleted ID are"+idToDelete);
		 //.time(Matchers.both(Matchers.greaterThanOrEqualTo(1000L)).and(Matchers.lessThanOrEqualTo(2000L)));
		
		
	}

}
