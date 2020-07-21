package com.cognixia.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class Country {

	private String name;
	private String capital;
	private int population;
	
	public Country () {
		
	}
		
	public Country(String name, String capital, int population) {
		super();
		this.name = name;
		this.capital = capital;
		this.population = population;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
}
