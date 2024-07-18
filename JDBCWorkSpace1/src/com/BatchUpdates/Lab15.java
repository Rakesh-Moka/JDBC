package com.BatchUpdates;

import java.sql.*;

import com.Util.JDBCUtil;

public class Lab15 {

	public static void main(String as[]) {
		Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConnection();

			String SQL1 = "insert into batchupdates values(504,'Hey','Hey@jlc',222,'Bangaluru')";

			st = con.createStatement();

			st.addBatch(SQL1);

			int results[] = st.executeBatch();

			for (int i : results)
				System.out.println(i);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(st, con);
		}
	}
}
