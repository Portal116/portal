package operationEx;

import java.util.*;

public class Ex13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연필의 개수를 입력해주세요 : ");
		int pencil = sc.nextInt();
		
		System.out.print("학생이 몇 명인지 입력해주세요 : ");
		int student = sc.nextInt();
		
		System.out.println("학생 당 " + pencil/student + 
				"개씩 가지고 " + pencil%student + "개가 남습니다.");
	}
}