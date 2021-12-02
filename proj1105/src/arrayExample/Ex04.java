package arrayExample;

import java.util.*;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자를 15자로 입력하세요 : ");
		String str = sc.next();
		
		int[] alphabet = new int[26];
		
		for(int i=0;i<15;i++) {
			alphabet[str.charAt(i) -'a']++;
		}
		for(int i=0;i<26;i++) {
			if(alphabet[i] != 0) {
				System.out.println((char)('a'+ i) + "의 갯수 : " + alphabet[i] + "개");
			}
		}
	}
}