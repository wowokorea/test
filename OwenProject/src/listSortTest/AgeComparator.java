package listSortTest;

import java.util.Comparator;

public class AgeComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		
		int age1 = ((PeopleInfo)o1).getAge();
		int age2 = ((PeopleInfo)o2).getAge();
		
		if (age1 > age2) {
			return 1;
		} else if (age1 < age2) {
			return -1;
		}
		
		return 0;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
