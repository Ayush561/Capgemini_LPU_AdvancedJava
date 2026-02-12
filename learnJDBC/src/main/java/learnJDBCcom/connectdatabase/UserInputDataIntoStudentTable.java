package learnJDBCcom.connectdatabase;

import java.nio.file.spi.FileSystemProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserInputDataIntoStudentTable {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/college";
        String user = "postgres";
        String pass = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect=DriverManager.getConnection(url,user,pass);
			
			String sql = "insert into student values(?,?,?)";
			
			PreparedStatement pstm = connect.prepareStatement(sql);
			
			System.out.println("Enter ID:");
			Scanner sc = new Scanner(System.in);
			int id=sc.nextInt();
			pstm.setInt(1, id);
			
			System.out.println("Enter name:");
			String name=sc.next();
			pstm.setString(2, name);
			
			System.out.println("Enter branch:");
			String branch=sc.next();
			pstm.setString(3, branch);
			
			pstm.execute();
			
			System.out.println("Data inserted successfully...");
			
			connect.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
