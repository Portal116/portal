package classPractice;

import java.util.*;

public class ProductMain { //Ex01
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ProductSalesManagement psm = new ProductSalesManagement();
		int menuSelect = 0;
		while(menuSelect != 3) {
			System.out.println("--------------------");
			System.out.println("  제품판매관리 프로그램");
			System.out.println("--------------------");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("선택 : ");
			menuSelect = sc.nextInt();
			switch(menuSelect){
				case 1:
					psm.inputData();
					break;
				case 2:
					psm.outputData();
					break;
				case 3:
					System.out.println("제품판매관리 프로그램을 종료합니다.");
					System.out.println("좋은 하루되세요.");
					break;
				default:
					System.out.println("잘못 된 입력입니다. 1,2,3 중에 입력해주세요.");
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
		System.out.println("       입력화면");
		System.out.println("--------------------");
		
		System.out.print("제품 분류 : ");
		productType[cnt] = sc.next();
		
		System.out.print("제 품 명 : ");
		productName[cnt] = sc.next();
		
		if(productType[cnt].equals("화장품")) {
			if(productName[cnt].equals("립스틱"))
				price[cnt] = 2000;
			else if(productName[cnt].equals("비누"))
				price[cnt] = 500;
			else if(productName[cnt].equals("샴푸"))
				price[cnt] = 1000;
			price[cnt] = (int) Math.round(price[cnt]*1.5); 
		}
		else if(productType[cnt].equals("가전제품")){
			if(productName[cnt].equals("면도기"))
				price[cnt] = 1000;
			else if(productName[cnt].equals("선풍기"))
				price[cnt] = 50000;
			else if(productName[cnt].equals("전기담요"))
				price[cnt] = 300000;
			price[cnt] = (int) Math.round(price[cnt]*1.3);
		}
		else if(productType[cnt].equals("사무용품")){
			if(productName[cnt].equals("A4용지"))
				price[cnt] = 10000;
			else if(productName[cnt].equals("노트"))
				price[cnt] = 20000;
			else if(productName[cnt].equals("펜"))
				price[cnt] = 500;
			price[cnt] = (int) Math.round(price[cnt]*1.2);
		}

		System.out.print("판 매 량 : ");
		salesAmount[cnt] = sc.nextInt();
		
		cnt++;
	};
	
	void outputData() {
		System.out.println("----------------------------------------");
		System.out.println("제품분류\t제품명\t판매가\t판매량\t매출액");
		System.out.println("----------------------------------------");
		
		for(int i=0;i<cnt;i++) {
			System.out.println(productType[i] + "\t" + productName[i] + 
					 "\t" + price[i] + "\t" + salesAmount[i] + 
					"\t" + (price[i]*salesAmount[i]));
		}		
		System.out.println();
	};
}

// 클래스 이름 - productSalesManagement
//
// 제품명 - String productName
//판매가 - int price
//판매량 - int saleAmount
//
//계산 매출액 - calTake()
//입력받기 - inputData
//출력하기 - outputdata