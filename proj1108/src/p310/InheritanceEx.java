package p310;

public class InheritanceEx {
	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		
		p.name = "강기룡";
		p.age = 27;
		c.phone = "010-0000-0000";
		
		p.printMethod();
		c.printMethod();
	}
}

class Parent{
	String name;
	int age;
	
	Parent(){}; //기본생성자
	
	void printMethod() {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		Child c = new Child();
		c.phone = "555-5555";
		c.printMethod();
	}
}

//상속을 하려면 자식이 1명의 부모를 선언
class Child extends Parent{
	String phone;
	Child(){};
	void printMethod() {
		name = "강기룡 자녀입니다";
		age = 0;
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("phone = " + phone);
	}
}