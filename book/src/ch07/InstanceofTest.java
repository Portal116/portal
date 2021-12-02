package ch07;

public class InstanceofTest {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		if(fe instanceof FireEngine) {
			System.out.println("this is a FireEngine instance.");
		}
		
		if(fe instanceof Car) {
			System.out.println("This is a Car instance");
		}
		if(fe instanceof Object) {
			System.out.println("This is a Objectinstance");
		}
		System.out.println(fe.getClass().getName());
	}
}
