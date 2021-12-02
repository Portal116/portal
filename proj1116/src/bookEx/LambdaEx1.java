package bookEx;

public class LambdaEx1 {
	public static void main(String[] args) {
//		Runnable rnb = new Runnable() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}			
//		};
		
//		메소드명 생략함
//		메소드가 1개밖에 없으므로 생략 가능
		Runnable runnable = () -> {System.out.println("람다식");};
		runnable.run();
		
		MyFunction mf = (int x, int y) -> {System.out.println("람다식1");};
		mf.abMethod(1, 1);
		
		MyF2 m2 = (a,b,c) -> { if(a) System.out.println(b);
								else System.out.println(c);
								return (int)c;
		};
		m2.mf2(false, "강기룡", 3.5);
	}
}

@FunctionalInterface
interface MyFunction{
	void abMethod(int x, int y);
}
@FunctionalInterface
interface MyF2{
	int mf2(boolean a, String b, double c);
}