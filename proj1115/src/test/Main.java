package test;

import java.io.*;
import java.util.*;

public class Main {
	static long[][] stair;
	static long remainder = 1000000000;
	static long cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stair = new long[N+1][10];
		
		for(int i=1;i<10;i++)
			stair[1][i] = 1;
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				if(j == 0)
					stair[i][j] = stair[i-1][1];
				else if(j == 9)
					stair[i][j] = stair[i-1][8];
				else
					stair[i][j] = (stair[i-1][j+1] + stair[i-1][j-1]) % remainder;	
			}
		}
		for(int j=0;j<10;j++) {
			cnt = (cnt + stair[N][j])%remainder;
		}
		System.out.println(cnt);
	}
}