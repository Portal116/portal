package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[501];
        int[] max = new int[501];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[a] = b;
        }
        int maxValue = 0;
        for (int i = 1; i < 501; i++) {
            max[i] = 0;
            for (int j = 0; j < i; j++) {
                if (line[i] > line[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
            maxValue = Math.max(maxValue, max[i]);
        }
        System.out.println(n - maxValue);
    }
}