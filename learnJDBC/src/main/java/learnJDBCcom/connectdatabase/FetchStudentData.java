package learnJDBCcom.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStudentData {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			//To establish connection
			String url = "jdbc:postgresql://localhost:5432/college";
			String user="postgres";
			String pass="root";
			
			Connection connect=DriverManager.getConnection(url,user,pass);
			
			Statement stmt=connect.createStatement();
			
			String sql = "select * from student";
			
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
