package ch03;
import java.util.*;

public class p105 {
	public static void main(String[] args) {
		Integer[] num = {3, 5, 0, 9, 4, 7, 8, 2, 11, 100};
		Integer searchNum = 3;
		List<Integer> numList = new ArrayList<Integer>();
		numList.addAll(Arrays.asList(num));
		numList.add(searchNum);
		
		int i=0;
		while(true) {
			if(searchNum == numList.get(i)) {
				break;
			}
			i++;
		}
		if(i == numList.size() - 1)
			System.out.println("목록에 숫자가 없습니다");
		else
			System.out.println(numList.get(i) + " 을 " + (i+1) + "번 만에 찾았다.");
	}
}