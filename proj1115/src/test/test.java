package test;

import java.io.*;
import java.util.*;

public class test {
	static int N;
	static int[][] cost;
	static int min = 1000000;
	static int[][] minArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		minArr = new int[N][3];
		  
		for(int i=0;i<N;i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		        for(int j=0;j<3;j++) {
		            cost[i][j] = Integer.parseInt(st.nextToken());
		            minArr[i][j] = Integer.MAX_VALUE;
		        }
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				if(i == 0) {
					minArr[i][j] = cost[i][j];
		            continue;
				}    		  
		        minArr[i][j] = Math.min(minArr[i-1][(j+1)%3], minArr[i-1][(j+2)%3]) + cost[i][j];
		        if(i == N-1) {
		            min = Math.min(minArr[i][j], min);
		        }
		    }
		}
		System.out.println(min);
	}
}