package forWhileEx;

import java.util.*;

public class Ex12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = (int)(Math.random()*100) + 1;
		
		int count = 0;
		while(true) {
			System.out.print("1과 100사이의 정수를 입력하세요 : ");
			int yourAns = sc.nextInt();
			
			if(yourAns>100 || yourAns<1)
				continue;
			
			count++;
			if(yourAns > ans)
				System.out.println("더 작은 값으로 다시 시도하세요.");
			else if(yourAns < ans)
				System.out.println("더 큰 값으로 다시 시도하세요.");
			else {
				System.out.println("정답입니다. 시도횟수는 " + count + "번입니다.");
				break;
			}	
		}
	}
}