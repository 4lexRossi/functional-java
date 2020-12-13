package FatorialRecursivo;

import java.util.function.UnaryOperator;

public class Imutability {
	public static void main(String[] args) {
		int value = 20;
		UnaryOperator<Integer> returnDouble = v -> v * 2;
		System.out.println(returnDouble.apply(value));//return double of value
		System.out.println(value);// value immutable
	}
}
