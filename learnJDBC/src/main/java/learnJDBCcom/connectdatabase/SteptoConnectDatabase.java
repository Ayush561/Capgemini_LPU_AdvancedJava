package learnJDBCcom.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SteptoConnectDatabase {
	public static void main(String[] args) {
		//Load the Driver class
		try {
			//optional 'Class.forName("org.postgresql.Driver");' after JDBC version 4.
			Class.forName("org.postgresql.Driver");
			System.out.println("Class Loaded");
			
			//To establish connection
			String url = "jdbc:postgresql://localhost:5432/college";
			String user="postgres";
			String pass="root";
			//getconnection has a return type of connection so we will store it in Connection type of variable
			Connection connect=DriverManager.getConnection(url,user,pass);
			
			System.out.println("Connection created");
			
			String sql = "insert into student values (1,'Miller','CSE')";
			String sql2 = "insert into student values (2,'Miller','CSE')";
			
			String sql3 = "update student set name='John' , branch='MEC' where id=2";
			
			String sql4 = "insert into student values (3,'Emma','CIV')";
			String sql5 = "insert into student values (4,'Modi','CSE')";
			
			String sql6 = "delete from student where id=4";
			
			//Create Statement
			Statement stmt=connect.createStatement();
			
			//If getting exception, means either table is not present or table name is not correct.
			//stmt.execute(sql);
			//stmt.execute(sql2);
			//stmt.execute(sql3);
			//stmt.execute(sql4);
			//stmt.execute(sql5);
			stmt.execute(sql6);
			
			connect.close();
			
			System.out.println("Data Inserted");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	} 

}
