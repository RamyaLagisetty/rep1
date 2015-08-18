package jdbc_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class jdbc2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			Statement sta=conn.createStatement();
			String st="select * from school";
			ResultSet rs=sta.executeQuery(st);
			
			while(rs.next()){
				System.out.println(" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getString(4));
			}
			
			String r;
			System.out.println("do you want to delete ..press yes/no..");
			Scanner in=new Scanner(System.in);
			r=in.next();
			if(r.compareTo("yes")==0){
				st="delete from school where grade='C'";
				//System.out.println(" u r in");
				if(!sta.execute(st)){
					System.out.println("successfully deleted");
				}
				else
					System.out.println(" no deletion");
			}
			st="select * from school";
			rs=sta.executeQuery(st);
		
			while(rs.next()){
				SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
				System.out.println(" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getString(4));
			}
			
			
			System.out.println("do you want to insert ..press yes/no..");
		
			r=in.next();
			if(r.compareTo("yes")==0){
				st="insert into school values(3,'mona','20-JAN-11','C')";
				//System.out.println(" u r in");
				if(!sta.execute(st)){
					System.out.println("successfully inserted");
				}
				else
					System.out.println(" no insertion");
			}
			
			st="select * from school";
			rs=sta.executeQuery(st);
		
			while(rs.next()){
				SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
				System.out.println(" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getString(4));
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
