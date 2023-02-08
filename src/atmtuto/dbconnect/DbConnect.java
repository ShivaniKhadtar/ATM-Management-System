package atmtuto.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

	private Connection con = null;

	public Connection createCon() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb?user=root&password=Shiv@1104");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
