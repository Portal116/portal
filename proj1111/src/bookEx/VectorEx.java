package bookEx;

import java.util.*;

public class VectorEx {
	public static void main(String[] args) {
		Vector v1 =new Vector();
		v1.add(new Integer(1));
		v1.add(new Integer(0));
		v1.add(new Integer(0));
		print(v1);
		
		v1.add(1,"b");
		print(v1);
		
		System.out.println(v1.contains(new Integer(0)));
		System.out.println();
		
		v1.remove(new Integer(1));
		print(v1);
		try {
			Collections.sort(v1);
			print(v1);
		} catch (ClassCastException e) {
			System.out.println("���� �ٸ��ϴ�");
			e.printStackTrace();
		} finally {
			System.out.println("������ ������� �ݵ�� ó��");
		}
		
	}
	public static void print(Vector v) {
		Iterator it = v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
	}
}
