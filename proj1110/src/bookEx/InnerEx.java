package bookEx;

public class InnerEx {
	public static void main(String[] args) {
		OutterA outterA = new OutterA();
		OutterA.InnerA innerA = outterA.new InnerA();
		
		outterA.oa = 200;
		outterA.oaM();
		innerA.iaa = 30;
		innerA.iaM();
	}
}
class OutterA{
	int oa = 10;
	void oaM() {}
	class InnerA{
//		oa = oa + 20;
		int ia = oa;
//		oaM();
		int iaa = 30;
		void iaM() {}
	}
}