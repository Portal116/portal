package bookEx;

public class P469 {
	public static void main(String[] args) {
		char[] c = {'H','e','l','l','o'};
		String s = new String(c);
		System.out.println(s);
		
		StringBuffer sb = new StringBuffer("Hello");
		String s2= new String(sb);
		System.out.println(s2);
	}
}
