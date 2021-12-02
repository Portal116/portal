package bookEx;

public class StringBufferEx {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
//		sb = "Hi";
		sb.append("Hi");
		sb.append(" MultiCampus");
		System.out.println(sb);
		System.out.println(sb.charAt(5));
	}
}