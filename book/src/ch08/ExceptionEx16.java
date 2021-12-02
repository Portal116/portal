package ch08;

import java.io.*;

public class ExceptionEx16 {
	public static void main(String[] args) {
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName() + " ������ ���������� ������");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " �ٽ� �Է����ֽñ� �ٶ��ϴ�.");
		}		
	}
	static File createFile(String fileName) throws Exception {
		if(fileName == null || fileName.equals(""))
			throw new Exception("���� �̸��� ��ȿ���� ����");
		File f = new File(fileName);
		createNewFile(f);
		return f;
	}
	static void createNewFile(File f) {
		try {
			f.createNewFile();
		} catch(Exception e) {
		}
	}
}