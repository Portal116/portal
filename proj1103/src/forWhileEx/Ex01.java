package forWhileEx;

public class Ex01 {
	public static void main(String[] args) {
		int num=0;
		int count=0;
		while(num<100) {
			num++;
			if(num%2 == 0 || num%3 == 0 || num%5 == 0 || num%7 ==0)				
				continue;
			if(count == 10) {
				System.out.println();
				count = 0;
			}
			System.out.print(num + " ");
			num++;
			count++;
		}
	}
}