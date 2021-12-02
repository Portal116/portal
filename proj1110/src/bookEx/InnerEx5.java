package bookEx;

public class InnerEx5 {
	public static void main(String[] args) {
		A a = new AA() {

			@Override
			public void iAM() {
				// TODO Auto-generated method stub
				super.iAM();
			}

			@Override
			public void iAM1() {
				// TODO Auto-generated method stub
				super.iAM1();
			}
			
		};
	}
}
//abstract class A{
//	abstract int aM();
//}

interface A{
	void iAM();
	void iAM1();
	default void iaM2() {}
	static void siaM2() {}
}
class AA implements A{

	@Override
	public void iAM() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iAM1() {
		// TODO Auto-generated method stub
		
	}
	
}