package com.Transactions;

import java.sql.SQLException;

import javax.sql.RowSet;
import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;

public class Lab23 {
	public static void main(String as[]) {

		RowSet myrowset = null;
		try {

			String SQL = "select * from myaccounts where city='Blore' ";

			myrowset = new CachedRowSetImpl();
			myrowset = new JdbcRowSetImpl();
			myrowset.setUrl("jdbc:mysql://localhost:3306/myjdbc?useSSL=false");
			myrowset.setUsername("root");
			myrowset.setPassword("Rakesh@123");
			myrowset.setCommand(SQL);

			myrowset.execute();// ***

			while (myrowset.next()) {
				int cid = myrowset.getInt(1);
				String cname = myrowset.getString(2);
				String email = myrowset.getString(3);
				int phone = myrowset.getInt(4);
				String city = myrowset.getString(5);
				System.out.println(cid + "\t" + cname + "\t" + email + "\t" + phone+"\t"+city);
			}
			System.out.println("Done!!!");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				myrowset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
