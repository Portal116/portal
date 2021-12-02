package forWhileEx;

public class Ex06 {
	public static void main(String[] args) {
		for(int C = -60;C<=140;C+=20) {
			double F = (9.0/5.0)*C + 32;
			System.out.println(Math.round(F));
		}
	}
}