package com.api.testing;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;


import com.github.javafaker.Faker;

import groovy.util.logging.Log;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


public class ApachePOIexcelDDT {
	
	@DataProvider (name ="ddt")
	public Object  [] [] DDT  () throws IOException {
		
		String sheetno = "Sheet1";
		String filepath = "D:\\IMPORTANT\\Notes\\Rest Assured API Testing\\TestData\\TestData.xlsx";
		int RowCount = CreateUserDDTApproach5_Main.getrows(filepath, sheetno);
		int ColumnCount = CreateUserDDTApproach5_Main.getColumns(filepath, sheetno, RowCount);
		
		String empdata [] [] = new String [RowCount][ColumnCount];
		
		for (int i=1;i<=RowCount;i++) {
			for(int j=0;j<ColumnCount;j++) {
				empdata[i-1][j]= CreateUserDDTApproach5_Main.getCellData(filepath, sheetno, i, j);
			}
		}
		return(empdata);
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