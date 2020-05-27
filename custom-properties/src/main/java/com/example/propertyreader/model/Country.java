/**
 * 
 */
package com.example.propertyreader.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author USER
 *
 */
@Configuration
@ConfigurationProperties(prefix = "country")
public class Country {

	private String names;
	private String weather;
	private String population;

	/**
	 * @return the names
	 */
	public String getNames() {
		return names;
	}

	/**
	 * @param names
	 *            the names to set
	 */
	public void setNames(String names) {
		this.names = names;
	}

	/**
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}

	/**
	 * @param weather
	 *            the weather to set
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}

	/**
	 * @return the population
	 */
	public String getPopulation() {
		return population;
	}

	/**
	 * @param population
	 *            the population to set
	 */
	public void setPopulation(String population) {
		this.population = population;
	}

}
