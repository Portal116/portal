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
		
//		�޼ҵ�� ������
//		�޼ҵ尡 1���ۿ� �����Ƿ� ���� ����
		Runnable runnable = () -> {System.out.println("���ٽ�");};
		runnable.run();
		
		MyFunction mf = (int x, int y) -> {System.out.println("���ٽ�1");};
		mf.abMethod(1, 1);
		
		MyF2 m2 = (a,b,c) -> { if(a) System.out.println(b);
								else System.out.println(c);
								return (int)c;
		};
		m2.mf2(false, "�����", 3.5);
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