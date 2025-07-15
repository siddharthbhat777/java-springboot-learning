import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) throws SQLException {
        // Creating connection
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established!");

        // Values input from UI
        int sid = 6;
        String sname = "Madhusudan";
        int marks = 82;

        // Query
        String query = "insert into student values (?, ?, ?);";

        // Creating prepared statement
        PreparedStatement st = con.prepareStatement(query);

        // Mapping data
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);

        // Executing query
        st.execute();

        // Close connection
        con.close();
        System.out.println("Connection closed!");
    }
}
