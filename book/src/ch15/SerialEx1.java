package ch15;

import java.io.*;
import java.util.*;

public class SerialEx1 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream		fos = new FileOutputStream(fileName);
			BufferedOutputStream	bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
			UserInfo u2 = new UserInfo("JavaWoman", "4321", 26);
			
			ArrayList<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			out.close();
			System.out.println("직렬화 끝");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class UserInfo implements Serializable{
	String name;
	String password;
	int age;
	int score;
	
	static final long serialVersionUID = 12345678912345678L;
//	int score을 추가했지만 어떤 파일인지 알 수 있어서 에러가 안남
	
	UserInfo(){
		this("Unkown", "1111", 0);
	}
	
	UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + name + ", " + password + ", " + age + ")";
	}	
}