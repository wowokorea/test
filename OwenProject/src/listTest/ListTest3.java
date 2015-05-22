package listTest;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ListTest3 implements Comparable<PeopleModel> {
	
	public static void main(String[] args) {
		
		List<PeopleModel> test1 = new ArrayList<PeopleModel>();
		List<PeopleModel> test2 = new ArrayList<PeopleModel>();
		
		SortedSet<PeopleModel> test3 = new TreeSet<PeopleModel>();
		
		PeopleModel p1 = new PeopleModel();
		p1.setName("이종민1");
		PeopleModel p2 = new PeopleModel();
		p1.setName("이종민2");
		PeopleModel p3 = new PeopleModel();
		p1.setName("이종민3");
		PeopleModel p4 = new PeopleModel();
		p1.setName("이종민4");
		
		test1.add(p1);
		test1.add(p2);
		test1.add(p3);
		test1.add(p4);
		
		PeopleModel p5 = new PeopleModel();
		p1.setName("이종민1");
		PeopleModel p6 = new PeopleModel();
		p1.setName("이종민2");
		PeopleModel p7 = new PeopleModel();
		p1.setName("이종민3");
		PeopleModel p8 = new PeopleModel();
		p1.setName("이종민4");
		PeopleModel p9 = new PeopleModel();
		p1.setName("이종민5");
		PeopleModel p10 = new PeopleModel();
		p1.setName("이종민6");
		PeopleModel p11 = new PeopleModel();
		p1.setName("이종민7");
		PeopleModel p12 = new PeopleModel();
		p1.setName("이종민8");
		
		test2.add(p5);
		test2.add(p6);
		test2.add(p7);
		test2.add(p8);
		test2.add(p9);
		test2.add(p10);
		test2.add(p11);
		test2.add(p12);
		
		for (PeopleModel p : test2) {
			test3.add(p);
		}
		
		for (PeopleModel p : test3) {
			System.out.println(p.getName());
		}
		
	}

	@Override
	public int compareTo(PeopleModel o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
