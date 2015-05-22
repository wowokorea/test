package listTest;

import java.util.ArrayList;
import java.util.List;


public class ListTest2 {

	public static void main(String[] args) {
		
		List<String> test1 = new ArrayList<String>();
		List<String> test2 = new ArrayList<String>();
		
		test1.add("이종민");
		test1.add("이종환");
		test1.add("이형근");
		test1.add("김명숙");
		
		System.out.println(test1.size());
		
		test2.addAll(test1.subList(0, 4));
		
		for (String string : test2) {
			System.out.println(string);	
		}
		
	}
	
}
