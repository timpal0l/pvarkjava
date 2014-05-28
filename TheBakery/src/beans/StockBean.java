package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnector;

/* Shows all the products in our Bakery */

public class StockBean {
	private	String username = "test";
	
    public String getUsername() {
        try {
        	DBConnector dbms = new DBConnector();
    		Connection conn = dbms.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT username FROM user");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	username = rs.getString("username");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println(username);
        return username;
    }
}
