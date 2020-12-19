package highOrderFunction;

public class HighOrderFunction {
	public static void main(String[] args) {
		Calculate add = (a,b) -> a + b;
		Calculate subtraction = (a,b) -> a - b;
		Calculate division = (a,b) -> a / b;
		Calculate multiplication = (a,b) -> a * b;
		
		System.out.println(executeOperation(add, 1, 3));
		System.out.println(executeOperation(subtraction, 6, 4));
		System.out.println(executeOperation(division, 10, 2));
		System.out.println(executeOperation(multiplication, 7, 3));
	}
	
	public static int executeOperation(Calculate calculate, int a, int b) {
		return calculate.calculate(a,b);
	}

}
