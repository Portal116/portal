package javaProject1;

public class ProductTest {
	public static void main(String[] args) {
		Product p1 = new Product(001, "��Ʈ��", 1200000, 2021, "�Ｚ");
		Product p2 = new Product(002, "�����", 300000, 2021, "LG");
		Product p3 = new Product(003, "���콺", 30000, 2020, "������");
		
		System.out.println("��ǰ��ȣ\t��ǰ��\t����\t����\t������");
		System.out.println("--------------------------------------");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}
class Product{
	int prdNo;
	String prdName;
	int prdPrice;
	int prdYear;
	String prdMaker;
	
	public Product(int prdNo, String prdName, int prdPrice, int prdYear, String prdMaker) {
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdYear = prdYear;
		this.prdMaker = prdMaker;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return prdNo + "\t" + prdName + "\t" + prdPrice + "\t" + prdYear + "\t" + prdMaker;
	}
}