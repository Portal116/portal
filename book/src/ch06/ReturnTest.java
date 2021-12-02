package ch06;

public class ReturnTest {
	public static void main(String[] args) {
		ReturnTest r = new ReturnTest();
		
		int result = r.add(3,5);
		System.out.println(result);
		
		int[] result2 = {0};
		r.add(3, 5,result2);
		System.out.println(result2[0]);
	}

	void add(int i, int j, int[] result) {
		// TODO Auto-generated method stub
		result[0] = i+j;
	}

	int add(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}
}
