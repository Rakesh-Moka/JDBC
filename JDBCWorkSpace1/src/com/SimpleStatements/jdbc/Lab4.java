package com.SimpleStatements.jdbc;

import com.Util.JDBCUtil;
import java.sql.*;

public class Lab4 {
	public static void main(String as[]) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
