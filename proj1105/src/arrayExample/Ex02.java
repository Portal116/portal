package arrayExample;

import java.util.*;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double max = -2100000000;
		double min = 2100000000;
		System.out.print("실수 10개를 입력해주세요 : ");
		double[] arr = new double[10];
		for(int i=0;i<10;i++) {
			arr[i] = sc.nextDouble();
			if(min>arr[i])
				min = arr[i];
			if(max<arr[i])
				max = arr[i];
		}
		System.out.println(max);
		System.out.println(min);
	}
}