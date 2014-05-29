package beans;

import java.util.ArrayList;
import java.util.List;

public class ComponentBean {
	
	int id, amount;
	String name;

	List<String> ProductList = new ArrayList<String>();
	
	public ComponentBean(int id, int amount, String name) {
		setId(id);
		setAmount(amount);
		setName(name);
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

}
