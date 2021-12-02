package forWhileEx;

public class Ex02 {
	public static void main(String[] args) {
		for(int i=0;i<=7;i++) {
			for(int j=7-i;j>0;j--) {
				System.out.print(" ");
			}
			
			int num = -i;
			for(int k=0;k<2*i+1;k++) {
				System.out.print(Math.abs(num));
				num++;
			}
			
			for(int j=7-i;j>0;j--) {
				System.out.print(" ");
			}
			
			System.out.println();
		}
	}
}