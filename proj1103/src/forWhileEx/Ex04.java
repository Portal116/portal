package forWhileEx;

public class Ex04 {
	public static void main(String[] args) {
		for(double x=5;x<=10;x+=0.5) {
			double y = 4*Math.pow(x, 3) + 5*Math.pow(x, 2) + x + 2;
			System.out.println("x : " + x + " \ty : " +  y);
		}
	}
}
