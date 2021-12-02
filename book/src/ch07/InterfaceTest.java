package ch07;

public class InterfaceTest {
	public static void main(String[] args) {
		A a = new A();
//		a.methodA(newB());
//		a.autoPlay(new B());
//		a.autoPlay(new C());
		a.methodA();
	}
}
class A{
	void methodA() {
		I i = InstanceManager.getInstance();
		i.methodB();
		System.out.println(i.toString());
	}
//	void autoPlay(I i) {
//		i.play();
//	}
//	public void methodA(B b) {
//		b.methodB();
//	}
}

interface I{
	public abstract void methodB();
//	public abstract void play();
}

class B implements I{

	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		System.out.println("methodB in B class");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "class B";
	}
	
//	@Override
//	public void play() {
//		// TODO Auto-generated method stub
//		System.out.println("play in B class");
//	}
//	public void methodB() {
//		System.out.println("methodB()");
//	}	
}

class InstanceManager{
	public static I getInstance() {
		return new B();
	}
}

//class C implements I{
//	@Override
//	public void play() {
//		// TODO Auto-generated method stub
//		System.out.println("play in C class");
//	}
//}
