package ch07;

public class InnerEx {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner{
		int iiv = outerIv;
		int iiv2 = outerCv;
	}
	static class StaticInner{
//		int siv = outerIv;
		static int scv = outerCv;		
	}
//	class InstanceInner{}
//	static class StaticInner{}
	
//	InstanceInner iv = new InstanceInner();
//	static StaticInner cv = new StaticInner();
//	
//	static void staticMethod(){
////		InstanceInner obj1 = new InstanceInner();
//		StaticInner obj2 = new StaticInner();
//		
//		InnerEx outer = new InnerEx();
//		InstanceInner obj1 = outer.new InstanceInner();
//	}
//	
//	void instanceMethod() {
//		InstanceInner obj1 = new InstanceInner();
//		StaticInner obj2 = new StaticInner();
////		LocalInner iv = new LocalInner();
//	}
	void myMethod() {
		int lv = 0;
		final int LV = 0;
		class LocalInner{
			int iiv = outerIv;
			int iiv2 = outerCv;
			int iiv3 = lv;
			int iiv4 = LV;
		}
//		class LocalInner{}
//		LocalInner iv = new LocalInner();
	}
	
	
//	class InstanceInner{
//		int iv = 100;
////		staic int cv = 100;
//		final static int CONST = 100;
//	}
//	static class StaticInner{
//		int iv = 200;
//		static int cv = 200;
//	}
//	
//	void myMethod() {
//		class LocalInner{
//			int iv = 300;
////			static int cv = 300;
//			final static int CONST = 300;
//		}
//	}
//	public static void main(String[] args) {
//		System.out.println(InstanceInner.CONST);
//		System.out.println(StaticInner.cv);
//	}
}
