package ch07;

public class InnerEx4 {
	public static void main(String[] args) {
		Outer oc = new Outer();
		Outer.Inner inner = oc.new Inner();
		inner.method();
		
//		Outer.InstanceInner ii = oc.new InstanceInner();
//		
//		System.out.println("ii.iv : " + ii.iv);
//		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);
//		
//		Outer.StaticInner si = new Outer.StaticInner();
//		System.out.println("si.iv : " + si.iv);
	}
}
class Outer{
	int value = 10;
	
	class Inner{
		int value = 20;
		
		void method() {
			int value = 30;
			System.out.println("           value : " + value);
			System.out.println("      this.value : " + this.value);
			System.out.println("Outer.this.value : " + Outer.this.value);
		}
	}
//	class InstanceInner{
//		int iv = 100;
//	}
//	static class StaticInner{
//		int iv = 200;
//		static int cv = 300;
//	}
//	void myMethod() {
//		class LocalInner{
//			int iv = 400;
//		}
//	}
}