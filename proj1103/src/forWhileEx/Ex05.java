package forWhileEx;

public class Ex05 {
	public static void main(String[] args) {
		double principal = 1000000;
		for(int year=1;year<=10;year++) {
			double interest = 0.045*year + 1;
			double total = principal * interest;
			System.out.println(year + "³â : " + Math.round(total));
		}
	}
}