package ch06;

public class CallStackTest {
	public static void main(String[] args) {
		System.out.println("main(String[] args)�� ���۵Ǿ���.");
		firstMethod();
		System.out.println("main(String[] args)�� ������.");
	}
	static void firstMethod() {
		// TODO Auto-generated method stub
		System.out.println("firstMethod()�� ���۵Ǿ���");
		secondMethod();
		System.out.println("firstMethod()�� ������");
	}
	static void secondMethod() {
		// TODO Auto-generated method stub
		System.out.println("secondMethod()�� ���۵Ǿ���");
		System.out.println("secondMethod()�� ������");
	}
}
