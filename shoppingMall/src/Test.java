public class Test {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		if(obj1.hashCode(obj2)) {
			System.out.println("1");
		}
	}
}
