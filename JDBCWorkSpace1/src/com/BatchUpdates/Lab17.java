package com.BatchUpdates;
import com.Util.JDBCUtil;
import java.sql.*;

import com.Util.JDBCUtil;

public class Lab17 {
	public static void main(String as[]) {
		Connection con = null;
		PreparedStatement ps = null;
		Object mycustomers[][] = { // Must be change insert data after once inserted to DB
				{ 509, "dd", "dd@jlc", 444, "Hyd" }, { 510, "ee", "ee@jlc", 555, "Hyd" },
				{ 512, "ff", "ff@jlc", 666, "Blore" }, };
		try {
			con = JDBCUtil.getConnection();
			String SQL="insert into batchupdates values(?,?,?,?,?)";
			ps = con.prepareStatement(SQL);

			for (Object[] mycust : mycustomers) {
				int paramNum = 1;
				for (Object obj : mycust) {
					ps.setObject(paramNum, obj);
				}
				ps.addBatch();
			}
			int results[] = ps.executeBatch();
			for (int i : results) {
				System.out.println(i);
				}
			System.out.println("Done!!");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(ps, con);
		}
	}
}
