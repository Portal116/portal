package hw1112ver2;

import java.util.*;

public class AddressBookCreationProject {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("����� �� ������ �ּ��� / choose your language");
			System.out.print("�ѱ��� 0, English 1 : ");
			int languageSelect = sc.nextInt();
			System.out.println("-------------------------------------------------");
			
			AddressBook ab = new AddressBook();
			Print p = null;
			switch(languageSelect) {
				case 0:
					p = new PrintKor();
					break;
				case 1:
					p = new PrintEng();
					break;
				default:
					System.out.println("�߸��� �����Դϴ�. 0,1 �߿� �������ּ���. ��� ���� �޴��� ���ư��ϴ�.");
					System.out.println("-------------------------------------------------");
					continue;
			}
			while(true)
				ab.displayMenu(p);
		}
	}
}
class Record{
	protected String name;
	protected String address;
	
	public Record(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
class AddressBook{
	Vector<Record> vr = new Vector<Record>();
	Scanner sc = new Scanner(System.in);
	
	String nameTemp;
	String addressTemp;
	
	public void addRecord(Print p) {
		// TODO Auto-generated method stub
		p.addRecordPrint(1);
		nameTemp = sc.nextLine();
		p.addRecordPrint(2);
		addressTemp = sc.nextLine();
		p.RecordResultPrint(nameTemp, addressTemp, "add");
		Record rc = new Record(nameTemp, addressTemp);
		vr.add(rc);
		p.linePrint();
	}
	public void getRecord(Print p) {
		// TODO Auto-generated method stub
		int cnt = 0;
		p.RecordSearchPrint("get");
		nameTemp = sc.nextLine();
		for(int i=0;i<vr.size();i++) {
			if(nameTemp.equals(vr.get(i).getName())) {
				p.RecordResultPrint(vr.get(i).getName(), vr.get(i).getAddress(), "get");
				cnt++;
			}
		}
		if(cnt == 0)
			p.noRecordPrint(nameTemp);
		p.linePrint();
	}
	public void delRecord(Print p) {
		// TODO Auto-generated method stub
		int cnt = 0;
		p.RecordSearchPrint("del");
		nameTemp = sc.nextLine();
		for(int i=0;i<vr.size();i++) {
			if(nameTemp.equals(vr.get(i).getName())) {
				p.RecordResultPrint(vr.get(i).getName(), vr.get(i).getAddress(), "del");
				vr.remove(i);
				i--;
				cnt++;
			}
		}
		if(cnt == 0)
			p.noRecordPrint(nameTemp);
		p.linePrint();
	}
	public void displayMenu(Print p) {
		// TODO Auto-generated method stub
		p.displayMenuPrint(1);
		int choice = sc.nextInt();
		sc.nextLine();
		p.linePrint();
		
		switch(choice) {
			case 0:
				addRecord(p);
				break;
			case 1:
				getRecord(p);
				break;
			case 2:
				delRecord(p);
				break;
			case 3:
				System.exit(0);
				break;
			default:
				p.displayMenuPrint(2);
				break;
		}
	}
}
abstract class Print{
	abstract void addRecordPrint(int i);
	abstract void RecordSearchPrint(String menu);
	abstract void RecordResultPrint(String name, String address, String menu);
	abstract void noRecordPrint(String name);
	abstract void displayMenuPrint(int i);
	void linePrint() {
		System.out.println("-------------------------------------------------");
	}
}
class PrintKor extends Print{
	@Override
	void addRecordPrint(int i) {
		// TODO Auto-generated method stub
		switch(i) {
			case 1:
				System.out.print("������ �Է����ּ��� : ");
				break;
			case 2:
				System.out.print("�ּҸ� �Է����ּ��� : ");
				break;
		}
	}
	@Override
	void RecordSearchPrint(String menu) {
		// TODO Auto-generated method stub
		switch(menu) {
			case "get":
				System.out.print("�˻��Ͻ� ������ �Է����ּ��� : ");
				break;
			case "del":
				System.out.print("�ּҸ� ���� ������ �Է����ּ��� : ");
				break;
		}
	}
	@Override
	void RecordResultPrint(String name, String address, String menu) {
		// TODO Auto-generated method stub
		switch(menu) {
			case "add":
				System.out.println(name + "�� �ּ� " + address + "�� �߰��Ǿ����ϴ�.");
				break;
			case "get":
				System.out.println(name + " �� �ּҴ� " + address + "�Դϴ�.");
				break;
			case "del":
				System.out.println(name + " �� �ּ� " + address + "�� �����߽��ϴ�.");
				break;
		}
	}
	@Override
	void noRecordPrint(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + "���� �ּҰ� ��Ͽ� �����ϴ�.");
	}
	@Override
	void displayMenuPrint(int i) {
		// TODO Auto-generated method stub
		switch(i) {
			case 1:
				System.out.println("[�� ��]");
				System.out.println("0. �� ������ �߰�");
				System.out.println("1. �˻�");
				System.out.println("2. ����");
				System.out.println("3. ����");
				System.out.print("�޴��� �����ϼ��� : ");
				break;
			case 2:
				System.out.println("�߸��� �����Դϴ�. 0~3�߿� �������ּ���. ���� �޴��� ���ư��ϴ�.");
				linePrint();
				break;
		}
	}
}
class PrintEng extends Print{
	@Override
	void addRecordPrint(int i) {
		// TODO Auto-generated method stub
		switch(i) {
			case 1:
				System.out.print("Insert name : ");
				break;
			case 2:
				System.out.print("Insert Address : ");
				break;
		}
	}
	@Override
	void RecordSearchPrint(String menu) {
		// TODO Auto-generated method stub
		switch(menu) {
			case "get":
				System.out.print("Enter a name to search for : ");
				break;
			case "del":
				System.out.print("Enter your name to delete the address : ");
				break;
		}
	}
	@Override
	void RecordResultPrint(String name, String address, String menu) {
		// TODO Auto-generated method stub
		switch(menu) {
			case "add":
				System.out.println(name + "'s address " + address + " added.");
				break;
			case "get":
				System.out.println(name + "'s address is " + address);
				break;
			case "del":
				System.out.println(name + "'s address " + address + " deleted.");
				break;
		}
	}
	@Override
	void noRecordPrint(String name) {
		// TODO Auto-generated method stub
		System.out.println("Could not found " + name + "'s address.");
	}
	@Override
	void displayMenuPrint(int i) {
		// TODO Auto-generated method stub
		switch(i) {
			case 1:
				System.out.println("[MENU]");
				System.out.println("0. Add new record");
				System.out.println("1. Search");
				System.out.println("2. Delete");
				System.out.println("3. Quit");
				System.out.print("Select Menu : ");
				break;
			case 2:
				System.out.println("Wrong number. Please select from 0 to 3. Return to previous menu.");
				linePrint();
				break;
		}
	}
}