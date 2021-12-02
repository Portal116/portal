package forWhileEx;

import java.util.*;

public class Ex11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가위(1), 바위(2), 보(3)중 하나를 입력하세요 : ");
		int rsp = sc.nextInt();
		int com = (int)(Math.random()*3) + 1;
		
		System.out.println("당신은 " + rsp + "입니다.");
		System.out.println("컴퓨터는 " + com + "입니다.");
		
		switch(rsp - com) {
			case 0:
				System.out.println("비겼습니다.");
				break;
			case -1: case 2:
				System.out.println("컴퓨터 승리입니다.");
				break;
			case -2: case 1:
				System.out.println("당신의 승리입니다..");
				break;
		}
	}
}