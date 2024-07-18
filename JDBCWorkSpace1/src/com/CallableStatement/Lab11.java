package com.CallableStatement;
import java.sql.*;

import com.Util.JDBCUtil;

public class Lab11 {
	public static void main(String as[]) {

		Connection con = null;
		CallableStatement cs = null;

		try {
			con = JDBCUtil.getConnection();
			String SQL = "{call p1(?,?,?,?)}";

			cs = con.prepareCall(SQL);
			cs.setInt(1, 10);
			cs.setInt(2, 20);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.INTEGER);

			cs.execute();
			int sum = cs.getInt(3);
			int mul = cs.getInt(4);
			System.out.println("Sum :" + sum);
			System.out.println("Mul :" + mul);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(cs, con);
		}
	}
}
