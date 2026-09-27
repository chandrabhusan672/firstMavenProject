package com.api.testing;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;


public class TestDataDDT {

	Faker faker = new Faker ();
		@DataProvider (name ="CreateUserddt")
		public Object [][] DDTCreateUser () {
			
			return new Object [][] {
	
			{faker.name().fullName(),faker.internet().emailAddress(),faker.demographic().sex(),"Active"},
			{faker.name().fullName(),faker.internet().emailAddress(),faker.demographic().sex(),"Active"},
			{faker.name().fullName(),faker.internet().emailAddress(),faker.demographic().sex(),"Active"},
			{faker.name().fullName(),faker.internet().emailAddress(),faker.demographic().sex(),"Active"},
			{faker.name().fullName(),faker.internet().emailAddress(),faker.demographic().sex(),"Active"},
			{faker.name().fullName(),faker.internet().emailAddress(),faker.demographic().sex(),"Active"},
			{faker.name().fullName(),faker.internet().emailAddress(),faker.demographic().sex(),"Active"},
				
			
			};
	}

		@DataProvider (name ="Deleteuserddt")
		public Object [] DDTdeleteuser () {
			
			return new Object [] {
					8528229,8528236	       
		};
			
  }
			
}
