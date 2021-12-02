package test;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(N>1) {
			cnt++;
			if((N/2)%3 != 0 && ((N/2)%2 == 0 || N/2 == 1))
				N /= 2;
			else if((N-1)%3 == 0)
				N--;
			else if(N%3 == 0)
				N /= 3;
			else if(N%2 == 0)
				N /= 2;
			else
				N--;
		}
		System.out.println(cnt);
	}
}