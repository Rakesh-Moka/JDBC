package com.Transactions;

import java.sql.*;

import com.Util.DataSourceUtil;

public class Lab28 {
	public static void main(String as[]) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataSourceUtil.getConnection();

			String SQL = "update myaccounts set city='Blore'";
			ps = con.prepareStatement(SQL);

			long x = ps.executeUpdate();
			System.out.println(x);

		System.out.println("----Done-----");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DataSourceUtil.cleanUp(ps, con);
		}
	}
}
