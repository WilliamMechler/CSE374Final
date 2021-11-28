import java.util.*;
import java.util.Map.Entry;

public class SeatingAlgorithm {
	
	public ArrayList<Person> finalOrder;
	
	public int maxSeatingOrder(ArrayList<Person> P) {
		
		//Map <Person, Integer> flexMap = new HashMap<Person, Integer>();
		Set <Person> unused = new HashSet<Person>(P); // maybe
		ArrayList <Person> finalOrder =  P;
		int finalHapp = 0;
		Person maxFlex = P.get(0);
		
		for(Person temp : P) { // loops through arraylist of people
			
			
			for (Entry<Person, Integer> entry : temp.relation.entrySet()) { // per person loop through their R{}
				if(!entry.getKey().equals(P)) {
					temp.flex += checkHap(entry.getKey(), temp);
				}
				
			}
			
			//flexMap.put(temp, temp.flex); // puts person in map as person as key and flexscore as value
			
			if(temp.flex > maxFlex.flex) { // finding person with highest flexscore
				maxFlex = temp;
			}
		}
		
		
		int left = 0;
		int right = 0;
		int maxFlexFlage = 1;
		while(!unused.isEmpty()) {
			if(maxFlexFlage == 1 && unused.contains(maxFlex)) {
				
				finalOrder.set(finalOrder.size()/2, maxFlex); // puts highest flex in the middle
				left = finalOrder.size()/2;
				right = finalOrder.size()/2;
				maxFlexFlage = 0;
				unused.remove(maxFlex);
			} else {
				//System.out.println("sup3 " + finalOrder.size() + " r" + right + " l" + left);
				//System.out.println(unused.size());
				Person next = (Person) unused.iterator().next();
				while(left > 0 && (finalOrder.size()-1-right) > 0) {
					
					
					if(checkHap(finalOrder.get(left), next) > checkHap(finalOrder.get(right), next)) {
						finalOrder.set(left, next);
						unused.remove(next);
						finalHapp += checkHap(finalOrder.get(left),next);
						left--;
						break;
					} else if (checkHap(finalOrder.get(left), next) < checkHap(finalOrder.get(right), next)) {
						finalOrder.set(right, next);
						unused.remove(next);
						finalHapp += checkHap(finalOrder.get(right),next);
						right++;
						break;
					} else {
						if(left < finalOrder.size()-1-right) {
							finalOrder.set(right, next);
							unused.remove(next);
							finalHapp += checkHap(finalOrder.get(right),next);
							right++;
							break;
						} else {
							finalOrder.set(left, next);
							unused.remove(next);
							finalHapp += checkHap(finalOrder.get(left),next);
							left--;
							break;
						}
					}
				}	
				
					if(left == 0) {
						finalOrder.set(right, next);
						unused.remove(next);
						finalHapp += checkHap(finalOrder.get(right),next);
						right++;
						continue;
					}
					if(right == finalOrder.size()-1) {				
						finalOrder.set(left, next);
						unused.remove(next);
						finalHapp += checkHap(finalOrder.get(left),next);
						left--;
						continue;
					}
				
			}
		} 
		
		
		this.finalOrder = finalOrder;
		return finalHapp;
	}
	
	public int checkHap(Person p1, Person p2) {
		int happ = 0;
		happ += p1.relation.get(p2);
		happ += p2.relation.get(p1);
		return happ;
	}
	
	public ArrayList<Person> getSeatingOrder() {
		return finalOrder;
	}
}
