package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBConnector;

public class ProductBean {
	List<String> componentList = new ArrayList<String>();
	int id, amount;
	String name, description;
	double price;

	public ProductBean(int id, String name, String description, int amount, double price) {
		setId(id);
		setName(name);
		setDescription(description);
		setAmount(amount);
		setPrice(price);
	}
	
	public ProductBean(int parameter) {
        try {
        	DBConnector dbms = new DBConnector();
    		Connection conn = dbms.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT id, name, amount, description, price FROM product WHERE id = ?");
            ps.setInt(1, parameter);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	setId(rs.getInt("id"));
            	setName(rs.getString("name"));
            	setDescription(rs.getString("description"));
            	setAmount(rs.getInt("amount"));
            	setPrice(rs.getDouble("price"));
                ps = conn.prepareStatement("SELECT name FROM component INNER JOIN product_component ON component_id = id WHERE product_id = ?");
                ps.setInt(1, getId());
                ResultSet rs2 = ps.executeQuery();
                while(rs2.next()) {
                	componentList.add(rs2.getString("name"));
            	}
                rs2.close();
            }
            rs.close();
            ps.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public List<String> getComponentList() {
		return componentList;
	}

	public void setComponentList(List<String> componentList) {
		componentList = componentList;
	}
}
