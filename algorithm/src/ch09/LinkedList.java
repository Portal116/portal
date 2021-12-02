package ch09;

import java.util.Comparator;

public class LinkedList<E> {
	class Node<E> {
		private E data;
		private Node<E> next; 

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}//end Node<E>

	private Node<E> head;
	private Node<E> crnt;

	public LinkedList(){
		head = crnt = null;
	}

	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;

		while(ptr != null) {
			if(c.compare(obj, ptr.data) == 0) { //검색 성공
				crnt=ptr;
				return ptr.data;
			}
			ptr=ptr.next;
		}
		return null;//검색 실패 
	}

	public void addFirst(E obj) {
		Node<E> ptr = head;
		head = crnt = new Node<E>(obj, ptr);
	}

	public void addLast(E obj) {
		if(head==null) addFirst(obj);
		else {
			Node<E> ptr = head;
			while(ptr.next != null ) ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}

	public void removeFirst() { //제일 처음에 있는 node A삭제
		if(head != null)  head = crnt = head.next;
	}

	//제일 마지막에 있는 노드 F삭제하기
	public void removeLast() {
		if(head != null) { //삭제할 노드가 있으면 
			if(head.next == null) removeFirst(); //삭제할 노드가 1개면 
			else {                       //노드가 2개 이상 있으면 
				Node<E> ptr = head;
				Node<E> pre = head;

				while(ptr.next != null) {
					pre=ptr;
					ptr = ptr.next;
				}
				ptr.next = null;
				crnt = pre; 
			}     
		}
	}

	public void remove(Node p) {
		if(head !=null) {
			if(p == head) removeFirst();
			else {
				Node<E> ptr = head;
				while(ptr.next != p) {
					ptr=ptr.next;
					if(ptr == null) return ;
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}
	
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	public void clear() {
		while(head != null)  removeFirst();
		crnt = null;
	}
		
	public boolean next() {
		if(crnt == null || crnt.next == null) return false;
		crnt = crnt.next;
		return true;
	}
	
	public void printCurrentNode() {
		if(crnt == null) System.out.println("선택한 노드가 없습니다");
		else System.out.println(crnt.data);
	}
	
	public void dump() {
		Node<E> ptr = head;
		while(ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
}//end P311LinkedList







