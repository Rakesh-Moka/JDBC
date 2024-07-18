package com.SimpleStatements.jdbc;
import com.Util.JDBCUtil;
import java.sql.*;

public class Lab6 {
	public static void main(String as[]) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String mycity = "Rakesh Moka";

		try {
			con = JDBCUtil.getConnection();
			String SQL = String.format("select * from myaccounts where cname='%s' ", mycity);
			System.out.println(SQL);
			st = con.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				int cid = rs.getInt(1);
				String cn = rs.getString(2);
				String em = rs.getString(3);
				int ph = rs.getInt(4);
				String city = rs.getString(5);
				System.out.println(cid + "\t" + cn + "\t" + em + "\t" + ph + "\t" + city);
			}
			System.out.println("Done!!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
