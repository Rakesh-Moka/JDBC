package com.CallableStatement;

import java.sql.*;

import com.Util.JDBCUtil;
public class Lab13 {
public static void main(String as[]) {
	
	Connection con=null;
	CallableStatement cs=null;
	int mysid=103;
	
		try { 
		con=JDBCUtil.getConnection(); 
		String SQL="{call findGrade(?)}"; 
		 
		cs=con.prepareCall(SQL); 
		cs.setInt(1, mysid); 
		 
		cs.execute(); 
		System.out.println("Done- Call Completed : "); 
		}catch(Exception ex) { 
		ex.printStackTrace(); 
		}finally { 
		JDBCUtil.cleanup(cs, con);
	}
	
}
}
