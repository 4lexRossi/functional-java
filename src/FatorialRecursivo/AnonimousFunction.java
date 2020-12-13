package FatorialRecursivo;

public class AnonimousFunction {
	public static void main(String[] args) {
		Function mrPrefix = new Function() {
			@Override
			public String generate(String string) { return "Mr. "+ string; }
		};
			System.out.println(mrPrefix.generate("JAck"));			
	}
}
