package com.pstatements;
import com.Util.JDBCUtil;
import java.sql.*;

public class Lab8 {
	public static void main(String as[]) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mycity = "Blore";
		try {

			con = JDBCUtil.getConnection();
			String SQL = "select * from myaccounts where city=?";
			ps = con.prepareStatement(SQL);
			ps.setString(1, mycity);
			rs = ps.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt(1);
				String cn = rs.getString(2);
				String em = rs.getString(3);
				int ph = rs.getInt(4);
				String city = rs.getString(5);
				System.out.println(cid + "\t" + cn + "\t" + em + "\t" + ph + "\t" + city);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(ps, con);
		}
	}
}
