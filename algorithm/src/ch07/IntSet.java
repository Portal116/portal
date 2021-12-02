package ch07;


public class IntSet {
 private int max;
 private int num;
 private int[] set;
 
 public IntSet(int capacity) {
	// 생성자
	   num=0;
	   max=capacity;//capacity 집합에 넣을 수 있는 최대 원소의 수
	   try {
	   set = new int[max];
	   }catch(OutOfMemoryError e) {
		   max=0; //메모리 오류가 발생하면 최대 숫자를 0으로 바꾸어 메모리를 지운다.
	   }
 }
 
 public int capacity() {
	   return max;
 }
 public int size() {
	   return num;
 }
 public int indexOf(int n) {
	   for(int i=0;i<num;i++) 
		   if(set[i]==n) 
			   return i; //검색이 성공하면 찾은 자리의 i값을 반환하기
	   return -1;	   //검색이 실폐하면 -1을 반환한다.
	   
 }
 public boolean contains(int n) {
	  return (indexOf(n) != -1) ? true: false;
	  //만약에 indexOf메소드 호출해서 -1이 안 나오면 검색이 성공한 것이고 아니면 검색이 실패한 것임
 }
 public boolean add(int n) {
	   if(num >= max || contains(n) == true) 
		   return false;
	   else {
		   set[num++] = n; 
		   return true;
	   }
 }
 
 public boolean remove(int n) {
	   int idx;
	   if(num <=0 || (idx=indexOf(n)) == -1)  
		   return false;
	   else 
		   set[idx] = set[--num];
		   return true;
	   
 }
 //집합 s에 복사합니다.
 public void copyTo(IntSet s) {
	 int n=(s.max < num) ? s.max : num;//복사할 요소 개수
	 for(int i=0;i<n;i++) 
	    s.set[i] = set[i];
   s.num=0;
 }
 //집합 s를 복사합니다
 public void copyFrom(IntSet s) {
	   int n=(max<s.num) ? max :s.num;
	   for(int i=0;i<n;i++) 
	      set[i] = s.set[i];
     num = n;
 }
 public boolean equalTo(IntSet s) {
	   if(num != s.num) return false;
	   for(int i=0;i< num ; i++) {
		   int j=0;
		   for(; j<s.num; j++) {
			   if(set[i] == s.set[j]) break;
		if(j==s.num) return false;	   
		   }
	   }
	   return true;
 }  
 public void unionOf(IntSet s1, IntSet s2) {
	   copyFrom(s1);
	   for(int i=0;i<s2.num;i++) 
		   add(s2.set[i]);
 }
 
 @Override
	public String toString() {
		StringBuffer temp = new StringBuffer("{");
		for(int i=0;i<num;i++) temp.append(set[i] + " ");
		temp.append("}");
		
		return temp.toString();
	}
}