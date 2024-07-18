package com.BatchUpdates;
import java.sql.*;
import com.Util.JDBCUtil.*;

public class Lab20 {
	public static void main(String as[]) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			String SQL = "select * from batchupdates";
			st = con.createStatement();
			rs = st.executeQuery(SQL);

			ResultSetMetaData rsmd = rs.getMetaData();
			int ColumnCount = rsmd.getColumnCount();

			rs.first();
			for (int i = 1; i < ColumnCount; i++) {
				String colName = rsmd.getColumnName(i);
				System.out.println(colName);
				String colLabel = rsmd.getColumnLabel(i);
				System.out.println(colLabel);
				String colType = rsmd.getColumnTypeName(i);
				System.out.println(colType);
				String colClsName = rsmd.getColumnClassName(i);
				System.out.println(colClsName);
				String tablename = rsmd.getTableName(i);
				System.out.println(tablename);
				String catlogname = rsmd.getCatalogName(i);
				System.out.println(catlogname);
			}
			System.out.println("----Done!----");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(rs, st, con);
		}
	}
}
