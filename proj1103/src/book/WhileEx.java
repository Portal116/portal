package book;

public class WhileEx {
	public static void main(String[] args) {
		int i=0;
		int cnt = 0;
		int tot = 0;
		int sum = 0;
		while(i<300) {
			cnt++;
			i+=2;
			if(cnt == 20) {
				System.out.println();
				cnt = 0;
			}
			
			if(i%10 == 0)
				continue;
			tot++;
			sum += i;
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("전체 출력된 갯수는 " + tot + "개입니다.");
		System.out.println("합계는 " + sum + "입니다.");
	}
}