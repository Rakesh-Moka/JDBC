package com.BatchUpdates;
import java.sql.*;
import com.Util.JDBCUtil.*;

public class Lab19{
	public static void main(String as[]) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			String SQL = "select * from batchupdates";
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(SQL);

			System.out.println("RS Type : " + st.getResultSetType());
			System.out.println("RS Updatability : " + st.getResultSetConcurrency());
			System.out.println("RS Holdability : " + st.getResultSetHoldability());

			// Insert Record into ResultSet
			rs.moveToInsertRow();
			rs.updateInt(1, 509);
			rs.updateString(2, "hai");
			rs.updateString(3, "hai@jlc");
			rs.updateInt(4, 999);
			rs.updateString(5, "Blore");
			
			rs.insertRow();	// insert into Database
	
			// Update the Row 6
			rs.absolute(6);
			rs.updateString(2, "test");
			rs.updateString(3, "test@jlc");
			rs.updateInt(4, 666);

			rs.absolute(1);
			rs.deleteRow();

			System.out.println("---------Forward Order-------");
			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				String email = rs.getString(3);
				int phone = rs.getInt(4);
				String city = rs.getString(5);
				System.out.println(sid + "\t" + sname + "\t" + email + "\t" + phone + "\t" + city);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.cleanup(rs, st, con);
		}
	}
}
