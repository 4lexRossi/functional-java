package functionsAnonimousLambda;

public class LambdaFunction {
	public static void main(String[] args) {
		Function mrPrefix = string -> "Mr. "+ string;
		System.out.println(mrPrefix.generate("Jack"));
	}
}