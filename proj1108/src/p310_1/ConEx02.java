package p310_1;

public class ConEx02 {
	public static void main(String[] args) {
		A a = new A("»çÅÁ");
		A a1 = new A("À½·á¼ö", 10);
		A a2 = new A(true);
		A a3 = new A(new B());
		
		System.out.println(a.kind);
		System.out.println(a1.kind + " " + a1.count);
		System.out.println(a2.ok);
		System.out.println(a3.b);
	}
}

class A{
	String kind;
	int count;
	boolean ok;
	B b;
	
	A(){};
	A(String kind){
		this.kind = kind;
	}
	public A(String kind, int count) {
		this.kind = kind;
		this.count = count;
	}
	public A(boolean ok) {
		this.ok = ok;
	}
	public A(B b) {
		// TODO Auto-generated constructor stub
	}
}

class B{
	
}