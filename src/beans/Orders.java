package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 * 
 * @author noahv
 *
 */
@ManagedBean 
@ViewScoped
public class Orders {
	/**
	 * create a list to store the different orders, to be displayed in data grid
	 */
	List<Order> orders = new ArrayList<Order>();
	
	/**
	 * constructor
	 * add new orders in the constructor to be added to the list
	 */
	public Orders() {
		
	}


	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
