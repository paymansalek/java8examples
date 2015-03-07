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
public class SocialNetworkingApp9 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons who are eligible for Selective Service:");

		int count = processElements(
			    roster,
			    p -> p.getGender() == Person.Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25,
			    p -> p.getEmailAddress(),
			    email -> System.out.println(email)
			);

		System.out.printf("\nThere were %d persons in this category.\n", count);
	}

	public static <X, Y> int processElements(Iterable<X> source,
			Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
		int count = 0;
		for (X p : source) {
			if (tester.test(p)) {
				++count;
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
		
		return count;
	}
}

/**
 * This method invocation performs the following actions:
 * 
 * 1) Obtains a source of objects from the collection source. In this example, it obtains a source of Person objects from the collection roster. 
 * Notice that the collection roster, which is a collection of type List, is also an object of type Iterable.
 * 
 * 2) Filters objects that match the Predicate object tester. In this example, the Predicate object is a lambda expression that specifies which members 
 * would be eligible for Selective Service.
 * 
 * 3) Maps each filtered object to a value as specified by the Function object mapper. In this example, the Function object is a lambda expression 
 * that returns the e-mail address of a member.
 * 
 * 4) Performs an action on each mapped object as specified by the Consumer object block. In this example, the Consumer object is a lambda expression that prints a string, 
 * which is the e-mail address returned by the Function object.
 * 
 * You can replace each of these actions with an aggregate operation.
 */

