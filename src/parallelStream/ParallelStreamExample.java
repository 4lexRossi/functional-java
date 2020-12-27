package parallelStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static void main(String[] args) {
		//example 1
		long start = System.currentTimeMillis();
		IntStream.range(1, 100000).forEach(num -> fatorial(num));//Serial
		long end = System.currentTimeMillis();
		System.out.println("Execution Time serial "+ (end-start));
		
		start = System.currentTimeMillis();
		IntStream.range(1, 100000).parallel().forEach(num -> fatorial(num));//Parallel
		end = System.currentTimeMillis();
		System.out.println("Execution Time parallel "+ (end-start));
		
		//example 2
		List<String> names = Arrays.asList("Alex", "Elis", "Davi", "Estevão");
		
		names.stream().forEach(name -> System.out.println("Serial List: "+ name));	//Serial
		
		names.parallelStream().forEach(name -> System.out.println("Parallel List: "+ name)); //Parallel
	}
	
	public static long fatorial(long num) {
		long fat = 1;
		
		for (long i = 2; i <= num; i++) {
		fat *= i;
		}
		return fat;
	}

}
