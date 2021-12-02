package arrayEx2;

public class P216 {
	public static void main(String[] args) {
		double[][][] jumsu = {{{1.1,2.2}, {3.3,4.4}, {5.5,6.6}},
				{{7.7,8.8}, {9.9,10.10}, {11.11,12.12}}};
		System.out.println(jumsu[0][2][0]);
		System.out.println(jumsu[1][1][0]);
		
		for(int i=0;i<jumsu.length;i++) {
			for(int j=0;j<jumsu[0].length;j++) {
				for(int k=0;k<jumsu[0][0].length;k++)
					System.out.print(jumsu[i][j][k] + " ");
				System.out.print("\t");
			}System.out.println();
		}
		
		for(double[][] x : jumsu) {
			for(double[] y : x) {
				for(double z : y)
					System.out.print(z + " ");
				System.out.print("\t");
			}
			System.out.println();
		}		
	}
}