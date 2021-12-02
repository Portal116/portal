package ch07;


public class IntSet {
 private int max;
 private int num;
 private int[] set;
 
 public IntSet(int capacity) {
	// ������
	   num=0;
	   max=capacity;//capacity ���տ� ���� �� �ִ� �ִ� ������ ��
	   try {
	   set = new int[max];
	   }catch(OutOfMemoryError e) {
		   max=0; //�޸� ������ �߻��ϸ� �ִ� ���ڸ� 0���� �ٲپ� �޸𸮸� �����.
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
			   return i; //�˻��� �����ϸ� ã�� �ڸ��� i���� ��ȯ�ϱ�
	   return -1;	   //�˻��� �����ϸ� -1�� ��ȯ�Ѵ�.
	   
 }
 public boolean contains(int n) {
	  return (indexOf(n) != -1) ? true: false;
	  //���࿡ indexOf�޼ҵ� ȣ���ؼ� -1�� �� ������ �˻��� ������ ���̰� �ƴϸ� �˻��� ������ ����
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
 //���� s�� �����մϴ�.
 public void copyTo(IntSet s) {
	 int n=(s.max < num) ? s.max : num;//������ ��� ����
	 for(int i=0;i<n;i++) 
	    s.set[i] = set[i];
   s.num=0;
 }
 //���� s�� �����մϴ�
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