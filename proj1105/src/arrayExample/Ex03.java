package arrayExample;

import java.util.*;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� �ο��� �Է����ּ��� : ");
		int N = sc.nextInt();
		
		int[] korean = new int[N];
		int[] english = new int[N];
		int[] sum = new int[N];
		double[] avg = new double[N];
		int[] rank = new int[N];
		
		for(int i=0;i<N;i++) {
			System.out.print((i+1) + "�� ���� ������? ");
			korean[i] = sc.nextInt();
			System.out.print((i+1) + "�� ���� ������? ");
			english[i] = sc.nextInt();
			sum[i] += korean[i] + english[i]; 
		}
		
		for(int i=0;i<N;i++)
			avg[i] = (double)sum[i]/2;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(sum[i]>sum[j])
					rank[j]++;
			}
		}
		
		System.out.println("��ȣ\t����\t����\t�հ�\t���\t����");
		for(int i=0;i<N;i++) {
			System.out.println((i+1) + "\t" + korean[i] + "\t"
					+ english[i] + "\t" + sum[i] + "\t"
					+ avg[i] + "\t" + (rank[i]+1));
		}
	}
}