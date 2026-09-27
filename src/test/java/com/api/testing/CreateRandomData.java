package com.api.testing;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateRandomData {
    
	@Test
	public void randomdata () {
		
		Faker faker = new Faker ();
		
		System.out.println("City name"+faker.address().city());
		System.out.println("full name"+faker.name().fullName());
		System.out.println("DOB"+faker.date().birthday());
		System.out.println("Email"+faker.internet().emailAddress());
		
	}
}
