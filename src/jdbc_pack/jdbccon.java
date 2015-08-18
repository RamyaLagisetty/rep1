package jdbc_pack;

import java.sql.*;

public class jdbccon {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	Statement st=con.createStatement();
	
	String sql="select empno,ename,sal from emp where sal<2000";
	String sql1="update  emp set sal=800 where sal=900";
	ResultSet rs=st.executeQuery(sql);
	
	while(rs.next()){
		System.out.println(rs.getInt(1)+" "+rs.getString("ename")+" "+rs.getInt(3));
	}
	int rs1=st.executeUpdate(sql1);
	System.out.println(rs1);
	rs=st.executeQuery(sql);
	
	while(rs.next()){
		System.out.println(rs.getInt(1)+" "+rs.getString("ename")+" "+rs.getInt(3));
	}
	
	con.rollback();
rs=st.executeQuery(sql);
	
	while(rs.next()){
		System.out.println("\n "+rs.getInt(1)+" "+rs.getString("ename")+" "+rs.getInt(3));
	}
	con.close();
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
	System.out.println(e);
}

	}

}
