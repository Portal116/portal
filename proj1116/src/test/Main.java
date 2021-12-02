package test;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] num;
	static int[][] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		count = new int[N+1][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		count[1][1] = 1;
		for(int i=2;i<=N;i++) {
			recursion(i);
		}
		int max = 0;
		for(int i=1;i<=N;i++) {
			max = Math.max(max, count[i][1]);
		}
		System.out.println(max);
	}
	public static void recursion(int N) {
		for(int i=N-1;i>=0;i--) {
			if(num[i] > count[N][0] && count[i][1] >= count[N][1]) {
				count[N][0] = num[N];
				count[N][1] = count[i][1] + 1;
			}
		}
	}
}