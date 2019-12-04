package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
			propertyName = "destination", propertyValue = "Order"), @ActivationConfigProperty(
			propertyName = "destinationType", propertyValue = "javax.jms.Queue")
	}, 
	mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {

	@Inject
	OrdersBusinessInterface service;
	
    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message)
    {
        // TODO Auto-generated method stub
        try 
        {
        	if(message instanceof TextMessage)
        	{
        		System.out.println("======================== OrderMessageService.onMessage() with a TextMessage: " + ((TextMessage)message).getText());
        	}
        	else if(message instanceof ObjectMessage) 
        	{
        		System.out.println("======================== OrderMessageService.onMessage() with a ObjectMessage: " + ((ObjectMessage)message).getObject());
        	}
        	else
        	{
        		System.out.println("======================== OrderMessageService.onMessage() with a UNKNOWN message type");
        	}
        }
        catch(JMSException e)
        {
        	e.printStackTrace();
        }
    }

}
