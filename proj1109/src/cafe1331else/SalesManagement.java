package cafe1331else;

import java.util.Scanner;
import java.util.Vector;

public class SalesManagement {
	public static void main(String[] args) {
		Vector<Branch> vbr = new Vector<>(); 
		{	
		Product tmp;		
		if(str.equals("컴퓨터")) {
			tmp = new Computer();
		}
		else if(str.equals("프린터"))
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
		return "컴퓨터";
	}	
}
class Printer extends Product{
	Printer(){
		super(500000);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "프린터";
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
			System.out.println("  판매량 관리 프로젝트");
			System.out.println("--------------------");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("선택? ");
			int choice = sc.nextInt();
			if(choice == 1) {
				branchChoice();
			} else if(choice == 2) {
				summary();
			} else if(choice == 3)
				System.exit(0);
			else {
				System.out.println("1~3중에 선택해주세요.");
			}
		}	
	}
	
	String[] branchName = new String[100];
	public void branchChoice() {
		System.out.println("지사는?");
		System.out.println("1. 서울지사 2. 경인지사 3. 강원지사 4. 제주지사");
		System.out.print("선택은? ");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				branchName[cnt] = "서울지사";
				break;
			case 2:
				branchName[cnt] = "경인지사";
				break;
			case 3:
				branchName[cnt] = "강원지사";
				break;
			case 4:
				branchName[cnt] = "제주지사";
				break;
			default:
				System.out.println("1~4 중에 선택해주세요");
				return;
		}
		inputData();
	}
	
	String[] productName = new String[100];
	int[] sell = new int[100];
	int[] price = new int[100];
	public void inputData() {
		while(true) {
			System.out.print("제품은? ");
			productName[cnt] = sc.next();
			if(productName[cnt] == "컴퓨터")
				price[cnt] = 2000000;
			else
				price[cnt] = 500000;
			
			System.out.print(branchName[cnt] + " "
					+ productName[cnt] +  " 판매량은? ");
			sell[cnt] = sc.nextInt();
			
			cnt++;
			
			System.out.print("계속 입력하시겠습니까? ");
			char ch = sc.next().charAt(0);
			
			if(ch != 'y' || ch != 'Y')
				break;
			branchName[cnt] = branchName[cnt-1];
		}		
	}
	
	public void summary() {
		System.out.println("----------------------------------------");
		System.out.println("\t    각 지사별 판매 현황");
		System.out.println("----------------------------------------");
		System.out.println("지사명\t제품명\t제품가격\t판매량\t매출현황");
		
		for(int i=0;i<cnt;i++) {
			System.out.println(branchName[i] + "\t"
					+ productName[i] + "\t" + price[i] + "\t"
					+ sell[i] + "\t" + (sell[i] * price[i]));
		}
		System.out.println("----------------------------------------");
		System.out.println();
	}
}