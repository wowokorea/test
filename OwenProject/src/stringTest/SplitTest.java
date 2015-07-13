package stringTest;

public class SplitTest {

	public static void main(String[] args) {
		
		String phoneNo = "010-6388-6417";
		
		String[] testArr = phoneNo.split("-");
		
		System.out.println(testArr.length);
		
		for (String string : testArr) {
			System.out.println(string);
		}
		
	}

}
