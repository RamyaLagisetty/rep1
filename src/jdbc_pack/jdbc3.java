package jdbc_pack;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class jdbc3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		Statement sta=conn.createStatement();
		String st="select * from school";
		ResultSet rs=sta.executeQuery(st);
		
		while(rs.next()){
			System.out.println(" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getString(4));
		}
		
		
		System.out.println("do you want to insert data??");
		Scanner in=new Scanner(System.in);
		st=in.next();
		while(st.compareTo("yes")==0){
		PreparedStatement stmt=conn.prepareStatement("insert into school values(?,?,?,?)");
		stmt.setInt(1, 10);
		stmt.setString(2, "raghu");
		Date d=new Date(30-03-14);
		stmt.setDate(3,d);
		stmt.setString(4,"C");
		int i=stmt.executeUpdate();
		System.out.println(i+"records inserted");
		System.out.println("do you want to re enter???");
		st=in.next();
		}
		conn.close();
	}

}
