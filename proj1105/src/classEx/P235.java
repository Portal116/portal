package classEx;

public class P235 {
	public static void main(String[] args) {
		D d = new D();
		Pay pay = new Pay();
		pay.bNumber = "A1001";
		pay.name = "�����";
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








//���赵
//class D{
//	int a=0;
//	{
//		System.out.println("�̰��� ����Դϴ�-2");
//		System.out.println((a+=10) + "~~~");
//	}
//	D(){
//		System.out.println("�̰��� �⺻�������Դϴ�-3");
//		System.out.println((a+=10) + "~~~");
//	}
//	static {
//		System.out.println("�̰��� ���� ����Դϴ�-1");
//	}
//	{
//		System.out.println("�̰��� ����Դϴ�. -4");
//		System.out.println((a+=10) + "~~~");
//	}
//}