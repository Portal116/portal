package javaProject2;

public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book("B001", "�ڹ� ���α׷���", "ȫ�浿", 25000, 2021, "��Ƽ���ǻ�");
		Book b2 = new Book("B002", "�ڹٽ�ũ��Ʈ", "�̸���", 30000, 2020, "�������ǻ�");
		Book b3 = new Book("B003", "HTML/CSS", "������", 18000, 2021, "�������ǻ�");
		
		Magazine m1 = new Magazine("M001", "�ڹ� ����", "ȫ�浿", 25000, 2021, "��Ƽ���ǻ�", 5);
		Magazine m2 = new Magazine("M002", "�� ����", "�̸���", 30000, 2020, "�������ǻ�", 7);
		Magazine m3 = new Magazine("M003", "���� ����", "������", 18000, 2021, "�������ǻ�", 9);
		
		System.out.println("������ȣ\t������\t\t����\t����\t������\t���ǻ�");
		System.out.println("---------------------------------------------------------");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println();
		
		System.out.println("������ȣ\t������\t������\t����\t���࿬��\t���ǻ�\t�����");
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