package highOrderFunction;

import java.util.function.Consumer;

public class Consumers {
	public static void main(String[] args) {
		
		Consumer<String> print = System.out::println;
		print.accept("Hello World");
		
		Consumer<String> print1 = sentence -> System.out.println(sentence);//lambda pure
		print1.accept("Hello World 1");
		
	}
}
