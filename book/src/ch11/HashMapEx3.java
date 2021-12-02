package ch11;

import java.util.*;
import java.util.Map.Entry;

public class HashMapEx3 {
	static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<String, HashMap<String, String>>();
	
	public static void main(String[] args) {
		addPhoneNo("ģ��", "���ڹ�", "010-111-1111");
		addPhoneNo("ģ��", "���ڹ�", "010-222-2222");
		addPhoneNo("ģ��", "���ڹ�", "010-333-3333");
		addPhoneNo("ȸ��", "��븮", "010-444-4444");
		addPhoneNo("ȸ��", "��븮", "010-555-5555");
		addPhoneNo("ȸ��", "�ڴ븮", "010-666-6666");
		addPhoneNo("ȸ��", "�̰���", "010-777-7777");
		addPhoneNo("��Ź", "010-888-8888");
		
		printList();
	}
	
	static void addPhoneNo(String groupName, String name, String tel) {
		// TODO Auto-generated method stub
		addGroup(groupName);
		HashMap<String, String> group = phoneBook. get(groupName);
		group.put(tel, name);
	}

	static void addGroup(String groupName) {
		// TODO Auto-generated method stub
		if(!phoneBook.containsKey(groupName)) //groupName�� Key
			phoneBook.put(groupName, new HashMap<String, String>());
	}
	
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("��Ÿ", name, tel);
	}
	
	static void printList() {
		Set<Entry<String, HashMap<String, String>>> set = phoneBook.entrySet();
		Iterator<Entry<String, HashMap<String, String>>> it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, HashMap<String, String>> e = it.next();
			
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			
			System.out.println(" * " + e.getKey() + "[" + subSet.size() + "]");
			
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				String telNo = (String)subE.getKey();
				String name = (String)subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
		}
	}
	
}
