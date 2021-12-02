package test;

import java.io.*;
import java.util.*;

public class test {
	public static void main(String[] args) {
		Car c = new Car();
		Car cc = new ECar();
		
		cc.method();
		c.method();
	}
}
class Car{

	public void method() {
		// TODO Auto-generated method stub
		System.out.println("1");
	}
	
}
class ECar extends Car{
	@Override
	public void method() {
		System.out.println("2");
	}
}