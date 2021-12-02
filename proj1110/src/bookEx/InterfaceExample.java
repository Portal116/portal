package bookEx;

public interface InterfaceExample {
//	int x; 
//	void method() {}
//	Moveable(){}
//	변수, 메소드 생성자는 불가능
	
	class M{
		
	}
	interface I234{
		
	}
//	클래스, 인터페이스는 가능
	
	double PI = 3.14;
//	인터페이스 안의 모든 것은 상수이므로 final static 생략 가능
	
	abstract void method2();
//	abstract 메소드는 가능
	void method3();
	default void method4() {
		
	}
	static void method5() {
		
	}
}
