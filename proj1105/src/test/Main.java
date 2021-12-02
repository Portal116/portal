package test;

import java.io.*;
import java.util.*;

public class Main{
	public static int N;
	public static int dif = 2000;
	public static int[][] S ;

	public static boolean[] visited;
    public static int[] teamA;
    public static int[] teamB;
    
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(
    			new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	S = new int[N][N];
    	for(int i=0;i<N;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++)
    			S[i][j] = Integer.parseInt(st.nextToken());
    	}

    	visited = new boolean[N/2];
    	teamA = new int[N/2];
    	teamB = new int[N/2];
    	
    	dfs(0, 0);
    	System.out.println(dif);
    }
    
    public static void dfs(int start, int depth) {
    	if(depth == N/2) {
    		int idx = 0;
    		for(int i=0;i<N;i++) {
    			if(!contains(teamA,i)){
    				teamB[idx] = i;
    				idx++;
    			}
    		}
    		int temp = Math.abs(synergy(teamA) - synergy(teamB));
    		if(dif>temp)
    			dif = temp;
    		return;
    	}
    	for(int i=start;i<N;i++) {
            teamA[depth] = i;
            dfs(i+1,depth+1);
    	}
    }

    public static int synergy(int[] team) {
    	int sum = 0;
    	for(int i=0;i<N/2;i++) {
    		for(int j=0;j<N/2;j++) {
    			sum += S[team[i]][team[j]];
    		}
    	}
    	return sum;
    }
    
    public static boolean contains(int[] arr, int key) {
    	for(int i=0;i<N/2;i++) {
    		if(arr[i] == key)
    			return true;
    	}
    	return false;
    }
}