package ch01;

public class Var01 {
	public static void main(String[] args) {
		byte ba = 10;
		short sa = 20;
		byte bba;
		bba = ba; //1byte -> 1byte
		sa = ba; //1byte -> 2byte
		ba = (byte)sa; //2byte -> 1byte
		
		byte bb = 20;
		short sb = 30;
		short sumb;
		sumb = (short) (bb+sb);
		
		float fa = 10.0f;
		double dda = 10.0;
		dda = fa;
		fa = (float)dda;
		
		fa = bb;
		int ii = 100;
		fa = ii;
		dda = ii;
		ii = (int)fa;
		ii = (int)dda;
		
		char ca = 'a';
		int ica = 0;
		ica = ca;
		
		/*
		ChildVar cv = new ChildVar();
		int $va; // 변수 앞에는 $ or _ 만 가능
		$va = 50;
		//intA = "문자열";
		int customerNumber; //고객번호
		String sA;
		sA = "문자열";
		
		ChildVar cs;
		
		byte ba;
		ba = 90;
		cs = new ChildVar();
		
		int da = 10;
		int oa = 010;
		int ha = 0x10;
		System.out.println(da);
		System.out.println(oa);
		System.out.println(ha);
		*/
	}
}

class ChildVar{
	int cc; //4byte
	double dd; //8byte
}

class ChildVar02{
	
}