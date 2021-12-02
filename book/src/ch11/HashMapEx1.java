package ch11;

import java.util.*;

public class HashMapEx1 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
		Object obj = map.get("myId");
		System.out.println((String)obj);
		
		Object get1 = map.get("asdf");
		System.out.println(get1);
		System.out.println(map.size());
		
		get1 = map.get("asdffff");
		System.out.println(get1);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("id�� password�� �Է��ϼ���");
			System.out.print("id : ");
			String id = sc.nextLine().trim();
			
			System.out.print("password : ");
			String password = sc.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("�Կ��Ͻ� id�� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			
			if(!(map.get(id).equals(password)))
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���");
			else {
				System.out.println("id�� ��й�ȣ�� ��ġ�մϴ�.");
				break;
			}
		}
	}
}
