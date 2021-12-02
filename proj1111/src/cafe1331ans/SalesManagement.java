package cafe1331ans;

import java.util.Scanner;

public class SalesManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menuSelect = 0;
		Business b = new Business();
		while( menuSelect != 3) {
			System.out.println("--------------");
			System.out.println("�Ǹŷ� ���� ������Ʈ");
			System.out.println("---------------");
			System.out.println("1.�Է� 2.��� 3.����");
			System.out.print("����? ");
			menuSelect=sc.nextInt();
			if(menuSelect == 1) {
				b.input();
			}else if(menuSelect == 2) {
				b.output();
			}else if(menuSelect == 3) {
				break;
			}else {
				System.out.println("�޴��� 1~3 ���� ���� ");
			}
		}

	}

}
class Business{
	Scanner sc;
	SeoulJisa sj = new SeoulJisa();
	KyunginJisa kj=new KyunginJisa();
	KangWonJisa kwj = new KangWonJisa();
	GejuJisa gj = new GejuJisa();
	String yN="y";//�Լ��Ͻðڽ��ϱ� �Ǵ��ϴ� ����

	void salesStaus(Jisa jisa) {
		if(jisa instanceof SeoulJisa) {
			if(sj.productName.equals("com")) 
				sj.salesStatus = 2000000  * sj.salesAmount; 
			else if(sj.productName.equals("printer")) 
				sj.salesStatus = 500000  *sj.salesAmount; 
				
		}else if(jisa instanceof KangWonJisa) {
				if(kwj.productName.equals("com")) 
					kwj.salesStatus = 2000000  *kwj.salesAmount; 
				else if(kwj.productName.equals("printer")) 
					kwj.salesStatus = 500000  *kwj.salesAmount; 
		}else if(jisa instanceof KyunginJisa) {
				if(kj.productName.equals("com")) 
					kj.salesStatus = 2000000  *kj.salesAmount; 
				else if(kj.productName.equals("printer")) 
					kj.salesStatus = 500000  *kj.salesAmount; 
		}else if(jisa instanceof KyunginJisa) {
				if(kj.productName.equals("com")) 
		    		kj.salesStatus = 2000000  *kj.salesAmount;
				else if(kj.productName.equals("printer")) 
					kj.salesStatus = 500000  *kj.salesAmount; 			
		}else if(jisa instanceof GejuJisa) {
				if(gj.productName.equals("com")) 
					gj.salesStatus = 2000000  *gj.salesAmount; 
				else if(gj.productName.equals("printer"))
					gj.salesStatus = 500000  *gj.salesAmount; 			
		}
	}

	void input() {
		//�Է�
		do {	
			System.out.println("�����?");
			System.out.println("1. ��������, 2. ��������, 3. �������� 4. �������� ");
			System.out.print("������? ");
			int jisaSelect=0;
			sc = new Scanner(System.in);
			jisaSelect = sc.nextInt();
			if(jisaSelect == 1) {
				jisaInput(sj);
			}else if(jisaSelect == 2) {
				jisaInput(kj);
			}else if(jisaSelect == 3) {
				jisaInput(kwj);
			}else if(jisaSelect == 4) {
				jisaInput(gj);
			}else {
				System.out.println("�����ȣ Ʋ�Ƚ��ϴ�");
			}
		}while(yN.equalsIgnoreCase("y")); 	
	}
	void jisaInput(Jisa jisa) {

		System.out.print("��ǰ��?");
		if(jisa instanceof SeoulJisa) {
			sj=(SeoulJisa) jisa;
			sj.productName=sc.next();
			System.out.println();
			System.out.println(sj.toString() + " " + sj.productName + "�Ǹŷ���? ");
			sj.salesAmount = sc.nextInt();
			salesStaus(sj);//������Ȳ ���
		}else if(jisa instanceof KangWonJisa) {
			kwj=(KangWonJisa) jisa;
			kwj.productName=sc.next();
			System.out.println();
			System.out.println(kwj.toString() + " " + kwj.productName + "�Ǹŷ���? ");

			kwj.salesAmount = sc.nextInt();
			salesStaus(kwj);//������Ȳ ���

		}else if(jisa instanceof KyunginJisa) {
			kj=(KyunginJisa) jisa;
			kj.productName=sc.next();
			System.out.println();
			System.out.println(kj.toString() + " " + kj.productName + "�Ǹŷ���? ");

			kj.salesAmount = sc.nextInt();
			salesStaus(kj);//������Ȳ ���

		}else if(jisa instanceof GejuJisa) {
			gj=(GejuJisa) jisa;
			gj.productName=sc.next();	
			System.out.println();
			System.out.println(gj.toString() + " " + gj.productName + "�Ǹŷ���? ");
			gj.salesAmount = sc.nextInt();
			salesStaus(gj);
		}
		System.out.println();
		System.out.print("����Ͻðڽ��ϱ�?");
		yN = sc.next();
	}
	void output() {
		//���
		System.out.println("---------------------------");
		System.out.println("�� ���纰 �Ǹ���Ȳ");
		System.out.println("--------------------------- ");
		System.out.println("����� ��ǰ�� ��ǰ���� �Ǹŷ� ������Ȳ");
		System.out.println("----------------------------");
		System.out.println(sj + " " + sj.productName + " " + sj.salesAmount + " " + sj.salesAmount);
		System.out.println(kj + " " + kj.productName + " " + kj.salesAmount + " " + kj.salesAmount);
		System.out.println(kwj + " " + kwj.productName + " " + kwj.salesAmount + " " + kwj.salesAmount);
		System.out.println(gj + " " + gj.productName + " " + gj.salesAmount + " " + gj.salesAmount);
		
	}

}
class Jisa{
	String jisaName;//�����
	String productName;//��ǰ��
	int salesAmount;//�Ǹŷ�

}
class SeoulJisa extends Jisa{
	int salesStatus;//������Ȳ
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��������";
	}
}
class KyunginJisa extends Jisa{
	int salesStatus;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��������";
	}
}
class KangWonJisa extends Jisa{
	int salesStatus;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��������";
	}
}
class GejuJisa extends Jisa{
	int salesStatus;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "��������";
	}
}


