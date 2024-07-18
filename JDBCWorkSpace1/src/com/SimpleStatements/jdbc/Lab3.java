package com.SimpleStatements.jdbc;
import com.Util.JDBCUtil;
import java.sql.*;

public class Lab3 {
	public static void main(String as[]) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			// Step 3: Prepare SQL Statement
			String SQL = "select * from myaccounts ";

			// Step 4: Create the JDBC Statement
			st = con.createStatement();

			// Step 5: Submit SQL to DB
			rs = st.executeQuery(SQL);

			// Step 6: Process Results

			while (rs.next()) {
				int cid = rs.getInt(1);
				String cname = rs.getString(2);
				String email = rs.getString(3);
				int phone = rs.getInt(4);
				String city = rs.getString(5);

				System.out.println(cid + "\t" + cname + "\t" + email + "\t" + phone + "\t" + city);
				}

			System.out.println("\t ----Accesed Succesfully-----");
		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(rs, st, con);
		}
	}
}
