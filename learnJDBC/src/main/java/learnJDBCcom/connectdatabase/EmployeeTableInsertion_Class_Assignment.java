package learnJDBCcom.connectdatabase;

import java.sql.*;

public class EmployeeTableInsertion_Class_Assignment {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/college";
        String user = "postgres";
        String pass = "root";

        try {
            Class.forName("org.postgresql.Driver");

            Connection connect = DriverManager.getConnection(url, user, pass);

            String sql1 = insertData(1001, "Himani", 40000);
            String sql2 = insertData(1002, "Lasun", 45000);
            String sql3 = insertData(1003, "Aditya", 50000);
            String sql4 = insertData(1004, "Abhi", 55000);

            Statement stmt = connect.createStatement();

            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);

            String sql5 = updateData(1003, "Akash", 46510);
            stmt.execute(sql5);

            String sql6 = deleteData(1003);
            stmt.execute(sql6);

            System.out.println("Data inserted/updated/deleted successfully...");

            stmt.close();
            connect.close();

            System.out.println("Connection closed...");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static String insertData(int eid, String ename, int sal) {
        return "insert into employee values (" + eid + ",'" +ename + "'," + sal + ")";
    }

    public static String updateData(int eid, String ename, int sal) {
        return "update employee set ename = '" + ename + "', sal = " + sal + " where eid = " + eid;
    }

    public static String deleteData(int eid) {
        return "delete from employee where eid = " + eid;
    }
}
