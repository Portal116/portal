package jdbcTest;

import java.sql.*;

public class JdbcEx01{
    public static void main(String args[]){
    	String driver="com.mysql.cj.jdbc.Driver";
    	String url="jdbc:mysql://localhost:3306/employees";
    	String userid="root"; 
    	String passwd="1234";
    	
    	try {
			Class.forName(driver);
			System.out.println("드라이브 연결 성공");
			
			Connection con=DriverManager.getConnection(url, userid, passwd);
			System.out.println("MySQL 연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이브 연결 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL 연결 실패");
			e.printStackTrace();
		}
    	
    	
    }
}