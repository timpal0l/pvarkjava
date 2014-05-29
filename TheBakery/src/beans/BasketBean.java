package beans;

import java.util.ArrayList;

/* This is the Basket containing the whole order of all the customers products
 */
public class BasketBean {
	private ArrayList<ProductBean> basket = new ArrayList<ProductBean>();
	
	public void add(ProductBean p) {
		basket.add(p);
	}
	
	public void remove(int id) {
		for(ProductBean p : basket) {
			if(p.getId() == id) {
				basket.remove(p);
				break;
			}
		}
	}
	
	public ArrayList<ProductBean> getBasket() {
		return basket;
	}
}
