
public class Test {
	public static void main(String[] args) {
		
	}
public static void print(Employee e) {
	if(e instanceof Salesman) {
		System.out.println("Salesman입니다.");
	} else if(e instanceof Manager) {
		System.out.println("Manager입니다.");
	} if(e instanceof Consultant) {
		System.out.println("Consultant입니다.");
	} 
}
}
