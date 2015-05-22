package listTest;

import java.util.ArrayList;
import java.util.List;

public class ListTest0508 {
	public static void main(String[] args) {
		
		List<String> aaa = new ArrayList<String>();
		List<String> bbb = new ArrayList<String>();

		aaa.add(new String("이종민"));
		aaa.add(new String("이종환"));
		aaa.add(new String("김명숙"));
		aaa.add(new String("이형근"));
		
		bbb.add(new String("김명숙"));
		bbb.add(new String("이종환"));
		
		
		/*aaa.removeAll(bbb);
		
		for (String string : aaa) {
			System.out.println(string);
		}*/
		
		System.out.println(aaa.containsAll(bbb));
		
		
	}
}
