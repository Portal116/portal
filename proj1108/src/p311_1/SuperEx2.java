package p311_1;

public class SuperEx2 {
	public static void main(String[] args) {
//		new A();
		new AA();
	}
}
class A{
	public A() {
		System.out.println("AŬ �⺻������");
	}
	A(String n, int t){
		System.out.println("AŬ �����");	
	}
}
class AA extends A{
	public AA() {
//		super(); //������
		super("kk",10);
		System.out.println("AAŬ �⺻");
	}
	AA(int t, boolean e){
		System.out.println("AAŬ �����");
	}
}