//
//import java.util.*;
//
//public class SalesManagement {
//	public static void main(String[] args) {
//		Business bs = new Business();
//		bs.title();
//	}
//}
//
//class Branch{
//	String branchName;
//	String productName;
//	int price;
//	int salesAmount;
//	int income;
//}
//
//class SeoulBranch extends Branch{
//	int salesAmount;
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "��������";
//	}
//}
//class KyunginBranch extends Branch{
//	int salesAmount;
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "��������";
//	}
//}
//class KangwonBranch extends Branch{
//	int salesAmount;
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "��������";
//	}
//}
//class JejuBranch extends Branch{
//	int salesAmount;
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "��������";
//	}
//}
//class Business{
//	Scanner sc = new Scanner(System.in);
//	Branch sb = new SeoulBranch();
//	Branch kb = new KyunginBranch();
//	Branch wb = new KangwonBranch();
//	Branch jb = new JejuBranch();
//	//���� ��Ȳ ���ϱ�
//	void SalesStatus(Branch branch) {
//		if(branch.productName.equals("��ǻ��"))
//			branch.price = 2000000;
//		else if(branch.productName.equals("������"))
//			branch.price = 500000;
//	}
//	//ù �޴�
//	void title() {
//		int menuSelect;
//		while(true) {
//			System.out.println("--------------------");
//			System.out.println("  �Ǹŷ� ���� ������Ʈ");
//			System.out.println("--------------------");
//			System.out.println("1. �Է� 2. ��� 3. ����");
//			System.out.print("����? ");
//			menuSelect = sc.nextInt();
//			switch(menuSelect) {
//				case 1:
//					branchInput();
//					break;
//				case 2:
//					output();
//					break;
//				case 3:
//					System.exit(0);
//					break;
//				default:
//					System.out.println("1~3�߿� �������ּ���.");
//					break;
//			}
//		}	
//	}
//	//���� �Է�
//	void branchInput() {
//		System.out.println("�����?");
//		System.out.println("1. �������� 2. �������� 3. �������� 4. ��������");
//		System.out.print("������? ");
//		int branchSelect = sc.nextInt();
//		switch(branchSelect) {
//			case 1:
//				input(sb);
//				break;
//			case 2:
//				input(kb);
//				break;
//			case 3:
//				input(wb);
//				break;
//			case 4:
//				input(jb);
//				break;
//			default:
//				System.out.println("�����ȣ�� Ʋ�Ƚ��ϴ�.");
//		}
//	}
//	//���� �Է�
//	void input(Branch branch) {
//		while(true) {
//			System.out.print("��ǰ��? ");
//			branch.productName = sc.next();
//			
//			System.out.print(branch.toString() + " "
//					+ branch.productName + " �Ǹŷ���? ");
//			branch.salesAmount = sc.nextInt();
//			
//			SalesStatus(branch);
//			System.out.print("��� �Է��Ͻðڽ��ϱ�? ");
//			char ch = sc.next().charAt(0);
//			
//			if(ch != 'y' && ch != 'Y')
//				break;
//		}
//	}
//	//���
//	void output() {
//		System.out.println("----------------------------------------");
//		System.out.println("\t    �� ���纰 �Ǹ� ��Ȳ");
//		System.out.println("----------------------------------------");
//		System.out.println("�����\t��ǰ��\t��ǰ����\t�Ǹŷ�\t������Ȳ");
//		for(int i=0;i<vbr.size();i++) {
//			Branch temp = vbr.get(i);			
//			System.out.println(temp.name + "\t" + temp.p.toString()
//				+ "\t" + temp.p.price + "\t" + temp.p.sales
//				+ "\t" + temp.p.income);
//		}
//		System.out.println("----------------------------------------");
//		System.out.println();
//	}
//}