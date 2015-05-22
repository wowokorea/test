package objectTest;

public class ObjectTest {

	public void setTest(String...strings) {
		
		for (String string : strings) {
			System.out.println(string);
		}
		
	}
	
	public static void main(String[] args) {
		
		ObjectTest t = new ObjectTest();
		
		t.setTest("이종민", "이종환", "이형근", "김명숙");
		
		
	}
	
}
