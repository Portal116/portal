package dbProject;

import java.sql.*;

public class BookDAO{
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/bookDB";
	String userid="root"; 
	String passwd="1234";
	
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	
	public BookDAO(){
		try{
		Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void insertBook(BookDTO bookDTO) {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, userid, passwd);
			String sql="insert into book values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);	
			pstmt.setString(1, bookDTO.getBookNo());
			pstmt.setString(2, bookDTO.getBookTitle());
			pstmt.setString(3, bookDTO.getBookAuthor());
			pstmt.setInt(4, bookDTO.getBookYear());
			pstmt.setInt(5, bookDTO.getBookPrice());
			pstmt.setString(6, bookDTO.getBookPublisher());
			int n = pstmt.executeUpdate();
			if(n>0)
				System.out.println("입력 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void selectBook() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, userid, passwd);
			stmt = con.createStatement();
			String query = "select * from book";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String bookNo = rs.getString("bookNo");
				String bookTitle = rs.getString("bookTitle");
				String bookAuthor = rs.getString("bookAuthor");
				int bookYear =  rs.getInt("bookYear");
				int bookPrice =  rs.getInt("bookPrice");
				String bookPublisher = rs.getString("bookPublisher");
				System.out.printf("%s\t%s\t%s\t%d\t%d\t%s\n",
						bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}