package com.pstatements;
import com.Util.JDBCUtil;
import java.sql.*;

public class Lab10 {

	public static void main(String as[]) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL = "insert into mytest values(5,'Rohith','Rohith@gmail',203040,'Repalle')";
		String SQL1 = "update mytest set phone=7777 where phone=203040";
		String SQL2 = "select * from mytest";

		try {
			con = JDBCUtil.getConnection();

			ps = con.prepareStatement(SQL);
			ps = con.prepareStatement(SQL1);
			ps = con.prepareStatement(SQL2);

			boolean k = ps.execute(SQL2);

			if (k == false) {
				System.out.println("Submited - Updatable Op");
				int x = ps.getUpdateCount();
				System.out.println("Records Updated : " + x);
			} else {
				rs = ps.getResultSet();
				System.out.println("Submited - Select Op");
			}
			while (rs.next()) {
				int cid = rs.getInt(1);
				String cn = rs.getString(2);
				String em = rs.getString(3);
				int ph = rs.getInt(4);
				String ci = rs.getString(5);
				System.out.println(cid + "\t " + cn + "\t" + em + "\t" + ph + "\t" + ci);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(rs, ps, con);
		}
	}

}
