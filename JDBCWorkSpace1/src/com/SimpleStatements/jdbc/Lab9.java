package com.SimpleStatements.jdbc;
import com.Util.JDBCUtil;
import java.sql.*;

public class Lab9 {
	public static void main(String as[]) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String SQL = "insert into mytest values(4,'mmk','mkm@gmail',234524,'Tenali')";
		String SQL1 = "update mytest set phone=6969 where phone=234524";
		String SQL2 = "select * from mytest";

		try {
			con = JDBCUtil.getConnection();
			st = con.createStatement();

			boolean k = st.execute(SQL);
			boolean c = st.execute(SQL1);
			boolean d = st.execute(SQL2);

			if (d == false) {
				System.out.println("Submited - Updatable Op");
				int x = st.getUpdateCount();
				System.out.println("Records Updated : " + x);
			} else {
				rs = st.getResultSet();
				System.out.println("Submited - Select Op");
			}
			while (rs.next()) {
				int cid = rs.getInt(1);
				String cn = rs.getString(2);
				String em = rs.getString(3);
				int ph = rs.getInt(4);
				String ci = rs.getString(5);
				System.out.println(cid + "\t" + cn + "\t" + em + "\t" + ph + "\t" + ci);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(rs, st, con);
		}
	}

}
