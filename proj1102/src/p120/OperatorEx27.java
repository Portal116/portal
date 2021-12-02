package p120;

public class OperatorEx27 {
	public static void main(String[] args) {
		boolean b = true;
		char ch = 'C';
		
		System.out.print(String.format("b=%b%n", b));
		System.out.print(String.format("!b=%b%n", b));
		System.out.print(String.format("!!b=%b%n", b));
		System.out.print(String.format("!!!b=%b%n", b));
		System.out.println();
		
		System.out.print(String.format("ch=%c%n", ch));
		//System.out.print(String.format("ch의 유니코드값은 = %d%n", ch));
		System.out.print(String.format("ch < 'a' ch> 'z' = %b%n", ch<'a' || ch>'z'));
		System.out.print(String.format("!('a'<=ch ch<='z') = %b%n", !(ch<'a' || ch>'z')));
		System.out.println(String.format("  'a'<=ch && ch<='z' = %b%n", ch>='a' && ch<='z'));
		
		int x = 0xAC, y = 0xF;
		
		System.out.printf("x= %#X \t\t%s%n", x, toBinaryString(x));
		System.out.printf("y= %#X \t\t\t%s%n", y, toBinaryString(y));
		System.out.printf("%#X & %#X = %#X \t%s%n", x,y,x&y, toBinaryString(x&y));
		System.out.printf("%#X | %#X = %#X \t%s%n", x,y,x|y, toBinaryString(x|y));
		System.out.printf("%#X ^ %#X = %#X \t%s%n", x,y,x^y, toBinaryString(x^y));
		
		int dec = 8;
		System.out.printf("%d >> %d =%4d \t\t%s%n", dec, 3, dec >> 3, toBinaryString(dec >> 3));
		System.out.printf("%d << %d =%4d \t\t%s%n", dec, 3, dec << 3, toBinaryString(dec << 3));
	}

	private static String toBinaryString(int x) {
		// TODO Auto-generated method stub
		String zero = "00000000000000000000000000000000";
		String temp = zero + Integer.toBinaryString(x);
		return temp;
	}
}