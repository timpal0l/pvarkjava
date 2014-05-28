package beans;

import java.util.ArrayList;
import java.util.List;

public class ProductBean {
	List<String> ComponentList = new ArrayList<String>();
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
}
