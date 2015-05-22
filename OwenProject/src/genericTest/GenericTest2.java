package genericTest;

public class GenericTest2<T> {

	public T data;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static void main(String[] args) {
		
		GenericTest2<String> t2 = new GenericTest2<String>();
		
		t2.setData("이종민");
		System.out.println(t2.getData());
		
		GenericTest2<Integer> t3 = new GenericTest2<Integer>();
		
		t3.setData(100);
		System.out.println(t3.getData());
		
	}
	
}
