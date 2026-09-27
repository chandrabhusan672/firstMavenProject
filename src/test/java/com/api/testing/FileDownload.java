package com.api.testing;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileDownload {

	@Test
	public static void FileDownloadFunction() throws IOException {	
		
		Response response =given ()
		 
		  .header("Accept","application/json")
 	     .header("Content-Type","application/json")
 	     .header("Authorization","Bearer 66dd51ab5eade37a9009ba4a29bbaf43e68b2950ebdbb1b38cd07de1430d2f56")
 	     
 	     .when()
 	     
 	        .get("https://gorest.co.in/public/v2/users")
 	        .thenReturn();
 	     
		System.out.println("Value of response"+response.getStatusCode());
		System.out.println("Value of response"+response.getBody());
        Assert.assertEquals(response.getStatusCode(), 200);
        
        byte[] responseBytes= response.getBody().asByteArray();
        File file = new File("D:\\IMPORTANT\\Notes\\Rest Assured API Testing\\TestData\\listUsersResponseboody.json");
        Files.write(file.toPath(), responseBytes);
        
	}

}
