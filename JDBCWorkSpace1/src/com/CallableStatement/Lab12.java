package com.CallableStatement;
import java.sql.*;

import com.Util.JDBCUtil;

public class Lab12 {
	public static void main(String as[]) {

		Connection con = null;
		CallableStatement cs = null;

		int mysid = 102;
		try {
			con = JDBCUtil.getConnection();
			String SQL = "{call findMyGrade(?,?,?,?,?)}";
			cs = con.prepareCall(SQL);
			cs.setInt(1, mysid);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.DOUBLE);
			cs.registerOutParameter(4, Types.CHAR);
			cs.registerOutParameter(5, Types.CHAR);
			
			cs.execute();
			int total=cs.getInt(2);
			double avg=cs.getDouble(3);
			String status=cs.getString(4);
			String grade=cs.getString(5);
			System.out.println("Total :"+total);
			System.out.println("Average :"+avg);
			System.out.println("Status :"+status);
			System.out.println("grade :"+grade);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(cs, con);
		}
	}
}
