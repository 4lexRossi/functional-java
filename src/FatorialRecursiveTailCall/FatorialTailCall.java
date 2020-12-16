package FatorialRecursiveTailCall;

public class FatorialTailCall {
	public static void main(String[] args) {
		System.out.println(fatorialA(100));		
	}
	public static double fatorialA( double value ) {
		return fatorialTailCall(value, 1);
	}
	public static double fatorialTailCall(double value, double number) {
		if(value == 0) {
			return number;
		}
		return fatorialTailCall(value -1, number * value);
	}
}
