package com.SimpleStatements.jdbc;
import com.Util.JDBCUtil;
import java.sql.*;

public class Lab7 {
	public static void main(String as[]) {

		Connection con = null;
		PreparedStatement ps = null;

		int mycid = 2;
		String mycname = "Nani";
		String myemail = "Nani@jlc";
		int myphone = 9696;
		String mycity = "Adv";

		try {

			con = JDBCUtil.getConnection();
			String SQL = "insert into mytest values(?,?,?,?,?)";

		ps=con.prepareStatement(SQL);
			ps.setInt(1, mycid);
			ps.setString(2, mycname);
			ps.setString(3, myemail);
			ps.setInt(4, myphone);
			ps.setString(5, mycity);
			int x=ps.executeUpdate();

			if (x == 1) {
				System.out.println("Customer Record is Inserted to mytest Succesfully");
			} else {
				System.out.println("Sorry, Customer Record is Not Inserted in mytest");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(ps, con);
		}

	}
}
