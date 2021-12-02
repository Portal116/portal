package test;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int temp = N;
		while(temp>1) {
			cnt++;
			if(temp%2 == 0 && (temp/2)%3 != 0 && ((temp/2)%2 == 0 || temp/2 == 1))
				temp /= 2;
			else if(temp%3 == 0)
				temp /= 3;
			else if(temp%2 == 0)
				temp /= 2;
			else
				temp--;
			System.out.println(temp);
		}
		System.out.println();
		int min = cnt;
		cnt = 0;
		while(N>1) {
			cnt++;
			if((N-1)%3 == 0)
				N--;
			else if(N%3 == 0)
				N /= 3;
			else if(N%2 == 0)
				N /= 2;
			else
				N--;
			System.out.println(N);
		}
		System.out.println();
		System.out.println(min);
		System.out.println(cnt);
		min = Math.min(min, cnt);
		System.out.println(min);
	}
}