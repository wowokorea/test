package listTest;

import java.util.ArrayList;
import java.util.List;

public class ListRemoveTest {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(5);
		list1.add(4);
		list1.add(3);
		list1.add(4);

		List<Integer> list2 = new ArrayList<Integer>();
		
		list2.add(1);
		list2.add(4);
		list2.add(3);
		
		List<Integer> list1Temp = new ArrayList<Integer>();
		list1Temp.addAll(list1);
		
		for (Integer info2 : list2) {
			
			boolean flag = true;
			int idx = 0;
			
			while(flag) {
				
				if (idx == list1.size() - 1) {
					flag = false;
				}
				
				if (String.valueOf(info2).equals(String.valueOf(list1.get(idx)))) {
					list1.remove(idx);
					idx = 0;
				} else {
					idx++;
				}
				
			}
			
			if (list1.size() == 0) {
				break;
			}
			
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("#######");
		for (Integer integer : list1) {
			System.out.println(integer);
		}
		System.out.println("#######");
		
	}
}

