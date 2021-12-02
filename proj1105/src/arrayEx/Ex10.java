package arrayEx;

public class Ex10 {
	public static void main(String[] args) {
		int[] scores = {95, 71, 84, 93, 87};
		
		int sum = 0;
		for(int score : scores)
			sum += score;
		System.out.println("ÃÑÇÕ : " + sum);
		
		double avg = (double)sum/scores.length;
		System.out.println("Æò±Õ : " + avg);
		System.out.println((4)/(-5));
	}
}