package org.opencoresoft.training.java8.examples.lambdas2;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.opencoresoft.training.java8.examples.pojos.Person;
import org.opencoresoft.training.java8.examples.utils.PersonUtils;

/**
 * Calls a utility method to perform a particular search
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class SocialNetworkingApp8 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons who are eligible for Selective Service:");

		int count = processPersonsWithFunction(
			    roster,
			    p -> p.getGender() == Person.Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25,
			    p -> p.getEmailAddress(),
			    email -> System.out.println(email)
			);

		System.out.printf("\nThere were %d persons in this category.\n", count);
	}

	public static int processPersonsWithFunction(List<Person> roster,
			Predicate<Person> tester, Function<Person, String> mapper,
			Consumer<String> block) {
		int count = 0;
		
		for (Person p : roster) {
			if (tester.test(p)) {
				++count;
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
		
		return count;
	}
}

