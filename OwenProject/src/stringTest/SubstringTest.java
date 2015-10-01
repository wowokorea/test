package stringTest;

public class SubstringTest {
	public static void main(String[] args) {
		
		/*
		String postNo = "12345";
		
		System.out.println(postNo.substring(0, 3));
		System.out.println(postNo.substring(3));
		*/
		
		
		String phoneNo = "010123456789";
		
		phoneNo = phoneNo.substring(0, phoneNo.length() <= 11 ? phoneNo.length() : 11);
		
		String no1 = "";
		String no2 = "";
		String no3 = "";

		no1 = phoneNo.substring(0, 3);
		if (phoneNo.length() >= 8) {
			no2 = phoneNo.substring(3, 7);
			no3 = phoneNo.substring(7, phoneNo.length());
		} else if (phoneNo.length() > 3 && phoneNo.length() < 8) {
			no2 = phoneNo.substring(3, phoneNo.length());
		}

		System.out.println(no1);
		System.out.println(no2);
		System.out.println(no3);
		
		
	}
}
