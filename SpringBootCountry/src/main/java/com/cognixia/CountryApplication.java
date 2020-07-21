package com.cognixia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Assignment: Create Maven project in Spring Boot for displaying Country data
 * Requirements: 
 * -Print All Countries and their Capitals
 * -Using PathVariable, print the population of a given Country
 * -Must implement Model and Connector classes, no Database
 * 
 * Country objects have Name, Population, and Capital data
 */

@SpringBootApplication
public class CountryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryApplication.class, args);
	}

}