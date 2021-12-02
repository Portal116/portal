package forWhileEx;

public class Ex07 {
	public static void main(String[] args) {
		int tot = 0;
		int num=0;
		while(tot<=5000) {
			num++;
			tot+=num;
		}
		tot-=num;
		num--;
		System.out.println("n : " + num + "\tÇÕ : " + tot );
	}
}