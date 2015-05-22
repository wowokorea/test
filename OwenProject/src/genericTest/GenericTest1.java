package genericTest;

public class GenericTest1 {

	public Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		GenericTest1 t1 = new GenericTest1();
		t1.setData("이종민");
		
		System.out.println(t1.getData());
		
		GenericTest1 t2 = new GenericTest1();
		t2.setData(100);
		
		System.out.println(t2.getData());
		
	}
	
}
