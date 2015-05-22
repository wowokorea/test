package gsonTest;

import com.google.gson.Gson;

public class GsonTest {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		TestModel m1 = new TestModel();
		m1.setName("이종민");
		m1.setAge(28);

		TestModel m2 = new TestModel();
		
		/*
		TestModel m2 = new TestModel();
		m2.setName("이종환");
		m2.setAge(26);
		*/
		
		gson.toJson(m1);
		
		m2 = gson.fromJson(
				"{'name':'이종환', 'age':26}"
				, TestModel.class
				);
		
	
		System.out.println("이름 : " + m2.getName());
		System.out.println("나이 : " + m2.getAge());
		
	}
	
}
