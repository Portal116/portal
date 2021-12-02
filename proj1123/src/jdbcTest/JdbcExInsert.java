package jdbcTest;

import java.sql.*;

public class JdbcExInsert{
    public static void main(String args[]){
    	String driver="com.mysql.cj.jdbc.Driver";
    	String url="jdbc:mysql://localhost:3306/mydb";
    	String userid="root"; 
    	String passwd="1234";
    	
    	Connection con=null;
    	Statement stmt=null;
    	ResultSet rs=null;
    	
    	try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, userid, passwd);
			stmt = con.createStatement();
			String sql="INSERT INTO EMP VALUES (8888,'MILLER','CLERK',7782,'82-01-11',1300,NULL,10);";
			int n=stmt.executeUpdate(sql);
			System.out.println(n+"개의 레코드가 저장");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}