package ch15;

import java.util.*;
import java.io.*;

public class SerialEx2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String fileName = "UserInfo.ser";
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		ObjectInputStream in = new ObjectInputStream(bis);
		
		UserInfo u1 = (UserInfo)in.readObject();
		UserInfo u2 = (UserInfo)in.readObject();
		ArrayList list = (ArrayList)in.readObject();
		
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(list);
		in.close();
		System.out.println("역직렬화 끝");
	}
}