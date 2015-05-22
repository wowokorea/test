package reflect;

import java.util.ArrayList;
import java.util.List;

public class ReflectTest {

	public static void main(String[] args) {

		Model1 m1 = new Model1();
		m1.setName("이종민");
		m1.setAge(27);
		
		Model1 m2 = new Model1();
		m2.setName("이종환");
		m2.setAge(25);
		
		List<Model1> f1 = new ArrayList<Model1>();
		
		f1.add(m2);
		m1.setFamily(f1);
		
		Model1 m3 = new Model1();
		m3.setName("이종민");
		m3.setAge(27);

		Model1 m4 = new Model1();
		m4.setName("이종환");
		m4.setAge(25);

		List<Model1> f2 = new ArrayList<Model1>();
		
		f2.add(m4);
		m3.setFamily(f2);
		
		CompareUtilTest test = new CompareUtilTest();
		
		if (test.compare(m1, m3) == 0) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		
	}

}
