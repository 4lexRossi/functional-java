package highOrderFunction;

import java.util.function.Function;

public class Functions {
	public static void main(String[] args) {
		Function<String,String> printStringReverse = text -> new StringBuilder(text).reverse().toString();
		System.out.println(printStringReverse.apply("Jack"));
		
		Function<String,Integer> printConvertedStringtoInt = Integer::valueOf; //reference method
		System.out.println(printConvertedStringtoInt.apply("20"));
		
		Function<String,Integer> printConvertedStringtoIntMultByTwo = convertString -> Integer.valueOf(convertString) * 2;
		System.out.println(printConvertedStringtoIntMultByTwo.apply("20"));
	}
}
