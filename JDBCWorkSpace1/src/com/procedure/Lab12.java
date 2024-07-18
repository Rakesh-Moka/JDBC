package com.procedure;
import java.sql.*;

import com.Util.JDBCUtil;

import javafx.animation.KeyValue.Type;

public class Lab12 {
	public static void main(String as[]) {

		Connection con = null;
		CallableStatement cs = null;
		int mysid = 102;
		try {
			con = JDBCUtil.getConnection();
			String SQL = "{call findBalance(?,?)}";

			cs = con.prepareCall(SQL);
			cs.setInt(1, mysid);
			cs.registerOutParameter(2, Types.DOUBLE);
			cs.execute();

			double bal = cs.getDouble(2);
			System.out.println("Balance :" + bal);

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			JDBCUtil.cleanup(cs, con);
		}
	}
}
