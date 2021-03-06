package ch10;

import java.util.Comparator;

public class BinTree<K,V> {
   static class Node<K,V> {
	   private K key;
	   private V data;
	   private Node<K,V> left;
	   private Node<K,V> right;
	   
	   public Node(K key, V data, Node<K,V> left, Node<K,V> right) {
		  this.key = key;
		  this.data = data;
		  this.left = left;
		  this.right = right;
	   }
	   
	   K getKey() {
		   return key;
	   }
	   
	   V getValue() {
		   return data;
	   }
	   void print() {
		   System.out.println(data);
	   }
	 }//end Node class
   
   private Node<K,V> root; //루트
   private Comparator<? super K> comparator = null;//비교자 
  
   public BinTree() {
	   root = null;
   }
   public BinTree(Comparator<? super K> c ) {
	   this(); //기본생성자 호출
	   comparator = c; 
   }
   //(Comparable<K>) key1).compareTo(key2) - 비교방법  처음에 root에 달아 줄때 
   //comparator.compare(key1, key2) - 노드가 1개이상 달려 있어서 비교할 대상이 있는 경우
   private int comp(K key1, K key2) { //383page 64줄에서  호춯 
	   return (comparator == null) ? ( (Comparable<K>) key1).compareTo(key2) :  comparator.compare(key1, key2);
   }
   
   //키에 의한 검색
   public V search(K key) {
	   Node<K,V> p = root;//근노드의 주소를 p변수에
	   while(true) {
		   if(p==null) return null;
		   int cond = comp(key, p.getKey());
		   if(cond==0) return p.getValue();
		   else if(cond < 0) p=p.left;
		   else p=p.right;
	   }
   }
   
   //노드 삽입하기
   private void addNode(Node<K,V> node, K key, V data) {
	   int cond=comp(key, node.getKey());
	   if(cond==0) return; //이미 트리에 달려 있는 경우 
	   else if(cond < 0) { //왼쪽 가지로 달아주는 경우
		   if(node.left == null) node.left = new Node<K,V>(key, data, null, null);
		   else addNode(node.left, key, data);
       }else { //오른쪽 가지로 달아 주는 경우
    	   if(node.right == null) node.right = new Node<K,V>(key, data, null, null);
    	   else addNode(node.right, key, data);
       }
   }
   //삽입할 때 노드가 한개도 안달려 있을 때와 한개이상 달려 있을 때를 판단해서 위의 노드 삽입메소드로 호출함
   public void add(K key, V data) {
	   if(root == null) root = new Node<K,V>(key, data, null, null);
	   else addNode(root, key, data);
   }
  
   public boolean remove(K key) {
	   Node<K,V> p = root;
	   Node<K,V> parent = null;
	   boolean isLeftChild=true;
	   //삭제할 노드의 위치를 찾기 
	   while(true) {
		   if(p==null) return false;
		   int cond = comp(key, p.getKey());
		   if(cond==0) break;
		   else {
			   parent = p;
			   if(cond < 0) {
				   isLeftChild = true;
				   p = p.left;
			   }else {
				   isLeftChild = false;
				   p=p.right;
			   }
		   }
	   }//end while
	   if(p.left == null) { //그림 10-14의 3을 지우는 경우
		   if(p == root)   root = p.right;
		   else if( isLeftChild ) parent.left = p.right;
		   else parent.right = p.right;
	   }else if(p.right == null) {
		   if(p==root) root=p.left;
		   else if(isLeftChild) parent.left = p.left;
		   else parent.right = p.left;
	   }else {
		   parent = p;
		   Node<K, V> left = p.left;
		   isLeftChild = true;
		   while(left.right != null) {
			   parent = left;
			   left = left.right;
			   isLeftChild = false;
		   }
		   p.key=left.key;
		   p.data = left.data;
		   if(isLeftChild) parent.left = left.left;
		   else parent.right = left.left;
       }
	       return true;   
   }
   
   private void printSubTree(Node node) {
	   if(node != null) {
		   printSubTree(node.left);
		   System.out.println(node.key + " " + node.data);
		   printSubTree(node.right);
	   }
   }
   public void print() {
	   printSubTree(root);
   }
  
}
