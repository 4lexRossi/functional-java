package highOrderFunction.supliers;

import java.util.function.Supplier;

public class Supliers {
	public static void main(String[] args) {
		Supplier<Person> newPerson = () -> new Person();
		System.out.println(newPerson.get());
		
		Supplier<Person> newPerson1 = Person::new; //reference Method
		System.out.println(newPerson1.get());
	}
}
