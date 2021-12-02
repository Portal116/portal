package operationEx;

public class test {
	public static void main(String[] args) {
		double numDouble = 48.4;
		int numBin1 = 0B101011;
		int numBin2 = 0B101101;
		int numOct1 = 061;
		int numOct2 = 012;
		int numHex = 0X1A;
		int decimalLength = 10;
		
		int numDoubleInt = (int)numDouble;
		numDouble = numDouble - numDoubleInt;
		
		StringBuilder sb = new StringBuilder();
		double temp = numDouble;
		while(temp>0 && sb.length()<decimalLength) {
			temp *= 2;
			if(temp>=1) {
				sb.append(1);
				temp--;
			}
			else
				sb.append(0);
		}
		System.out.println(Integer.toBinaryString(numDoubleInt) + "." + sb);
		// 110000.011001100110
		
		StringBuilder sb2 = new StringBuilder();
		double temp2 = numDouble;
		while(temp2>0 && sb2.length()<decimalLength) {
			temp2 *= 8;
			if(temp2>=1) {
				sb2.append(String.format("%o",(int)temp2));
				temp2 -= (int)temp2;
			}
			else
				sb2.append(0);
		}
		System.out.println(Integer.toOctalString(numDoubleInt) + "." + sb2);
		// 60.31463146
		
		StringBuilder sb3 = new StringBuilder();
		double temp3 = numDouble;
		while(temp3>0 && sb3.length()<decimalLength) {
			temp3 *= 16;
			if(temp3>=1) {
				sb3.append(String.format("%x",(int)temp3));
				temp3 -= (int)temp3;
			}
			else
				sb3.append(0);
		}
		System.out.println(Integer.toHexString(numDoubleInt) + "." + sb3);
		// 30.6666
		
		System.out.println(String.format("%d", numBin1));
		// 43
		System.out.println(String.format("%d", numBin2));
		//45
		System.out.println(String.format("%d", numOct1));
		//49
		System.out.println(String.format("%d", numOct2));
		//10		
		System.out.println(String.format("%d", numHex));
		//26
	}
}
