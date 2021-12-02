package ch01;

import java.util.Scanner;

public class P40Q17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 단 수를 적어주세요 : ");
		int N = sc.nextInt();
		System.out.println();
		
		npira(N);
		
		sc.close();
	}
	static void npira(int N) {
		for(int i=1;i<=N;i++) {
			for(int j=0;j<N-i;j++)
				System.out.print(" ");
			for(int j=0;j<2*i-1;j++)
				System.out.print(i%10);
			System.out.println();
		}
	}
}