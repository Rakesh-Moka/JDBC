package com.BatchUpdates;

import java.sql.*;

import com.Util.JDBCUtil;

public class Lab16 {
	public static void main(String as[]) {
		Connection con = null;
		PreparedStatement ps = null;
		Object mycustomers[][] = {  //Must be change insert data after once inserted to DB
				{ 505, "dd", "dd@jlc", 444, "Hyd" }, 
				{ 506, "ee", "ee@jlc", 507, "Hyd" },
				{ 508, "ff", "ff@jlc", 666, "Blore" },
				};

		try {
			con = JDBCUtil.getConnection();
			String SQL = "insert into batchupdates values(?,?,?,?,?)";
			ps = con.prepareStatement(SQL);

			for (Object[] mycust : mycustomers) {
				ps.setInt(1, (int) mycust[0]);
				ps.setString(2, (String) mycust[1]);
				ps.setString(3, (String) mycust[2]);
				ps.setInt(4, (int) mycust[3]);
				ps.setString(5, (String) mycust[4]);

				ps.addBatch();
			}
			int[] results = ps.executeBatch();
			for (int i : results)
				System.out.println(i+"kl");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(ps, con);
		}
	}
}
