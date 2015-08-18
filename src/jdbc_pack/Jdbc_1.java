package jdbc_pack;

import java.sql.*;
import java.util.Calendar;

public class Jdbc_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	Statement sta=conn.createStatement();
	String st="create table school(id number(4),name varchar2(20),doj date,grade char)";
	
	if(!sta.execute(st))
		System.out.println("table created");//on execution completion it will return 0for int/false for boolean..
	else
	System.out.println("table not created");
	//String st1="desc school";//this will not work here..
	//ResultSet rst=sta.executeQuery(st1);	
	
	st="insert into school values(1,'ramya','5-AUG-96','A')";
	conn.commit();
	if(!sta.execute(st)){
		System.out.println("inserted values");
	}
	
	st="select * from school";
	ResultSet rs=sta.executeQuery(st);
	
	while(rs.next()){
		System.out.println(" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getString(4));
	}
	conn.close();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
