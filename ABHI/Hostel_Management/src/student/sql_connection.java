package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class sql_connection {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public  ResultSet display_sql(String query) {
	        ResultSet rs = null;
	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abhijith", "abhijith");
	            Statement stmt = con.createStatement();
	            rs = stmt.executeQuery(query);
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();}
			return rs;
	        }
	        

	public void Connect_sql() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "abhijith", "abhijith");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
