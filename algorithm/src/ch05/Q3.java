package ch05;

import java.util.Scanner;

public class Q3 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] a = new int[N];
		
		for(int i=0;i<N;i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println(gcdArray(a));
	}
	static int gcdArray(int[] a) {
		int res = a[0];
		for(int i=1;i<N;i++) {
			res = gcd(res, a[i]);
		}
		return res;
	}
	static int gcd(int x, int y) {
		if(y == 0)
			return x;
		else return gcd(y, x%y);
	}
}