package com.Transactions;

import com.BatchUpdates.*;
import java.sql.*;
import com.Util.JDBCUtil;

class AccountService {
	void fundsTransfer(int saccno, int daccno, double amt) {
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			con.setAutoCommit(false); // Transaction Begin

			String SQL1 = "select bal from myaccount1 where accno=?";
			String SQL2 = "update myaccount1 set bal=? where accno=? ";

			ps1 = con.prepareStatement(SQL1);
			ps2 = con.prepareStatement(SQL2);

			// Deposit
			ps1.setInt(1, daccno); // OP1 Select
			rs = ps1.executeQuery();
			if (rs.next()) {
				double bal = rs.getInt(1);
				bal = bal + amt;

				ps2.setDouble(1, bal);
				ps2.setDouble(2, daccno);
				ps2.executeUpdate(); // OP2 Update

			} else {
				throw new InvalidAccountNumberException();
			}

			// Withdraw
			ps1.setInt(1, saccno); // 101
			rs = ps1.executeQuery(); // OP3-Select

			if (rs.next()) {
				double bal = rs.getInt(1);
				if (bal >= amt) {
					bal = bal - amt;

					ps2.setDouble(1, bal);
					ps2.setDouble(2, saccno);
					ps2.executeUpdate(); // OP4-Update
				} else {
					throw new InsufficientFundsException();
				}
			} else {
				throw new InvalidAccountNumberException();
			}
			con.commit(); // End of Transaction
			System.out.println("----Done-----");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			con.rollback(); // End of Transaction
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.cleanup(rs, ps1, con);
		}
	}
}

public class Lab22 {
	public static void main(String[] args) {
		AccountService as = new AccountService();
		as.fundsTransfer(101, 102, 25000);
	}
}
