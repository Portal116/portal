package arrayEx2;

public class P219 {
	public static void main(String[] args) {
		int[][] ia = new int[3][];
		
		ia[0]=new int[4];
		ia[0][0]=1;
		ia[0][1]=2;
		ia[0][2]=3;
		ia[0][3]=4;
		//ia[0][4]=5; 인덱스 범위를 벗어나는 오류, 실행시 나는 오류
		
       ia[1] = new int[2];
       ia[1][0]=5;
       ia[1][1]=6;
       
       ia[2]=new int[3];
       ia[2][0]=7;
       ia[2][1]=8;
       ia[2][2]=9;
       
       for(int i=0;i<ia.length;i++) {
    	   for(int j=0;j<ia[i].length;j++)
    		   System.out.print(ia[i][j]+ " ");
    	   System.out.println();
       }

	}
}
