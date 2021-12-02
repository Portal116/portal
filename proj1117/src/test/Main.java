package test;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] powerCode;
	static int[] maxArr;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		powerCode = new int[N+1][2];
		maxArr = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			powerCode[i][0] = Integer.parseInt(st.nextToken());
			powerCode[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(powerCode, (o1, o2) -> o1[0]-o2[0]);
		
		for(int i=1;i<=N;i++)
			max = Math.max(recur(i), max);
		
		System.out.println(N - max);
	}
	static int recur(int k){
		if(maxArr[k] == 0) {
			maxArr[k] = 1;
			
			for(int i=k+1;i<=N;i++){
				if(powerCode[i][1] > powerCode[k][1])
					maxArr[k] = Math.max(maxArr[k], recur(i) + 1);
			}
		}
		return maxArr[k];
	}		
}