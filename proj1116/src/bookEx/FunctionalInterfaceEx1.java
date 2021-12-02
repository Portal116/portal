package bookEx;

public class FunctionalInterfaceEx1 {
	public static void main(String[] args) {
		AddFunction af = (x, y) -> System.out.println(x+y);
		af.addMethod(1, 2);
	}
}
@FunctionalInterface
interface AddFunction{
	void addMethod(int x, int y);
}