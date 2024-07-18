package com.BatchUpdates;

import java.sql.*;

import com.Util.JDBCUtil;

public class Lab18A {
	public static void main(String as[]) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();

			String SQL = "select * from batchupdates";
			
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				String email = rs.getString(3);
				int phone = rs.getInt(4);
				String city = rs.getString(5);

				System.out.println(sid + "\t" + sname + "   \t" + email + "\t" + phone + "\t" + city);
			}
			System.out.println("Done !!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
