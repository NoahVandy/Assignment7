package business;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.User;

@RequestScoped
@Path("/users")
public class UserRestService {
	
	@GET
	@Path("/getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() 
	{
		System.out.println("API was /getusers: getting all of the users");
		User user = new User();
		user.setFirstName("Noah");
		user.setLastName("Vandervelden");
		return user;
	}
	
	@GET
	@Path("/get/{firstName}/{lastName}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) 
	{
		System.out.println("API was /getuser: I recieved request for name: " + firstName + " " + lastName);
		User user = new User();
		user.setFirstName("Noah");
		user.setLastName("Vandervelden");
		return user;
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User saveUser(User user) {
		System.out.println("Hello " + user.getFirstName() + " " + user.getLastName());
		return user;
	}
	
}
