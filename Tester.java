import java.util.*;
public class Tester {

	public static void main(String[] args) {
		
		
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		
		ArrayList<Person> inputList = new ArrayList<Person>();
		ArrayList<Person> outputOrder = new ArrayList<Person>();
		
		
		
		Map<Person, Integer> p1R = Map.of(
				p1, 0,
			    p2, 0,
			    p3, 1
			);
		
		Map<Person, Integer> p2R = Map.of(
			    p1, 1,
			    p2, 0,
			    p3, -1
			);
		
		Map<Person, Integer> p3R = Map.of(
			    p1, 1,
			    p2, 1,
			    p3, 0
			);
		
		p1.setR(p1R);
		p2.setR(p2R);
		p3.setR(p3R);
		
		p1.setName("p1");
		p2.setName("p2");
		p3.setName("p3");
		
		inputList.add(p1);
		inputList.add(p2);
		inputList.add(p3);
		
		SeatingAlgorithm temp = new SeatingAlgorithm();
		System.out.println(inputList.size());
		inputList.trimToSize();
		int happ = temp.maxSeatingOrder(inputList);
		System.out.println(happ);
		System.out.println("supFinal");
		
		for(Person p : temp.finalOrder) {
			System.out.println(p.toString());
		}

              
	}

// end of main

}
