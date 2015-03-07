package org.opencoresoft.training.java8.examples.streams.parallel;

import java.util.Collection;

import org.opencoresoft.training.java8.examples.pojos.Employee;
import org.opencoresoft.training.java8.examples.utils.EmployeeUtils;
import org.opencoresoft.training.java8.examples.utils.Timer;

/**
 * Calculating average salary of a large collection of employees.
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class EmployeeApp0 {
	
	private static final int COLLECTION_SIZE = 100000;

	public static void main(String[] args) {
		Collection<Employee> employeeCollection = 
				EmployeeUtils.generateEmployeeCollection(COLLECTION_SIZE);
		
		System.out.println("Calculating the average salary of employee collection...");
		
		Timer.start();
		
		Double sum = 0.0;
		for(Employee e : employeeCollection) {
			sum += e.getSalary();
		}
		Double averageSalary = sum/employeeCollection.size();

		Timer.stop();
		Timer.print();
		
		System.out.printf("Average salary of %,d employees in the collection is $%,.2f", COLLECTION_SIZE, averageSalary);
	}

}
