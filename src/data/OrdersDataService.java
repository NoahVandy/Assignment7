package data;

import beans.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OrdersDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class OrdersDataService implements DataAccessInterface<Order> {

    /**
     * Default constructor. 
     */
    public OrdersDataService() 
    {
    	
    }

	/**
     * @see DataAccessInterface#delete(T)
     */
    public boolean delete(Order t) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#findAll()
     */
    public List<Order> findAll() 
    {
    	Connection conn = null;
    	List<Order> orders = new ArrayList<Order>();
		String url = "jdbc:mysql://localhost:3306/dbconnect";
		String username = "root";
		String password = "root";
		String sql = "SELECT * FROM orders";
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				orders.add(new Order(rs.getInt("ID"), rs.getString("ORDERS_NO"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QUANTITY")));
			}
			rs.close();
			System.out.println("Connected to the database");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
    	return orders;
    }

	/**
     * @see DataAccessInterface#create(T)
     */
    public boolean create(Order order) {
    	Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/dbconnect";
		String username = "root";
		String password = "root";
		String sql = String.format("INSERT INTO orders(ORDERS_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES ('%s', '%s', %f, %d)", order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		}  
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println(sql);
		return true;
    }

	/**
     * @see DataAccessInterface#update(T)
     */
    public boolean update(Order t) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#findById(int)
     */
    public Order findById(int id) {
        // TODO Auto-generated method stub
			return null;
    }

}
