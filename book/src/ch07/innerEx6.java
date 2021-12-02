package ch07;

public class innerEx6 {
	Object iv = new Object() {
		void method() {}
	};
	static Object cv = new Object() {
		void method() {}
	};
	void myMethod() {
		Object iv = new Object() {
			void method() {}
		};
	}
}
