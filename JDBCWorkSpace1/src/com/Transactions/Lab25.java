package com.Transactions;

import java.sql.*;
import com.Util.DataSourceUtil;

public class Lab25 {
	public static void main(String as[]) {

		Connection con = null;
		PreparedStatement ps = null;
		int dd = 27;
		int mm = 12;
		int yy = 2000;
		Date dob = new Date(yy-1900, mm - 1,dd); // 1

		try {
			con = DataSourceUtil.getConnection();
			String SQL = ("insert into mystudents values(?,?,?)");
			ps = con.prepareStatement(SQL);
			ps.setInt(1, 3);
			ps.setString(2, "Mohan");
			ps.setDate(3, dob); // 2

			int x = ps.executeUpdate();
			System.out.println(x);

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.cleanUp(ps, con);
		}
	}
}
