package p310;

public class InheritanceEx {
	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		
		p.name = "�����";
		p.age = 27;
		c.phone = "010-0000-0000";
		
		p.printMethod();
		c.printMethod();
	}
}

class Parent{
	String name;
	int age;
	
	Parent(){}; //�⺻������
	
	void printMethod() {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		Child c = new Child();
		c.phone = "555-5555";
		c.printMethod();
	}
}

//����� �Ϸ��� �ڽ��� 1���� �θ� ����
class Child extends Parent{
	String phone;
	Child(){};
	void printMethod() {
		name = "����� �ڳ��Դϴ�";
		age = 0;
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("phone = " + phone);
	}
}