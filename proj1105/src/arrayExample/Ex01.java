package arrayExample;

import java.util.*;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tot = 0;
		System.out.print("���� 10���� �Է����ּ��� : ");
		int[] arr = new int[10];
		for(int i=0;i<10;i++) {
			arr[i] = sc.nextInt();
			tot += arr[i];
		}
		System.out.println(tot);
		System.out.println((double)tot/10);
	}
}