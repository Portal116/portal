package hw;

import java.util.*;

public class Hw01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ǰ�� �� ������ �Է����ּ��� : ");
		int N = sc.nextInt();
		
		String[] code = new String[N];
		int[] price = new int[N];
		int[] stock_in = new int[N];
		int[] sell = new int[N];
		
		int[] sum = new int[6];
		int[] max = new int[6];
		
		for(int i=0;i<N;i++) {
			System.out.println((i+1) + "��° ��ǰ����");
			System.out.print("��ǰ�ڵ��? ");
			code[i] = sc.next();
			sc.nextLine();
			
			System.out.print("���������? ");
			price[i] = sc.nextInt();
			sum[0] += price[i];
			max[0] = max[0]>price[i]? max[0]:price[i];
			
			System.out.print("�԰���? ");
			stock_in[i] = sc.nextInt();
			sum[1] += stock_in[i];
			max[1] = max[1]>stock_in[i]? max[1]:stock_in[i];
			
			System.out.print("�Ǹŷ���? ");
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
		System.out.println("\t\t\t���̸�Ʈ ��ǰ�ڵ庰 ����");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("��ǰ�ڵ�\t\t�������\t�԰�\t�Ǹŷ�\t���\t�Ǹűݾ�\t\t���Աݾ�");
		System.out.println("------------------------------------------------------------------------");
		for(int i=0;i<N;i++) {
			System.out.println(code[i] + "\t" + price[i] + 
					"\t" + stock_in[i]+ "\t" + sell[i] + 
					"\t" + stock[i]+ "\t" + sell_price[i] + 
					"    \t" + income[i]);	
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println("�հ�\t\t" + sum[0] + 
				"\t" + sum[1]+ "\t" + sum[2] + 
				"\t" + sum[3]+ "\t" + sum[4] + 
				"   \t" + sum[5]);
		
		System.out.println("���\t\t" + sum[0]/N + 
				"\t" + sum[1]/N+ "\t" + sum[2]/N + 
				"\t" + sum[3]/N+ "\t" + sum[4]/N + 
				"   \t" + sum[5]/N);
		
		System.out.println("�ִ밪\t\t" + max[0] + 
				"\t" + max[1]+ "\t" + max[2] + 
				"\t" + max[3]+ "\t" + max[4] + 
				"   \t" + max[5]);
		System.out.println("========================================================================");
	}
}