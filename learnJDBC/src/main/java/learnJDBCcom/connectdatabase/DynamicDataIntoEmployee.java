package learnJDBCcom.connectdatabase;

import java.util.Scanner;
import java.sql.*;

public class DynamicDataIntoEmployee {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/college";
        String user = "postgres";
        String pass = "root";
		
        Scanner sc= new Scanner(System.in);
        
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect=DriverManager.getConnection(url,user,pass);
			
			DynamicDataIntoEmployee.addEmployee(connect);
			
			DynamicDataIntoEmployee.deleteEmpById(connect);
			
			DynamicDataIntoEmployee.updateEmpSalById(connect);
			
			DynamicDataIntoEmployee.findEmpById(connect);
			
			connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addEmployee(Connection connect) {
		String url = "jdbc:postgresql://localhost:5432/college";
        String user = "postgres";
        String pass = "root";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID: ");
		int id = sc.nextInt();
		
		System.out.println("Enter name: ");
		String name=sc.next();
		
		System.out.println("Enter sal: ");
		int sal=sc.nextInt();
		
		String sql = "insert into employee values(?,?,?)";
		try {
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, sal);
			
			pstm.execute();
			
			System.out.println("Row inserted successfully...");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public static void deleteEmpById(Connection connect) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID to delete: ");
		int id = sc.nextInt();
		String sql = "delete from employee where eid=?";
		try {
			PreparedStatement pstm = connect.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			
			System.out.println("Row deleted successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateEmpSalById(Connection connect) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the eid you want to update sal for: ");
		int eid=sc.nextInt();
		System.out.println("Enter the sal you want to update");
		int newsal = sc.nextInt();
		
		String sql = "update employee set sal="+newsal+" where eid=?";
		
		PreparedStatement pstm = connect.prepareStatement(sql);
		pstm.setInt(1, eid);
		pstm.execute();
		
		System.out.println("Row updated successfully...");
		
	}
	
	public static void findEmpById(Connection connect) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID you want to search for: ");
		int id = sc.nextInt();
		
		String sql = "select * from employee where eid=?";
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		pstm.setInt(1, id);
		
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		
		
		
		
	}

}
