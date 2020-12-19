package highOrderFunction;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iterations {
	public static void main(String[] args) {
		String [] names = {"Jack", "Paul", "Kevin", "Steve", "Java", "Instructor"};
		Integer[] numbers = {1,2,3,4,5};
		printFilterNames(names);
		printAllNames(names);
	}

	private static void printFilterNames(String... names) {
		String namesToPrintFor = "";
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("Jack")) {
				namesToPrintFor += names[i] + " ";
			}
		}
		System.out.println("Using for: "+ namesToPrintFor);
		
		String namesToPrintStream = Stream.of(names)
				.filter(name -> name.equals("Jack"))
				.collect(Collectors.joining());
		System.out.println("Using Stream: "+ namesToPrintStream);
	}
	
	public static void printAllNames(String... names) {
		for (String name : names) {
			System.out.println("print all for " + name);
		}
		Stream.of(names)
			.forEach(name -> System.out.println("print all stream " + name));
		//	.forEach(System.out::println); //reference Method
	}
}
