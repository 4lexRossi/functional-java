package highOrderFunction.supliers;

public class Person {
	private String name;
	private Integer age;
	
	public Person() {
		name = "Alex";
		age = 34;
	}
	
	@Override
	public String toString() {
		return String.format("name: %s, age: %d", name, age);
	}
}
