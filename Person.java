import java.util.*;
public class Person {
	public Map <Person, Integer> relation = new HashMap<Person, Integer>();
	public String name;
	public int flex;
	
	public Person() {
		flex = 0;
	}
	
	public Person(Map<Person, Integer> R, String n) {
		relation = R;
		name = "";
		flex = 0;
	}
	
	public Map<Person, Integer> getR() {
		return relation;
	}
	public void setR(Map<Person, Integer> r) {
		relation = r;
	}
	public void setName(String n) {
		name = n;
	}
	public String toString() {
		return (name);
	}
}
