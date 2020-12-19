package highOrderFunction;

public class HighOrderFunction {
	public static void main(String[] args) {
		Calculate sum = (a,b) -> a + b;
		System.out.println(executeOperation(sum, 1, 3));
	}
	
	public static int executeOperation(Calculate calculate, int a, int b) {
		return calculate.calculate(a,b);
	}

}
