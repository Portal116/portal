package test;

import java.io.*;
import java.util.*;

public class Main {
	public static long[] P;
	public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(
    		  new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<T;i++) {
    	  int N = Integer.parseInt(br.readLine());
    	  P = new long[N+1];
    	  sb.append(p(N) + "\n");
      }
      System.out.println(sb);
   }
   public static long p(int n) {
	   if(n<=3) {
		   P[n] = 1;
		   return 1;
	   }
	   if(P[n] != 0)
		   return P[n];
	   P[n] = p(n-2) + p(n-3);
	   return P[n];
   }
}