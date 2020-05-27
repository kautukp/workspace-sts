/**
 * 
 */
package com.example.propertyreader.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.propertyreader.model.Amazon;
import com.example.propertyreader.model.Country;

/**
 * @author USER
 *
 */
@RestController
public class CustomPropertyReader {

	@Value("${country.names}")
	private String countryName;

	@Value("${amazon.mobile.brand}")
	private String mobileBrand;

	@Autowired
	private Country country;

	@Autowired
	private Amazon amazon;

	@GetMapping("/countries")
	public String getCountryName() {
		return "Countries are: " + countryName;
	}

	
	@GetMapping("/mobiles")
	public String getMobileDetails() {
		return "Mobile brand: " + mobileBrand;
	}

	@PostConstruct
	private void printAtConsole() {
		System.out.println(country.getNames());
		System.out.println(country.getPopulation());
		System.out.println(country.getWeather());

		System.out.println(amazon.getBrand());
		System.out.println(amazon.getModel());
		System.out.println(amazon.getPrice());
		System.out.println(amazon.getDescription());
	}

}
