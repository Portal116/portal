package hw;

import java.util.*;

public class Hw01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("제품의 총 갯수를 입력해주세요 : ");
		int N = sc.nextInt();
		
		String[] code = new String[N];
		int[] price = new int[N];
		int[] stock_in = new int[N];
		int[] sell = new int[N];
		
		int[] sum = new int[6];
		int[] max = new int[6];
		
		for(int i=0;i<N;i++) {
			System.out.println((i+1) + "번째 제품정보");
			System.out.print("제품코드는? ");
			code[i] = sc.next();
			sc.nextLine();
			
			System.out.print("생산원가는? ");
			price[i] = sc.nextInt();
			sum[0] += price[i];
			max[0] = max[0]>price[i]? max[0]:price[i];
			
			System.out.print("입고량은? ");
			stock_in[i] = sc.nextInt();
			sum[1] += stock_in[i];
			max[1] = max[1]>stock_in[i]? max[1]:stock_in[i];
			
			System.out.print("판매량은? ");
			sell[i] = sc.nextInt();
			sum[2] += sell[i];
			max[2] = max[2]>sell[i]? max[2]:sell[i];
		}

		int[] stock = new int[N];
		int[] sell_price = new int[N];
		int[] income = new int[N];
		
		for(int i=0;i<N;i++) {
			stock[i] = stock_in[i] - sell[i];
			sum[3] += stock[i];
			max[3] = max[3]>stock[i]? max[3]:stock[i];
			
			sell_price[i] = (int) Math.round(price[i] * 1.2 * sell[i]);
			sum[4] += sell_price[i];
			max[4] = max[4]>sell_price[i]? max[4]:sell_price[i];
			
			income[i] = Math.round(sell_price[i] - (price[i] * sell[i]));
			sum[5] += income[i];
			max[5] = max[5]>income[i]? max[5]:income[i];
		}
		
		System.out.println("========================================================================");
		System.out.println("\t\t\t하이마트 제품코드별 보고서");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("제품코드\t\t생산원가\t입고량\t판매량\t재고량\t판매금액\t\t수입금액");
		System.out.println("------------------------------------------------------------------------");
		for(int i=0;i<N;i++) {
			System.out.println(code[i] + "\t" + price[i] + 
					"\t" + stock_in[i]+ "\t" + sell[i] + 
					"\t" + stock[i]+ "\t" + sell_price[i] + 
					"    \t" + income[i]);	
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println("합계\t\t" + sum[0] + 
				"\t" + sum[1]+ "\t" + sum[2] + 
				"\t" + sum[3]+ "\t" + sum[4] + 
				"   \t" + sum[5]);
		
		System.out.println("평균\t\t" + sum[0]/N + 
				"\t" + sum[1]/N+ "\t" + sum[2]/N + 
				"\t" + sum[3]/N+ "\t" + sum[4]/N + 
				"   \t" + sum[5]/N);
		
		System.out.println("최대값\t\t" + max[0] + 
				"\t" + max[1]+ "\t" + max[2] + 
				"\t" + max[3]+ "\t" + max[4] + 
				"   \t" + max[5]);
		System.out.println("========================================================================");
	}
}