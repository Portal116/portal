package arrayEx2;

public class P208 {
	public static void main(String[] args) {
		char[] c2 = new char[10];
		String name = "abcdefg";
		
		c2[2] = name.charAt(2);
		
		char[] tca = name.toCharArray();
		for(int i=0;i<name.length();i++)
			System.out.print(tca[i] + " ");
		System.out.println();
		for(char ch : tca)
			System.out.print(ch + " ");
		System.out.println();
		
		// 2차원 배열
		int[][] scores = {{1,2,3},{4,5,6} };
		System.out.println(scores[0][2]);
		System.out.println(scores[1][1]);
        char[][] c = { {'a','b'}, {'c','d'},{'e','f'} };
        for(char[] a : c) {
        	for( char cc : a) {
        		System.out.print(cc + " ");
        	}
        	System.out.println();
        }
        System.out.println(c.length);
        System.out.println(c[0].length);
        for(int i=0;i<c.length;i++) {
        	for(int j=0;j<c[i].length;j++)
        		System.out.print(c[i][j]+" ");
        	System.out.println();
        }
	}
}