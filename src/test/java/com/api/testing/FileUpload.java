package com.api.testing;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileUpload {
	
	@Test
	public void FileUploadFunction() {
		
		File fileToUpload = new File ("D:\\IMPORTANT\\Notes\\Rest Assured API Testing\\TestData\\listUsersResponseboody.json");
		
		Response response =given()
		  .multiPart("file",fileToUpload,"multipart/form-data")
		  
		  .when()
		  .post("https://the-internet.herokuapp.com/upload")
		  .thenReturn();
		
		System.out.println("Value of response"+response.getStatusCode());
		System.out.println("Value of response"+response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(), 200);
      
	}

}
