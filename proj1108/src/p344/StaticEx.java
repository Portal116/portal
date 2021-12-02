package p344;

public class StaticEx {
	public static void main(String[] args) {
		StaticTest.width = 100;
		StaticTest.height = 80;
		int max = StaticTest.max(StaticTest.width, StaticTest.height);
		System.out.println("최대값은 " + max);
		Test test = new Test();
		test.met1();
		max = StaticTest.max(StaticTest.width, StaticTest.height);
		System.out.println("최대값은 " + max);
	}
}
class StaticTest{
	static int width;
	static int height;
	static {
		System.out.println("이곳은 정적 블록입니닫.");
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
		System.out.println("최대값은 " + max );
	}
}