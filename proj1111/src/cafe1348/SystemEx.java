package cafe1348;

public class SystemEx {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(time);
		long nanotime = System.nanoTime();
		System.out.println(nanotime);
		
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("user.dir"));
		
		Object obj = new SystemEx();
		Class c = obj.getClass();
		String name = c.getName();
		System.out.println(name);
		int cc = c.getModifiers();
		System.out.println(cc);
	}
}