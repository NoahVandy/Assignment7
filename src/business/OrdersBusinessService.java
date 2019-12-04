package business;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import data.DataAccessInterface;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative 
public class OrdersBusinessService implements OrdersBusinessInterface {

	@Inject
	DataAccessInterface<Order> dataService;
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;
	
	
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	System.out.println("=====================> hello from your OrdersBusinessService.test()");
    }

    @Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return dataService.findAll();
	}

	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
	}

	@Override
	public void sendOrder(Order order) {
		// TODO Auto-generated method stub
		try 
		{
			 Connection connection = connectionFactory.createConnection();
			 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			 
			 MessageProducer messageProducer = session.createProducer(queue);
			 
			 TextMessage message1 = session.createTextMessage();
			 message1.setText("this is the text message");
			 messageProducer.send(message1);
			 
			 ObjectMessage message2 = session.createObjectMessage();
			 message2.setObject(order);
			 messageProducer.send(message2);
			 
			 connection.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

}
