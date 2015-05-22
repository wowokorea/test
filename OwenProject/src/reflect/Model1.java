package reflect;

import java.util.List;

public class Model1 {
	private String name;
	private int age;

	private List<Model1> family;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Model1> getFamily() {
		return family;
	}

	public void setFamily(List<Model1> family) {
		this.family = family;
	}
	
}
