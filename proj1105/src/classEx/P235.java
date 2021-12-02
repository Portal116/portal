package classEx;

public class P235 {
	public static void main(String[] args) {
		D d = new D();
		Pay pay = new Pay();
		pay.bNumber = "A1001";
		pay.name = "강기룡";
		pay.basePav = 2000000;
		
		int aa = 10;
		aa = 20;
//		bNumber = "BBB";
	}
}

class D{
	String name;
	int age;
	String phone;
}

class Pay{
	String bNumber;
	String name;
	int basePav;
}








//설계도
//class D{
//	int a=0;
//	{
//		System.out.println("이곳은 블록입니다-2");
//		System.out.println((a+=10) + "~~~");
//	}
//	D(){
//		System.out.println("이곳은 기본생성자입니다-3");
//		System.out.println((a+=10) + "~~~");
//	}
//	static {
//		System.out.println("이곳은 정적 블록입니다-1");
//	}
//	{
//		System.out.println("이곳은 블록입니다. -4");
//		System.out.println((a+=10) + "~~~");
//	}
//}