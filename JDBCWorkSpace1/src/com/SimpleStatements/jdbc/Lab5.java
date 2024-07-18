package com.SimpleStatements.jdbc;
import com.Util.JDBCUtil;
import java.sql.*;

//insert into table
public class Lab5 {
	public static void main(String as[]) {
		Connection con = null;
		Statement st = null;

		int mycid = 109;
		String mycname = "Hello";
		String myemail = "Hello@jlc";
		int myphone = 222;
		String mycity = "Blore";

		try {
			con = JDBCUtil.getConnection();
			String SQL = String.format("insert into myaccounts values(%d,'%s','%s',%d,'%s')", mycid, mycname, myemail,myphone, mycity);
			System.out.println(SQL);

			st = con.createStatement();
			int x = st.executeUpdate(SQL);
			if (x == 1) {
				System.out.println(" Account Details Inserted Succesfully");
			} else {
				System.out.println(" Sorry Account Details Not Inserted");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(st, con);
		}

	}
}
