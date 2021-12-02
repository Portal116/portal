package test;

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] num;
	static int max = 0;
	static int[][] maxArr;
	public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(
    		  new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      num = new int[n][n];
      maxArr = new int[n][n];
      
      for(int i=0;i<n;i++) {
    	  StringTokenizer st = new StringTokenizer(br.readLine());
    	  for(int j=0;j<i+1;j++) {
    		  num[i][j] = Integer.parseInt(st.nextToken());
    	  }
      }
      for(int i=0;i<n;i++) {
    	  for(int j=0;j<i+1;j++) {
    		  if(i == 0) {
    			  maxArr[i][j] = num[i][j];
    			  max = maxArr[i][j];
    			  continue;
    		  }
    		  if(j==0)
    			  maxArr[i][j] = maxArr[i-1][j] + num[i][j];
    		  else
    			  maxArr[i][j] = Math.max(maxArr[i-1][j], maxArr[i-1][j-1]) + num[i][j];
    		  if(i == n-1) {
        		  max = Math.max(maxArr[i][j], max);
        	  }
    	  }
      }
      System.out.println(max);
	}
}