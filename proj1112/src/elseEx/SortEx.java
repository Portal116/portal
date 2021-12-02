package elseEx;

import java.util.*;

public class SortEx {
	public static void main(String[] args) {
		Integer[] ia = {0,1,4,2,10};
		Arrays.sort(ia, (o1, o2) -> o2.compareTo(o1));
		System.out.println(Arrays.toString(ia));
		
		Integer[] iaa = {0,1,4,2,10};
		Arrays.sort(iaa, Collections.reverseOrder());
		System.out.println(Arrays.toString(iaa));
	}
}