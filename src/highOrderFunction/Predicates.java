package highOrderFunction;

import java.util.function.Predicate;

public class Predicates {
	public static void main(String[] args) {
		Predicate<String> isEmpty = value -> value.isEmpty();		
		System.out.println(isEmpty.test(""));
		System.out.println(isEmpty.test("Jack"));
		
		Predicate<String> isEmpty1 = String::isEmpty;//reference method
		System.out.println(isEmpty1.test(""));
		System.out.println(isEmpty1.test("Jack"));
	}
}
