package jdbcTest;

import java.sql.*;
import java.util.*;

public class JdbcExUpdate{
    public static void main(String args[]){
    	String driver="com.mysql.cj.jdbc.Driver";
    	String url="jdbc:mysql://localhost:3306/mydb";
    	String userid="root"; 
    	String passwd="1234";
    	
    	Connection con=null;
//    	Statement stmt=null;
//    	ResultSet rs=null;
    	PreparedStatement pstmt = null;
    	PreparedStatement pstmtNull = null;
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("deptno : ");
    	int deptnoV = sc.nextInt();
    	
    	try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, userid, passwd);
//			stmt = con.createStatement();
//			String sql="UPDATE dept SET dname='인사', loc='부산' WHERE deptno=50";
			String sql="UPDATE emp SET comm = comm + 100 WHERE comm is not null and deptno = ?";
			pstmt = con.prepareStatement(sql);			
			pstmt.setInt(1, deptnoV);			
			int n = pstmt.executeUpdate();
			System.out.println(n+" 개의 레코드가 수정");
//			String sqlNull = "update emp set comm = 100 where deptno = ? and comm is null";
//			pstmtNull = con.prepareStatement(sqlNull);
//			pstmtNull.setInt(1, deptnoV);
//			int m = pstmtNull.executeUpdate();
//			System.out.println((n+m)+" 개의 레코드가 수정");
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
}