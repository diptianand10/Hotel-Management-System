package hotel.management.system;

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	
	Conn(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "diptianand@0501");
			s = c.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
