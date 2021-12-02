package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static int[] arr;
   static char[] op;
   static int n;
   static boolean[] visited;
   static int cnt = 0;
   static int max = Integer.MIN_VALUE;
   static int min = Integer.MAX_VALUE;
   static char[] op1;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      n = Integer.parseInt(br.readLine());
      arr = new int[n];
      op = new char[n - 1];
      op1 = new char[n - 1];
      visited = new boolean[n - 1];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());

      int num = Integer.parseInt(st.nextToken());
      for (int i = 0; i < num; i++) {
         op[i] = '+';
      }
      cnt += num;

      num = Integer.parseInt(st.nextToken());
      for (int i = cnt; i < num + cnt; i++) {
         op[i] = '-';
      }
      cnt += num;

      num = Integer.parseInt(st.nextToken());
      for (int i = cnt; i < num + cnt; i++) {
         op[i] = '*';
      }
      cnt += num;

      num = Integer.parseInt(st.nextToken());
      for (int i = cnt; i < num + cnt; i++) {
         op[i] = '/';
      }
      cnt += num;

      operator(n-1);

      System.out.println(max);
      System.out.println(min);
   }

   static int operator(int idx) {
      for(char r : op1)
    	  System.out.print(r + " ");
      System.out.println();
      
      int res = 0;
      if (idx == 0) {
         return arr[0];}

      for (int i = 0; i < cnt; i++)
         if (!visited[i]) {
            visited[i] = true;
            op1[idx-1] = op[n-i-2];
            res = calc(operator(idx - 1), arr[idx], op[n-i-2]);
            visited[i] = false;
            if (idx == n - 1) {
               max = max < res ? res : max;
               min = min > res ? res : min;
            }

         }

      return res;
   }

   static int calc(int a, int b, char c) {
      switch (c) {
      case '+':
         return a + b;
      case '-':
         return a - b;
      case '*':
         return a * b;
      case '/':
         return a / b;
      default:
         return 0;
      }
   }
}