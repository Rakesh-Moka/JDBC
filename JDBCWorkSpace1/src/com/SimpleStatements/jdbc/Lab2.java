package com.SimpleStatements.jdbc;
import com.Util.JDBCUtil;
import java.sql.*;

public class Lab2 {
	public static void main(String as[]) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();

			String SQL = "select * from myaccounts";

			st = con.createStatement();

			 rs = st.executeQuery(SQL);

			while (rs.next()) {
				int cid = rs.getInt(1);
				String cname = rs.getString(2);
				String email = rs.getString(3);
				int phone = rs.getInt(4);
				String city = rs.getString(5);

				System.out.println(cid + "\t" + cname + "   \t" + email + "\t" + phone + "\t" + city);
			}
			System.out.println("\n \t---------Done-----------");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(rs, st, con);
		}
	}
}
