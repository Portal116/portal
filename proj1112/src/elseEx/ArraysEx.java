package elseEx;

import java.util.Arrays;

public class ArraysEx {
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4};
//		int[] arr2 = Arrays.copyOf(arr, arr.length);
//		int[] arr2 = Arrays.copyOf(arr, 3);
		int[] arr2 = Arrays.copyOfRange(arr, 2, 4); // 2 <= x < 4
		for(int a2 : arr2)
			System.out.print(a2 + " ");
		System.out.println();
		
		int[] arr3 = new int[5];
		Arrays.fill(arr3, 9);
		for(int a3 : arr3)
			System.out.print(a3 + " ");
		System.out.println();
		
		Arrays.setAll(arr3, i -> (int)(Math.random()*5 + 1));
		for(int a3 : arr3)
			System.out.print(a3 + " ");
		System.out.println();
		
		int[] arr4 = {3,2,0,1,4};
		Arrays.sort(arr4);
		for(int a4 : arr4)
			System.out.print(a4 + " ");
		System.out.println();
		
		int idx = Arrays.binarySearch(arr4, 2); // 정렬 되어있어야 작동함
		System.out.println(idx);
		
		int[] arr5 = {0,1,2,3,4};
		int[][] arr2D = {{11,12},{21,22}};
		System.out.println(Arrays.toString(arr5));
		System.out.println(Arrays.toString(arr2D));
		System.out.println(Arrays.deepToString(arr2D));
	}
}