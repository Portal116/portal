package ch15;

import java.io.*;

public class FileViewer {
	public static void main(String[] args) throws IOException{
		FileInputStream fis2 = new FileInputStream(args[0]);
		FileOutputStream fos2 = new FileOutputStream("C:/Temp/copyfile1.txt");
		int data = 0;
		
		while((data = fis2.read()) != -1) {
			char c = (char)data;
//			System.out.print(c);
			fos2.write(data);
		}
		fos2.close();
		fis2.close();
	}
}