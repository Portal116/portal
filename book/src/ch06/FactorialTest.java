package ch06;

public class FactorialTest {
	public static void main(String[] args) {
//		int result = factorial(4);
//
//		System.out.println(result);

		int n = 21;
		long result = 0;
		for (int i = 1; i <= n; i++) {
			result = factorial(i);

			if (result == -1) {
				System.out.println("유효하지않은 값입니다. (0<n<20) " + n);
				break;
			}
			System.out.printf("%2d!=%20d%n", i, result);
		}
	}

	static long factorial(int n) {
		// TODO Auto-generated method stub
		if (n < 0 || n > 20)
			return -1;
		if (n <= 1)
			return 1;
		return n*factorial(n-1);
	}

//	static int factorial(int i) {
//		// TODO Auto-generated method stub
//		int result = 0;
//		if (i == 1)
//			result = 1;
//		else
//			result = i * factorial(i-1);
//		
//		return result;
//	}
}
