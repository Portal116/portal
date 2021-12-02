package cafe1369;

import java.util.*;

public class VectorEx {
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));

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