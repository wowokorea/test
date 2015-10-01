package listTest;

import java.util.ArrayList;

public class ListCompareToArray {

	public static void main(String[] args) {
		
		
		ArrayList<String> testList = new ArrayList<String>();
		
		testList.add("1");
		testList.add("3");
		
		String[] testArray = {"1", "3", "2", "4"};
		
		ArrayList<String> testList2 = new ArrayList<String>();
		
		for (String string : testArray) {
			testList2.add(string);
		}
		
		for (int i = 0; i < testList2.size(); i++) {
			
			if (!testList.contains(testList2.get(i))) {
				
				System.out.println("걸림");
				
			}
				
		}
		
		
	}
	
}
