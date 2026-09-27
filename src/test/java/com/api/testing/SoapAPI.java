package com.api.testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.internal.util.IOUtils;

import static io.restassured.RestAssured.*;

public class SoapAPI {
	
	@Test
	
	public void SoapAPIAddition () throws IOException {
		
		File file = new File ("./src/test/resources/AddRequestBody.xml");
		FileInputStream fis = new FileInputStream(file);    // read file content in bytes format
		String requestBody =org.apache.commons.io.IOUtils.toString(fis,"UTF-8"); // to Convert byte to string format
		
		given()
		
		.header("Content-Type","text/xml; charset=utf-8")
		.header("SOAPAction","http://tempuri.org/Add")
		
		.when()
		.body(requestBody)
		.post("http://www.dneonline.com/calculator.asmx?op=Add")
		
		.then()
		.statusCode(200)
		.time(Matchers.lessThan(4000L))
        .header("Content-Type","text/xml; charset=utf-8")
        .log().body()
        .body("//*:AddResult.text()",equalTo("90"));
		
	}

	
		@Test
		
		public void SoapAPISubtract () throws IOException {
			
			File file = new File ("./src/test/resources/RequestBodySubtract.xml");
			FileInputStream fis = new FileInputStream(file);    // read file content in bytes format
			String requestBody =org.apache.commons.io.IOUtils.toString(fis,"UTF-8"); // to Convert byte to string format
			
			given()
			
			.header("Content-Type","text/xml; charset=utf-8")
			.header("SOAPAction","http://tempuri.org/Subtract")
			
			.when()
			.body(requestBody)
			.post("http://www.dneonline.com/calculator.asmx?op=Subtract")
			
			.then()
			.statusCode(200)
			.time(Matchers.lessThan(4000L))
	        .header("Content-Type","text/xml; charset=utf-8")
	        .log().body()
	        .body("//*:AddResult.text()",equalTo("50"));
			
		}
		
		@Test
		
public void SoapAPIMultiply () throws IOException {
			
			File file = new File ("./src/test/resources/RequestBodyMultiply.xml");
			FileInputStream fis = new FileInputStream(file);    // read file content in bytes format
			String requestBody =org.apache.commons.io.IOUtils.toString(fis,"UTF-8"); // to Convert byte to string format
			
			given()
			
			.header("Content-Type","text/xml; charset=utf-8")
			.header("SOAPAction","http://tempuri.org/Multiply")
			
			.when()
			.body(requestBody)
			.post("http://www.dneonline.com/calculator.asmx?op=Multiply")
			
			.then()
			.statusCode(200)
			.time(Matchers.lessThan(4000L))
	        .header("Content-Type","text/xml; charset=utf-8")
	        .log().body()
	        .body("//*:AddResult.text()",equalTo("1500"));
			
		}
		
		@Test
public void SoapAPIDivide () throws IOException {
			
			File file = new File ("./src/test/resources/RequestBodyDivide.xml");
			FileInputStream fis = new FileInputStream(file);    // read file content in bytes format
			String requestBody =org.apache.commons.io.IOUtils.toString(fis,"UTF-8"); // to Convert byte to string format
			
			given()
			
			.header("Content-Type","text/xml; charset=utf-8")
			.header("SOAPAction","http://tempuri.org/Divide")
			
			.when()
			.body(requestBody)
			.post("http://www.dneonline.com/calculator.asmx?op=Divide")
			
			.then()
			.statusCode(200)
			.time(Matchers.lessThan(4000L))
	        .header("Content-Type","text/xml; charset=utf-8")
	        .log().body()
	        .body("//*:AddResult.text()",equalTo("5"));
			
		}
}

