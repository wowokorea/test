package listSortTest;

import java.util.Comparator;

public class NameComparator implements Comparator<Object> {
	
	@Override
	public int compare(Object o1, Object o2) {
		
		String name1 = ((PeopleInfo)o1).getName();
		String name2 = ((PeopleInfo)o2).getName();
		
		return name1.compareTo(name2);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
