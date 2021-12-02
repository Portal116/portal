package dbProject;

import java.util.*;

public class BookTest {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
    	BookDAO bka = new BookDAO();
    	BookDTO bkt = new BookDTO();
    	
    	System.out.print("bookNo : ");
    	bkt.setBookNo(sc.nextLine());
    	System.out.print("bookTitle : ");
    	bkt.setBookTitle(sc.nextLine());
    	System.out.print("bookAuthor : ");
    	bkt.setBookAuthor(sc.nextLine());
    	System.out.print("bookYear : ");
    	bkt.setBookYear(sc.nextInt());
    	sc.nextLine();
    	System.out.print("bookPrice : ");
    	bkt.setBookPrice(sc.nextInt());
    	sc.nextLine();
    	System.out.print("bookPublisher : ");
    	bkt.setBookPublisher(sc.nextLine());
    	
    	bka.insertBook(bkt);
    	System.out.println();
    	
    	bka.selectBook();
    	
    	sc.close();
	}
}