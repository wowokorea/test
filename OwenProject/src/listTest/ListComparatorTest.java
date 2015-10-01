package listTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListComparatorTest {

	public static void main(String[] args) {
		
		List<Integer> test1 = new ArrayList<Integer>();
		
		test1.add(3);
		test1.add(1);
		test1.add(null);
		test1.add(14);
		test1.add(null);
		test1.add(3);
		test1.add(3);
		test1.add(9);
		
		
		for (Integer integer : test1) {
			System.out.println(integer);
		}
		
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		
		Collections.sort(test1, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
			
				if (o1 != null && o2 != null) {
					if (o1 > o2) {
						return 1;
					} else if (o1 < o2) {
						return -1;
					} else {
						return 0;
					}
				} else {
					return 1;
				}
				
				
			}
			
			
		});
		
		for (Integer integer : test1) {
			System.out.println(integer);
		}
		
	}
	
}
