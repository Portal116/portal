package p344;

public class StaticEx {
	public static void main(String[] args) {
		StaticTest.width = 100;
		StaticTest.height = 80;
		int max = StaticTest.max(StaticTest.width, StaticTest.height);
		System.out.println("�ִ밪�� " + max);
		Test test = new Test();
		test.met1();
		max = StaticTest.max(StaticTest.width, StaticTest.height);
		System.out.println("�ִ밪�� " + max);
	}
}
class StaticTest{
	static int width;
	static int height;
	static {
		System.out.println("�̰��� ���� ����Դϴ�.");
	}
	static int max(int a, int b) {
		return a>b ? a:b;
	}
}

class Test{
	void met1() {
		StaticTest.width = 10;
		StaticTest.height = 50;
		int max = StaticTest.max(StaticTest.width, StaticTest.height);
		System.out.println("�ִ밪�� " + max );
	}
}