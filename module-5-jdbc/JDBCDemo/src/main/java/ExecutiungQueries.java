import java.sql.*;

public class ExecutiungQueries {
    public static void main(String[] args) throws SQLException {
        // Creating connection
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established!");

        // Creating statement
        Statement st = con.createStatement();

        // Query 1: Display full data
        String query1 = "select * from student;";
        ResultSet rs1 = st.executeQuery(query1); // Only use executeQuery to get data
        while (rs1.next()) { // this will return boolean value but will also go to next row
            System.out.print(rs1.getInt(1) + " - "); // column index start from 1
            System.out.print(rs1.getString(2) + " - ");
            System.out.print(rs1.getInt(3));
            System.out.println();
        }

        // Query 2: Insert data
        String query2 = "insert into student values (6, 'Madhusudan', 82);";
        boolean insertStatus = st.execute(query2); // Use execute() as you are not getting data
        System.out.println(insertStatus);
        // Note: execute() returns true if you use ResultSet i.e. display queries else returns false for insert, update and delete

        // Query 3: Update data
        String query3 = "update student set sname='Madhu' where sid=6";
        st.execute(query3);

        // Query 4: Delete data
        String query4 = "delete from student where sid=6";
        st.execute(query4);

        // Close connection
        con.close();
        System.out.println("Connection closed!");
    }
}