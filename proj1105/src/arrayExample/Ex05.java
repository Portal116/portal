package arrayExample;

import java.util.*;

public class Ex05 {
	public static void main(String[] args) {
		int[] lotto = new int[7];
		for(int i=0;i<7;i++) {
			int temp = (int)(Math.random()*45) +1;
			lotto[i] = temp;
			for(int j=0;j<i;j++) {
				if(lotto[j] == temp) {
					lotto[i] = 0;
					i--;
				}
			}
		}
		int bonus = lotto[6];
		lotto[6] = 46;
		Arrays.sort(lotto);
		for(int i=0;i<7;i++) {
			if(i == 6)
				System.out.println("\tbonus : " + bonus);
			else
				System.out.print(lotto[i] + " ");
		}
	}
}