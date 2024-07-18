package com.Transactions;

import java.sql.*;

public class Lab27 {
	public static void main(String as[]) {

		String URL = "jdbc:mysql://localhost:3306/myjdbc?useSSL=false";
		String UN = "root";
		String PW = "Rakesh@123";
		String SQL = "select * from myaccounts ";

		try (Connection con = DriverManager.getConnection(URL, UN, PW);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL)) {
			
			while(rs.next()) {
				int cid=rs.getInt(1);
				String cname=rs.getString(2);
				String email=rs.getString(3);
				int phone=rs.getInt(4);
				String city=rs.getString(5);
				
				System.out.println(cid+"\t"+cname+"\t"+email+"\t"+phone+"\t"+city); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
