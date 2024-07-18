package com.BatchUpdates;

import java.sql.*;

public class Lab21 {
	public static void main(String as[]) {

		Connection con = null;

		try {
			con = JDBCUtil.getConnection();
			DatabaseMetaData dbmd = con.getMetaData();

			System.out.println(dbmd.getDatabaseProductName());// MySQL
			System.out.println(dbmd.getDatabaseProductVersion());// MySQL
			System.out.println(dbmd.getDatabaseMajorVersion());// 8
			System.out.println(dbmd.getDatabaseMinorVersion());// 1
			System.out.println(dbmd.getDefaultTransactionIsolation());// 2
			System.out.println(dbmd.getDriverName());// MySQL Connector/J
			System.out.println(dbmd.getJDBCMajorVersion());// 4
			System.out.println(dbmd.getJDBCMinorVersion());// 2

			System.out.println(dbmd.supportsBatchUpdates());// true
			System.out.println(dbmd.supportsFullOuterJoins());// false
			System.out.println(dbmd.supportsTransactions());// true
			System.out.println(dbmd.supportsGroupBy());// true
			System.out.println(dbmd.supportsMultipleTransactions());// true
			System.out.println(dbmd.supportsMultipleResultSets());// true

			System.out.println("\nDone... ");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(null, con);
		}
	}
}
