package javaProject2;

public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book("B001", "자바 프로그래밍", "홍길동", 25000, 2021, "멀티출판사");
		Book b2 = new Book("B002", "자바스크립트", "이몽룡", 30000, 2020, "서울출판사");
		Book b3 = new Book("B003", "HTML/CSS", "성춘향", 18000, 2021, "강남출판사");
		
		Magazine m1 = new Magazine("M001", "자바 월드", "홍길동", 25000, 2021, "멀티출판사", 5);
		Magazine m2 = new Magazine("M002", "웹 월드", "이몽룡", 30000, 2020, "서울출판사", 7);
		Magazine m3 = new Magazine("M003", "게임 월드", "성춘향", 18000, 2021, "강남출판사", 9);
		
		System.out.println("도서번호\t도서명\t\t저자\t가격\t발행일\t출판사");
		System.out.println("---------------------------------------------------------");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println();
		
		System.out.println("잡지번호\t잡지명\t발행인\t가격\t발행연도\t출판사\t발행월");
		System.out.println("---------------------------------------------------------");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
	}
}
class Book{
	String bookNo;
	String bookTitle;
	String bookAuthor;
	int bookYear;
	int bookPrice;
	String bookPublisher;
	
	public Book(String bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookYear = bookYear;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bookNo + "\t" + bookTitle + "\t" + bookAuthor + "\t" + bookPrice + "\t" + bookYear + "\t" + bookPublisher;
	}	
}
class Magazine extends Book{
	int month;
	
	public Magazine(String bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher,
			int month) {
		super(bookNo, bookTitle, bookAuthor, bookPrice, bookYear, bookPublisher);
		this.month = month;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\t   " + month;
	}
}