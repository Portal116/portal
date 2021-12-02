package cafe1369;

import java.util.*;

public class VectorEx {
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		list.add(new Board("����1", "����1", "�۾���1"));
		list.add(new Board("����2", "����2", "�۾���2"));
		list.add(new Board("����3", "����3", "�۾���3"));
		list.add(new Board("����4", "����4", "�۾���4"));
		list.add(new Board("����5", "����5", "�۾���5"));

		list.remove(2);
		list.remove(3);
		for(int i=0; i<list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
		}
		System.out.println(list.get(0).subject);
		System.out.println(list.get(0).writer);
		System.out.println(list.get(0).subject + " " + list.get(0).content);
		System.out.println(list.get(1).content + " " + list.get(0).writer);
	}
}
class Board{
	public String subject;
	public String content;
	public String writer;
	
	public Board(String subject, String content, String writer) {
		// TODO Auto-generated constructor stub
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}	
}