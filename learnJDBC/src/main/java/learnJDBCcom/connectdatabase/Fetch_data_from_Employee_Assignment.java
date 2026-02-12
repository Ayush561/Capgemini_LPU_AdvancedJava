package learnJDBCcom.connectdatabase;

import java.sql.*;
public class Fetch_data_from_Employee_Assignment {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/college";
        String user = "postgres";
        String pass = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect=DriverManager.getConnection(url, user, pass);
			
			Statement stmt = connect.createStatement();
			
			String sql = "select * from employee";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
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
