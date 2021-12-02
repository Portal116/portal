package jdbcTest;

import java.sql.*;

public class JdbcExSearch{
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
			String query = "select * from emp";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int EMPNO =  rs.getInt("EMPNO");
				String ENAME = rs.getString("ENAME");
				String JOB = rs.getString("JOB");
				int MGR = rs.getInt("MGR");
				Date HIREDATE = rs.getDate("HIREDATE");
				double SAL = rs.getDouble("SAL");
				double COMM = rs.getDouble("COMM");
				int DEPTNO = rs.getInt("DEPTNO");
				System.out.printf("%4d  %-10s  %-9s  %4d  %10s  %8.2f  %8.2f  %2d\n",EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO);
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