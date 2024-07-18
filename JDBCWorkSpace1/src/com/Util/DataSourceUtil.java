package com.Util;

import java.sql.*;
import org.apache.commons.dbcp.BasicDataSource;

public class DataSourceUtil {
	public static void cleanUp(Statement st, Connection con) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cleanUp(ResultSet rs, Statement st, Connection con) {

		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {

		Connection con = null;
		try {
			BasicDataSource bds = new BasicDataSource();
			// myds.setDriverClassName("com.mysql.jdbc.Driver");
			bds.setUrl("jdbc:mysql://localhost:3306/myjdbc?useSSL=false");
			bds.setUsername("root");
			bds.setPassword("Rakesh@123");

			bds.setInitialSize(10);
			bds.setMaxActive(100);

			con = bds.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
}