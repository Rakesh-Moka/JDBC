package com.Transactions;

import java.sql.*;


import org.apache.commons.dbcp.BasicDataSource;
import com.Util.DataSourceUtil;

public class Lab24 {
	public static void main(String as[]) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			BasicDataSource myds = new BasicDataSource();

			// myds.setDriverClassName("com.mysql.jdbc.Driver");
			myds.setUrl("jdbc:mysql://localhost:3306/myjdbc?useSSL=false");
			myds.setUsername("root");
			myds.setPassword("Rakesh@123");
			myds.setInitialSize(10);
			myds.setMaxActive(100);

			con = myds.getConnection();
			String SQL = "select * from myaccounts";
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt(1);
				String cname = rs.getString(2);
				String email = rs.getString(3);
				int phone = rs.getInt(4);
				String city = rs.getString(5);
				System.out.println(cid + "\t" + cname + "\t" + email + "\t" + phone + "\t" + city);
			}
			System.out.println("Done!");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DataSourceUtil.cleanUp(rs, ps, con);
		}
	}
}