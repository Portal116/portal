package arrayExample;

import java.util.*;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڸ� 15�ڷ� �Է��ϼ��� : ");
		String str = sc.next();
		
		int[] alphabet = new int[26];
		
		for(int i=0;i<15;i++) {
			alphabet[str.charAt(i) -'a']++;
		}
		for(int i=0;i<26;i++) {
			if(alphabet[i] != 0) {
				System.out.println((char)('a'+ i) + "�� ���� : " + alphabet[i] + "��");
			}
		}
	}
}