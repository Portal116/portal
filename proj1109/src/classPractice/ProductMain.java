package classPractice;

import java.util.*;

public class ProductMain { //Ex01
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ProductSalesManagement psm = new ProductSalesManagement();
		int menuSelect = 0;
		while(menuSelect != 3) {
			System.out.println("--------------------");
			System.out.println("  ��ǰ�ǸŰ��� ���α׷�");
			System.out.println("--------------------");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("���� : ");
			menuSelect = sc.nextInt();
			switch(menuSelect){
				case 1:
					psm.inputData();
					break;
				case 2:
					psm.outputData();
					break;
				case 3:
					System.out.println("��ǰ�ǸŰ��� ���α׷��� �����մϴ�.");
					System.out.println("���� �Ϸ�Ǽ���.");
					break;
				default:
					System.out.println("�߸� �� �Է��Դϴ�. 1,2,3 �߿� �Է����ּ���.");
			}
		}
	}
}
class ProductSalesManagement{
	Scanner sc = new Scanner(System.in);
	
	String[] productType = new String[10];
	String[] productName = new String[10];
	int[] price = new int[10];
	int[] salesAmount = new int[10];
	
	int cnt = 0;
	
	void calTake() {};
	
	void inputData() {
		System.out.println("--------------------");
		System.out.println("       �Է�ȭ��");
		System.out.println("--------------------");
		
		System.out.print("��ǰ �з� : ");
		productType[cnt] = sc.next();
		
		System.out.print("�� ǰ �� : ");
		productName[cnt] = sc.next();
		
		if(productType[cnt].equals("ȭ��ǰ")) {
			if(productName[cnt].equals("����ƽ"))
				price[cnt] = 2000;
			else if(productName[cnt].equals("��"))
				price[cnt] = 500;
			else if(productName[cnt].equals("��Ǫ"))
				price[cnt] = 1000;
			price[cnt] = (int) Math.round(price[cnt]*1.5); 
		}
		else if(productType[cnt].equals("������ǰ")){
			if(productName[cnt].equals("�鵵��"))
				price[cnt] = 1000;
			else if(productName[cnt].equals("��ǳ��"))
				price[cnt] = 50000;
			else if(productName[cnt].equals("������"))
				price[cnt] = 300000;
			price[cnt] = (int) Math.round(price[cnt]*1.3);
		}
		else if(productType[cnt].equals("�繫��ǰ")){
			if(productName[cnt].equals("A4����"))
				price[cnt] = 10000;
			else if(productName[cnt].equals("��Ʈ"))
				price[cnt] = 20000;
			else if(productName[cnt].equals("��"))
				price[cnt] = 500;
			price[cnt] = (int) Math.round(price[cnt]*1.2);
		}

		System.out.print("�� �� �� : ");
		salesAmount[cnt] = sc.nextInt();
		
		cnt++;
	};
	
	void outputData() {
		System.out.println("----------------------------------------");
		System.out.println("��ǰ�з�\t��ǰ��\t�ǸŰ�\t�Ǹŷ�\t�����");
		System.out.println("----------------------------------------");
		
		for(int i=0;i<cnt;i++) {
			System.out.println(productType[i] + "\t" + productName[i] + 
					 "\t" + price[i] + "\t" + salesAmount[i] + 
					"\t" + (price[i]*salesAmount[i]));
		}		
		System.out.println();
	};
}

// Ŭ���� �̸� - productSalesManagement
//
// ��ǰ�� - String productName
//�ǸŰ� - int price
//�Ǹŷ� - int saleAmount
//
//��� ����� - calTake()
//�Է¹ޱ� - inputData
//����ϱ� - outputdata