package org.opencoresoft.training.java8.examples.lambdas1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.opencoresoft.training.java8.examples.pojos.City;
import org.opencoresoft.training.java8.examples.utils.TopCities;

/**
 * Uses a Comparator implementation (anonymous inner class) to sort the list of cities.
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class CityPopulation2 {

	public static void main(String[] args) {
		List<City> topCities = TopCities.getTopCities();
		
		Collections.sort(topCities, 
				new Comparator<City>() {
					public int compare(City c1, City c2) {
						// Reverse of natural order, from high to low
						return c2.getPopulation() - c1.getPopulation();
					}
				}
		);
		
		TopCities.printCities(topCities);
	}
}
