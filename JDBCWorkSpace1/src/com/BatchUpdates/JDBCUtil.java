package com.BatchUpdates;

import java.sql.*;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc?useSSL=false", "root", "Rakesh@123");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

	public static void cleanup(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();

			if (st != null)
				st.close();

			if (con != null)
				con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void cleanup(Statement st, Connection con) {

		try {
			if (st != null)
				st.close();

			if (con != null)
				con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
