package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

@RequestScoped
@Path("/orders")
public class OrdersRestService
{
	
	@Inject
	OrdersBusinessInterface service;

	@GET
	@Path("/getOrdersAsJson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson() 
	{
		return service.getOrders();
	}
	
	@GET
	@Path("/getOrdersAsXml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrdersAsXml()
	{
		return service.getOrders().toArray(new Order[service.getOrders().size()]);
	}
}
