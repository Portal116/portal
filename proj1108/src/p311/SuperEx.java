package p311;

public class SuperEx {
	public static void main(String[] args) {
		A a = new A();
		a.setName("부모님 성함");
//		System.out.println(a.getName());
		
		AA1 aa1 = new AA1();
		aa1.setName("자식 이름");
//		System.out.println(aa1.getName());
		
		aa1.pMethod();
		
		AA2 aa2 = new AA2();
		aa2.pM();
	}
}

class A{
	String ida;
	String name;
	int age;
	
	public String getIda() {
		return ida;
	}

	public void setIda(String ida) {
		this.ida = ida;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class AA1 extends A{
	String idaa1;
	String name;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdaa1() {
		return idaa1;
	}

	public void setIdaa1(String idaa1) {
		this.idaa1 = idaa1;
	}
	void calA1() {
		this.idaa1 = "100";
		super.ida = "200";
	}

	public void pMethod() {
		super.name = "상속관계에서 부모이름";
		System.out.println(this.name);
		System.out.println(super.name);
	}
	
}

class AA2 extends A{
	String idaa2;
	int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdaa2() {
		return idaa2;
	}
	public void setIdaa2(String idaa2) {
		this.idaa2 = idaa2;
	}
	public void pM() {
		super.age = 50;
		this.age = 20;
		System.out.println(super.age);
		System.out.println(this.age);
	}
	
}