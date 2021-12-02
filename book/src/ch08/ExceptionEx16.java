package ch08;

import java.io.*;

public class ExceptionEx16 {
	public static void main(String[] args) {
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName() + " 파일이 성공적으로 생성됨");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " 다시 입력해주시기 바랍니다.");
		}		
	}
	static File createFile(String fileName) throws Exception {
		if(fileName == null || fileName.equals(""))
			throw new Exception("파일 이름이 유효하지 않음");
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