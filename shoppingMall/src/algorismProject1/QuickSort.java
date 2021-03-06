package algorismProject1;

import java.util.Scanner;

public class QuickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl+pr)/2];
		
		do {
			while(a[pl] > x)
				pl++;
			while(a[pr] < x)
				pr--;
			if(pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);
		
		if(left < pr)
			quickSort(a, left, pr);
		if(pl < right)
			quickSort(a, pl, right);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 수 입력 : ");
		int stdNum = sc.nextInt();
		
		int[] stdScore = new int[stdNum];
		
		System.out.println();
		for(int i=0;i<stdNum;i++) {
			System.out.print("학생 " + (i+1) + "점수 입력 : ");
			stdScore[i] = sc.nextInt();
		}
		
		quickSort(stdScore, 0, stdNum-1);
		
		System.out.println();
		System.out.println("성적 순으로 정렬");
		for(int i=0;i<stdNum;i++) {
			System.out.println((i+1) + "등 : " + stdScore[i]);
		}
		
		sc.close();
	}
}