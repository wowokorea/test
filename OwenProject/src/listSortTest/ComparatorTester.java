package listSortTest;

import java.util.Arrays;

public class ComparatorTester {
	
	public static void main(String[] args) {
		
		PeopleInfo[] pis = new PeopleInfo[2];

		pis[0] = new PeopleInfo();
		pis[0].setName("이종민");
		pis[0].setAge(28);
			  
		pis[1] = new PeopleInfo();
		pis[1].setName("이종환");
		pis[1].setAge(26);
		
		Arrays.sort(pis, new AgeComparator());
		for (PeopleInfo peopleInfo : pis) {
			System.out.println(peopleInfo.getName() + " : " + peopleInfo.getAge());
		}
		
		Arrays.sort(pis, new NameComparator());
		for (PeopleInfo peopleInfo : pis) {
			System.out.println(peopleInfo.getName() + " : " + peopleInfo.getAge());
		}
	}
	
}
