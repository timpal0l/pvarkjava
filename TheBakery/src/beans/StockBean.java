package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBConnector;

/* Shows all the products in our Bakery */

public class StockBean {
	private String parameter = "";
	private	List<ProductBean> stock = new ArrayList<ProductBean>();
	
	public StockBean(String parameter) {
		this.parameter = parameter;
	}
	
    public List<ProductBean> getStock() {
    	stock.clear();
        try {
        	DBConnector dbms = new DBConnector();
    		Connection conn = dbms.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT id, name, amount, description, price FROM product WHERE name LIKE ?");
            ps.setString(1, "%" + parameter + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	ProductBean pb = 
            			new ProductBean(
            					rs.getInt("id"),
            					rs.getString("name"),
            					rs.getString("description"),
            					rs.getInt("amount"),
            					rs.getDouble("price"));
            	stock.add(pb);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }
}
