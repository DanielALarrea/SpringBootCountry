package com.cognixia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.model.Country;

@RestController
@RequestMapping("/country")
public class CountryController {

	@GetMapping("hello")
	public String sayHello()
	{
		return "Hello from Country App";
	}
	
	@GetMapping("all")
	public String printCountries()
	{
		List<Country> countryList = initCountries();
		String allCountries = "";
		for(Country co: countryList) {
			allCountries += "Country: " + co.getName() + ", Capital: " + co.getCapital() + "\n";
		}
		
		return allCountries;
	}
	
	@GetMapping("{name}/population")
	public String printPopulation(@PathVariable String name)
	{
		Country country = compareName(name);
		return "The population of " + country.getName() + " is: " + country.getPopulation() + " million";
	}
	
	@GetMapping("{name}/capital")
	public String printCapital(@PathVariable String name)
	{
		Country country = compareName(name);
		return "The capital of " + country.getName() + " is " + country.getCapital();
	}
	
	@GetMapping("compare")
	public String sayComparePopulation(@RequestParam String name1, @RequestParam String name2)
	{
		Country country1 = compareName(name1);
		Country country2 = compareName(name2);
		if(country1.getPopulation() != -1 && country2.getPopulation() != -1) {
			if (country1.getPopulation() > country2.getPopulation()) {
				return country1.getName() + " has a higher population than " + country2.getName();
			} else if (country2.getPopulation() > country1.getPopulation()) {
				return country2.getName() + " has a higher population than " + country1.getName();
			} else if (country1.getPopulation() == country2.getPopulation()) {
				return country1.getName() + " has the same population as " + country2.getName();
			} else {
				return "Some error has occured. Ensure the country names are valid";
			}
		} else {
			return "Some error has occured. Ensure the country names are valid";
		}
	}
	
	public List<Country> initCountries() {
		List<Country> allCountries = new ArrayList<>();
		
		allCountries.add(new Country("United States", "Washington D.C.", 325));
		allCountries.add(new Country("Spain", "Madrid", 67));
		allCountries.add(new Country("France", "Paris", 47));
		allCountries.add(new Country("Canada", "Ottowa", 38));
		allCountries.add(new Country("Germany", "Berlin", 83));
		
		return allCountries;
	}
	
	private Country compareName(String name) {
		Country country = new Country("No Name", "No Capital", -1);
		List<Country> countryList = initCountries();
		for(Country co: countryList) {
			if(name.equalsIgnoreCase(co.getName())) {
				country = co;
			}
		}
		return country;
	}
}