package listTest;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public List<String> createList1() {
		
		List<String> list1 = new ArrayList<String>(); 
		
		for (int i = 0; i < 50; i++) {
			list1.add(String.valueOf(i));
		}
		
		return list1;
	}
	
	public List<String> createList2() {
		
		List<String> list2 = new ArrayList<String>(); 
		
		for (int i = 0; i < 30; i++) {
			list2.add(String.valueOf(i));
		}
		
		return list2;
	}

	public List<String> createList3() {
		
		List<String> list3 = new ArrayList<String>(); 
		
		for (int i = 20; i < 40; i++) {
			list3.add(String.valueOf(i));
		}
		
		return list3;
	}
	
	public static void main(String[] args) {
		
		ListTest test = new ListTest();

		List<String> list1 = test.createList1();
		List<String> list2 = test.createList2();
		List<String> list3 = test.createList3();
		
		for (String string : list1) {
			System.out.println(string);
		}
		
		System.out.println("------------------------------------");
		
		for (String string : list2) {
			System.out.println(string);
		}
		
		System.out.println("------------------------------------");
		
		for (String string : list3) {
			System.out.println(string);
		}
	
		System.out.println("------------------------------------");
		
		System.out.println(list1.containsAll(list2));
		System.out.println(list1.containsAll(list3));
		
		list1.removeAll(list2);
		list1.removeAll(list3);
		
		for (String string : list1) {
			System.out.println(string);
		}
		
	}
	
}
