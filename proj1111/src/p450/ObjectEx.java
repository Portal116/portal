package p450;

public class ObjectEx {
	public static void main(String[] args) {
		String name = "abcd";
		System.out.println(String.valueOf('a').length());
		String n = new String("abcd");
		char ch = n.charAt(1);
		System.out.println(ch);
		String s = n.concat("dddd");
		System.out.println(s);
		A a = new A();
		System.out.println(a.getClass());
		System.out.println(a.hashCode());
		String name1 = "ȫ�浿";
		String name2 = "ȫ�浿";
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		System.out.println(name1.toString());
		
		
	}
}
class A extends Object{
	
}