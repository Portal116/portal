package p298;

public class ThisEx01 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A(123, 3.4);
	}
}
class A{
	A(){
		this("a", 5);
		System.out.println("�⺻������");
	}
	A(int i, double d){
		System.out.println("����� ������1 " + i + " " + d);
	}
	A(String name, int c){
		System.out.println("����� ������2");
	}
}