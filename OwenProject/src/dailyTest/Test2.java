package dailyTest;
/*
 ex)
 int a = 1;
 String b= "world";

 String result = template("A: {} B: {}", a, b);


 출력:  
 System.out.println(result); 

 ->
 A: 1 B: world
 */

public class Test2 {

	public String userFormat(String template, Object... objects) {
		
		StringBuffer sb = new StringBuffer();
		String result = template;
		Object[] srcs = objects;
		
		sb.append(result);
		
		for (Object object : srcs) {
			sb.replace(sb.toString().indexOf("{"), sb.toString().indexOf("{") + 2, object.toString()); 
		}
		
		return sb.toString();  
	}
	
	public static void main(String[] args) {

		int a = 1;
		String b = "world";
		long c = 10L;
		float f = 10.1F;

		// 포맷 방식
		System.out.format("A : {%s} B : {%s} C : {%s}", a, b, c);
		
		System.out.println();
		
		// UserFormat방식
		Test2 t2 = new Test2();
		System.out.println(t2.userFormat("A : {}", a));
		System.out.println(t2.userFormat("A : {} B : {}", a, b));
		System.out.println(t2.userFormat("A : {} B : {} C : {}", a, b, c));
		System.out.println(t2.userFormat("A : {} B : {} C : {} D : {}", a, b, c, f));
		
		
	}

}
