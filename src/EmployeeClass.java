import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeClass {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/amit";

	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connection...");
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = ((java.sql.Connection) conn).createStatement();
			String sql;
			// sql =
			// "SELECT * FROM Employee Emp1 WHERE (2) = (SELECT COUNT((Emp2.Salary)) FROM Employee Emp2 WHERE Emp2.Salary > Emp1.Salary)";
			sql = "SELECT * FROM testing a JOIN employee b";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("*********************");

			while (rs.next()) {
				String salary = rs.getString("salary");
				System.out.println(salary);
				System.out.println("*********************");

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			System.out.println("Message error: " + se.getLocalizedMessage());
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println("Message error: " + e.getLocalizedMessage());
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("Exception: " + se.getLocalizedMessage());
			}
		}
	}
}