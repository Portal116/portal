package test;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split(" ");

    	int[] num = new int[N];
        for(int i=0;i<N;i++) {
        	num[i] = Integer.parseInt(str[i]);
        }
        
        int[] numSort = num.clone();
        Arrays.sort(numSort);
        
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int n: numSort) {
        	if(!map.containsKey(n))
        		map.put(n, idx++);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int n : num)
        	sb.append(map.get(n)).append(' ');
        
        System.out.println(sb);
    }
}