package p311_1;

public class SuperEx2 {
	public static void main(String[] args) {
//		new A();
		new AA();
	}
}
class A{
	public A() {
		System.out.println("A클 기본생성자");
	}
	A(String n, int t){
		System.out.println("A클 명시적");	
	}
}
class AA extends A{
	public AA() {
//		super(); //생략됨
		super("kk",10);
		System.out.println("AA클 기본");
	}
	AA(int t, boolean e){
		System.out.println("AA클 명시적");
	}
}