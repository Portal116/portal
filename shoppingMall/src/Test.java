
public class Test {
	public static void main(String[] args) {
		
	}
public static void print(Employee e) {
	if(e instanceof Salesman) {
		System.out.println("Salesman�Դϴ�.");
	} else if(e instanceof Manager) {
		System.out.println("Manager�Դϴ�.");
	} if(e instanceof Consultant) {
		System.out.println("Consultant�Դϴ�.");
	} 
}
}
