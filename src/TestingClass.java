import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestingClass {
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
			sql = "SELECT * FROM testing";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("*********************");

			while (rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String chitinfo = rs.getString(3);
//				String result = rs.getString(4);

				System.out.println(id);
				System.out.println(name);
				System.out.println(chitinfo);
//				System.out.println(result);
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