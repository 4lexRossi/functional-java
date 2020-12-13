package FatorialRecursivo;

import java.util.function.UnaryOperator;

public class Class {
	public static void main(String[] args) {
		// Imperative Paradigm
		int value = 10;
		int result = value * 3;
		System.out.println("The result is :: " + result);
		
		// Functional Paradigm
		UnaryOperator<Integer> multiplicateValueTre = functionalValue -> functionalValue*3;
		int functionalValue = 10;
		System.out.println("The result is :: " + multiplicateValueTre.apply(functionalValue));
	}
}
