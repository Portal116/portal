package operationEx;

import java.util.*;

public class Ex10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = - (int)Math.pow(10, 9);
		System.out.print("숫자 3개를 입력해주세요 : ");
		for(int i=0;i<3;i++) {
			int temp = sc.nextInt();
			max = (max < temp) ? temp : max;
		}
		
		System.out.println(max);
	}
}