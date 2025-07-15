import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        7 steps of JDBC:

        1. Import package
        2. Load driver
        3. Register driver
        4. Create connection
        5. Create statement
        6. Execute statement (also process the results)
        7. Close
        */

        // Load and register driver - OPTIONAL
        Class.forName("org.postgresql.Driver"); // can comment this

        // Creating connection
        String url = "jdbc:postgresql://localhost:5432/demo"; // not copied from anywhere
        String username = "postgres";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established!");

        // Creating statement
        String query = "select sname from student where sid = 1;";
        Statement st = con.createStatement();

        // Execute and process statement
        ResultSet rs = st.executeQuery(query); // Only use executeQuery to get data
        System.out.println(rs.next()); // returns 'true' if we get the data
        String name = rs.getString("sname"); // rs.next() execution is necessary before performing this
        System.out.println("Name of a student is " + name);

        // Close connection
        con.close();
        System.out.println("Connection closed!");
    }
}
