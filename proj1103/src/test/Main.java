package test;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[M];
        boolean[] visited = new boolean[N];
        StringBuilder sb = new StringBuilder();
        sb = dfs(arr,visited,0,N,M,sb);
        System.out.println(sb);
        
    }
    public static StringBuilder dfs(int[] ans, boolean[] visited, int depth, int N, int M, StringBuilder sb) {
    	if(depth == M) {
    		for(int i=0;i<M;i++)
    			sb.append(ans[i] + " ");
    		sb.append("\n");
    		return sb;
    	}
    	for(int i=1;i<=N;i++) {
			if(visited[i-1] != true) {
				visited[i-1] = true;
				ans[depth] = i;
				sb = dfs(ans, visited, depth+1, N, M, sb);
				visited[i-1] = false;
			}
    	}
    	return sb;
    }
}