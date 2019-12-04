package beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author noahv
 *
 */
@XmlRootElement(name="Order")
public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String orderNo; // give an item an order number so the orders do not get duplicated
	private String ProductName; // keep track of the different names of products so they do not conflict 
	private float price; // keep track of the value of specific products
	private int quantity; // keep track of the number of items in stock, so a user does not order something that is not in stock
	
	public Order() {
		
	}
	
	/**
	 * constructor 
	 * @param orderNo
	 * @param productName
	 * @param price
	 * @param quantity
	 */
	public Order(int ID, String orderNo, String productName, float price, int quantity) {
		super();
		this.ID = ID;
		this.orderNo = orderNo;
		ProductName = productName;
		this.price = price;
		this.quantity = quantity;
	}


	public String getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	@Override
	public String toString() {
		return "Order [ID=" + ID + ", orderNo=" + orderNo + ", ProductName=" + ProductName + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
	

}
