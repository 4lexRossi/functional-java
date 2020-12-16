package fatorial;

import java.util.HashMap;
import java.util.Map;

public class FatorialMemoization {
	static Map<Integer, Integer> FATORIAL_MAP = new HashMap<>();
	public static void main(String[] args) {
		long I = System.nanoTime();
		System.out.println(memoizationFatorial(15));
		long F = System.nanoTime();
		System.out.println("FATORIAL 1 " + (F-I));
		
		I = System.nanoTime();
		System.out.println(memoizationFatorial(15));
		F = System.nanoTime();
		System.out.println("FATORIAL 2 " + (F-I));
	}
	public static Integer memoizationFatorial(Integer value) {
		if( value == 1) {
			return value;
		} else {
			if (FATORIAL_MAP.containsKey(value)) {
				return FATORIAL_MAP.get(value);
			} else {
			Integer result = value * memoizationFatorial(value -1);
			FATORIAL_MAP.put(value,  result);
			return result;
			}
		}
	}
}
