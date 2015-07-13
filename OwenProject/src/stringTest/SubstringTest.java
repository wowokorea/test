package stringTest;

public class SubstringTest {
	public static void main(String[] args) {
		
		/*
		String postNo = "12345";
		
		System.out.println(postNo.substring(0, 3));
		System.out.println(postNo.substring(3));
		*/
		
		
		String phoneNo = "010123";
		
		phoneNo = phoneNo.substring(0, phoneNo.length() <= 11 ? phoneNo.length() : 11);
		
		String no1 = "";
		String no2 = "";
		String no3 = "";

		if (phoneNo.length() >= 10) {
			no1 = phoneNo.substring(0, 3);
			no2 = phoneNo.substring(3, phoneNo.length() - 4);
			no3 = phoneNo.substring(phoneNo.length() - 4, phoneNo.length());
		} else if (phoneNo.length() >= 8 && phoneNo.length() <= 9) {
			no1 = phoneNo.substring(0, 3);
			no2 = phoneNo.substring(3, 7);
		} else if(phoneNo.length() >= 6 && phoneNo.length() <= 7) {
			no1 = phoneNo.substring(0, 3);
			no2 = phoneNo.substring(3, phoneNo.length());
		} else if(phoneNo.length() >= 3) {
			no1 = phoneNo.substring(0, 3);
		}

		System.out.println(no1);
		System.out.println(no2);
		System.out.println(no3);
		
		
	}
}
