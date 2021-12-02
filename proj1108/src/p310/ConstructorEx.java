package p310;

public class ConstructorEx {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Parent("ȫ�浿");
		Parent p3 = new Parent(30);
		Parent p4 = new Parent("1234");
	}
}

class Parent{
	String name;
	int age;
	String phone;
	public Parent() {}
	public Parent(String name) {
		this.name = name;
	}
	public Parent(int age) {
		this.age = age;
	}
}
