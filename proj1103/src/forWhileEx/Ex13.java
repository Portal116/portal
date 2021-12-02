package forWhileEx;

import java.util.*;

public class Ex13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tot = 0;
		boolean flag = true;
		while(flag) {
			System.out.print("합계를 구할 숫자를 입력하세요(끝내려면 0을 입력) : ");
			int num = sc.nextInt();
			
			tot += num;

			if(num == 0)
				flag = false;
		}
		System.out.println(tot);
	}
}