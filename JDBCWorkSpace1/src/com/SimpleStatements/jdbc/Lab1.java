package com.SimpleStatements.jdbc;
import com.Util.JDBCUtil;
import java.sql.*;

public class Lab1 {
	public static void main(String as[]) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = JDBCUtil.getConnection();
			String SQL = "insert into myaccounts values(9,' Hai','hello98@gmail',984984,'Blore') ";
			Statement st1 = con.createStatement();
			int x = st1.executeUpdate(SQL);
			if (x == 1) {
				System.out.println("Customer Record is inserted Succesfully");
			} else {
				System.out.println("Customer Record is not Inserted");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(st, con);
		}

	}
}
