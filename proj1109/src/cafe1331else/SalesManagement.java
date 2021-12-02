package cafe1331else;

import java.util.Scanner;
import java.util.Vector;

public class SalesManagement {
	public static void main(String[] args) {
		Vector<Branch> vbr = new Vector<>(); 
		{	
		Product tmp;		
		if(str.equals("��ǻ��")) {
			tmp = new Computer();
		}
		else if(str.equals("������"))
			tmp = new Printer();
		Branch br = new Branch("Seoul", tmp);
		
		int sales = 10;
		br.p.sales = sales;
		br.p.income = sales * br.p.price;
		vbr.add(br);
		}
		for(int i=0;i<vbr.size();i++) {
			Branch temp = vbr.get(0);
			
			System.out.println(temp.name + " " + temp.p.toString()
				+ " " + temp.p.price + " " + temp.p.sales
				+ " " + temp.p.income);
		}
	}
}
class Product{
	int price;
	int sales;
	int income;
	
	Product(int price){
		this.price = price;
	}
}
class Computer extends Product{
	Computer(){
		super(2000000);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��ǻ��";
	}	
}
class Printer extends Product{
	Printer(){
		super(500000);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "������";
	}	
}
class Branch{
	String name;
	Product p;
	
	Branch(String name, Product p){
		this.name = name;
		this.p = p;
	}
}
class Print{
	static int cnt = 0;
	Scanner sc = new Scanner(System.in);
	public void menuOutput() {
		while(true) {
			System.out.println("--------------------");
			System.out.println("  �Ǹŷ� ���� ������Ʈ");
			System.out.println("--------------------");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("����? ");
			int choice = sc.nextInt();
			if(choice == 1) {
				branchChoice();
			} else if(choice == 2) {
				summary();
			} else if(choice == 3)
				System.exit(0);
			else {
				System.out.println("1~3�߿� �������ּ���.");
			}
		}	
	}
	
	String[] branchName = new String[100];
	public void branchChoice() {
		System.out.println("�����?");
		System.out.println("1. �������� 2. �������� 3. �������� 4. ��������");
		System.out.print("������? ");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				branchName[cnt] = "��������";
				break;
			case 2:
				branchName[cnt] = "��������";
				break;
			case 3:
				branchName[cnt] = "��������";
				break;
			case 4:
				branchName[cnt] = "��������";
				break;
			default:
				System.out.println("1~4 �߿� �������ּ���");
				return;
		}
		inputData();
	}
	
	String[] productName = new String[100];
	int[] sell = new int[100];
	int[] price = new int[100];
	public void inputData() {
		while(true) {
			System.out.print("��ǰ��? ");
			productName[cnt] = sc.next();
			if(productName[cnt] == "��ǻ��")
				price[cnt] = 2000000;
			else
				price[cnt] = 500000;
			
			System.out.print(branchName[cnt] + " "
					+ productName[cnt] +  " �Ǹŷ���? ");
			sell[cnt] = sc.nextInt();
			
			cnt++;
			
			System.out.print("��� �Է��Ͻðڽ��ϱ�? ");
			char ch = sc.next().charAt(0);
			
			if(ch != 'y' || ch != 'Y')
				break;
			branchName[cnt] = branchName[cnt-1];
		}		
	}
	
	public void summary() {
		System.out.println("----------------------------------------");
		System.out.println("\t    �� ���纰 �Ǹ� ��Ȳ");
		System.out.println("----------------------------------------");
		System.out.println("�����\t��ǰ��\t��ǰ����\t�Ǹŷ�\t������Ȳ");
		
		for(int i=0;i<cnt;i++) {
			System.out.println(branchName[i] + "\t"
					+ productName[i] + "\t" + price[i] + "\t"
					+ sell[i] + "\t" + (sell[i] * price[i]));
		}
		System.out.println("----------------------------------------");
		System.out.println();
	}
}