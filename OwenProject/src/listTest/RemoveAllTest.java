package listTest;

import java.util.ArrayList;
import java.util.List;

public class RemoveAllTest {
	public static void main(String[] args) {
		
		List<String> a = new ArrayList<String>();
		
		a.add("1");
		a.add("3");
		a.add("7");
		a.add("8");
		a.add("9");
		a.add("10");
		
		
		List<String> b = new ArrayList<String>();
		
		b.add("3");
		b.add("9");
		b.add("1");
		
		a.removeAll(b);
		
		for (String str : a) {
			System.out.println(str);
		}
		
	}
}
