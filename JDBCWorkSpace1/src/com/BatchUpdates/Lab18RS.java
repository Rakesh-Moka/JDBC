package com.BatchUpdates;

import com.Util.JDBCUtil;
import java.sql.*;

public class Lab18RS {
	public static void displayRow(ResultSet rs) throws SQLException {
		int sid = rs.getInt(1);
		String sname = rs.getString(2);
		String email = rs.getString(3);
		int phone = rs.getInt(4);
		String city = rs.getString(5);

		System.out.println(sid + "\t" + sname + "\t" + email + "\t" + phone + "\t" + city);
	}

	public static void main(String as[]) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			String SQL = "select * from batchupdates";
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(SQL);

			System.out.println("RS Type :" + st.getResultSetType());
			System.out.println("RS Updatability :" + st.getResultSetConcurrency());
			System.out.println("RS Holdability: " + st.getResultSetHoldability());

			System.out.println("\n\t	----Forward Order----\n");
			while (rs.next()) {
				displayRow(rs);
			}
			System.out.println("\n\t	----Reverse Order----\n");
			while (rs.previous()) {
				displayRow(rs);
			}

			System.out.println(rs.isBeforeFirst());
			System.out.println(rs.isLast());
			rs.first();
			System.out.println(rs.isBeforeFirst());
			System.out.println(rs.isLast());

			System.out.println("\n \t	----1st Record----\n");
			displayRow(rs);

			System.out.println(rs.isAfterLast());
			System.out.println(rs.isLast());
			rs.last();
			System.out.println(rs.isAfterLast());
			System.out.println(rs.isLast());

			System.out.println("\n\t	----Last Record----\n");
			System.out.println("Last Adress");
			displayRow(rs);
			
			rs.absolute(8);
			System.out.println("\n5th Record"); 
			displayRow(rs);
			
			rs.relative(1);
			System.out.println("\n7th Record");
			displayRow(rs);
			
			rs.relative(-8); 
			System.out.println("\n4th Record"); 
			displayRow(rs); 
			
			System.out.println("\n----Done-----"); 
			System.out.println("\n\n\n");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(rs, st, con);
		}
	}
}
