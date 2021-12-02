package ch07;

public class SuperTest {
	public static void main(String[] args) {
		Child c = new Child();
		c.method();
		System.out.println(c);
		System.out.println(c.toString());
//		만약에 참조변수에 "ch07.Child@15db9742"출력하지 않고 다르게 출력하고 싶다면?
//		toString() 오버라이딩하면된다.

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