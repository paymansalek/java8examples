package org.opencoresoft.training.java8.examples.streams2;

import java.util.List;

import org.opencoresoft.training.java8.examples.pojos.Person;
import org.opencoresoft.training.java8.examples.utils.PersonUtils;

/**
 * Pipelines and Streams: Aggregate Operations
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class PersonRoster01 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);

		System.out.println("List of all persons in the roster:");

		roster
			.stream()
			.forEach(p -> System.out.println(p));
	}

}
