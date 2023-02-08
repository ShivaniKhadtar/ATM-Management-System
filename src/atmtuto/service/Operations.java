package atmtuto.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

import atmtuto.dbconnect.DbConnect;

public class Operations {

	DbConnect db = new DbConnect();

	private Connection con = db.createCon();
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public Boolean loginUser(String accNum, String password) {
		String query = "select * from acctbl where AccNum='" + accNum + "' and PIN='" + password + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isUserPresent(String accNum) {

		String query = "select * from acctbl where AccNum=" + accNum;

		try {
			st = con.prepareStatement(query);
			rs=st.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public String registerUser(String accNum, String firstName, String lastName, String dob, String phoneNo,
			String address, String education, String occupation, String PIN) {
		try {
			PreparedStatement add = con.prepareStatement("insert into acctbl values(?,?,?,?,?,?,?,?,?,?)");
			add.setString(1, accNum);
			add.setString(2, firstName);
			add.setString(3, lastName);
			add.setString(4, dob);
			add.setString(5, phoneNo);
			add.setString(6, address);
			add.setString(7, education);
			add.setString(8, occupation);
			add.setInt(9, 0);
			add.setString(10, PIN);
			add.executeUpdate();
			return "Registered successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "something went wrong";
		}
	}

	public String depositeCash(String accNum, int amount) {
		String query = "update acctbl set Balance = ? where accNum = ?";
		try {
			int balance = getBalance(accNum) + amount;
			pst = con.prepareStatement(query);
			pst.setInt(1, balance);
			pst.setString(2, accNum);
			if (pst.executeUpdate() == 1) {
				addTransaction(accNum, "Deposite", amount);
				return "Amount Deposited Successfully";
			} else {
				return "Missing Information";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String withDrawCash(String accNum, int amount) {
		if (getBalance(accNum) < amount) {
			return "no enough balance";
		} else {
			String query = "update acctbl set Balance = ? where accNum = ?";
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, getBalance(accNum) - amount);
				pst.setString(2, accNum);
				if (pst.executeUpdate() == 1) {
					addTransaction(accNum, "Withdraw", amount);
					return "Balance Updated Successfully";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "Something is wrong";
	}

	public int getBalance(String accNum) {
		int balance = 0;
		String query = "select * from acctbl where AccNum='" + accNum + "'";
		try {
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			if (rs.next()) {
				balance = rs.getInt(9);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}

	public int getTid(String accNum) {
		int lastTid, newTid;
		String query = "SELECT Tid FROM `transtbl` where AccNum='" + accNum + "' ORDER by Tid desc limit 1";
		try {
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			if (rs.next()) {
				lastTid = rs.getInt(1);
				newTid = lastTid + 1;
				return newTid;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public void addTransaction(String accNum, String type, int amt) {
		try {
			PreparedStatement add = con.prepareStatement("insert into transtbl values(?,?,?,?,?)");
			add.setInt(1, getTid(accNum));
			add.setString(2, accNum);
			add.setString(3, type);
			add.setInt(4, amt);
			add.setString(5, getDate());
			add.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayTr(JTable table, String accNum) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("select Tid,Type,Amount,TDate from transtbl where accNum='" + accNum + "'");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getDate() {
		String myDate;
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-YYYY");
		myDate = s.format(d);
		return myDate;
	}

	public String changePin(String PIN, String accNum) {
		String query = "update acctbl set PIN = ? where accNum = ?";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, PIN);
			pst.setString(2, accNum);
			if (pst.executeUpdate() == 1) {
				return "PIN changed successfully";
			} else {
				return "Missing Information";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "something went wrong";
		}
	}

	public void closeResources() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
			System.exit(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
