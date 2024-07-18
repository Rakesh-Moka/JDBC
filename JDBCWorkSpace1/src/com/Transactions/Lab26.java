package com.Transactions;

import java.sql.*;
import java.text.SimpleDateFormat;

import com.Util.DataSourceUtil;

public class Lab26 {
	public static void main(String as[]) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataSourceUtil.getConnection();
			String SQL = ("select * from mystudents");
			ps = con.prepareStatement(SQL);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				Date dob = rs.getDate(3);

				SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
				String mydob = sdf.format(dob);
				System.out.println(sid+"\t"+sname+"\t"+dob);
			}

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.cleanUp(ps, con);
		}
	}
}
