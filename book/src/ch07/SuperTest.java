package ch07;

public class SuperTest {
	public static void main(String[] args) {
		Child c = new Child();
		c.method();
		System.out.println(c);
		System.out.println(c.toString());
//		���࿡ ���������� "ch07.Child@15db9742"������� �ʰ� �ٸ��� ����ϰ� �ʹٸ�?
//		toString() �������̵��ϸ�ȴ�.

	}
}
class Parent extends Object{
	int x = 10;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
class Child extends Parent{
	int x = 20;
	
	void method() {
		System.out.println("x = " + x);
		System.out.println("this.x = " + this.x);
		System.out.println("super.x = " + super.x);
	}
}