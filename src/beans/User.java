package beans;

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean 
@ViewScoped 
public class User {
	
	/**
	 * this creates a first name for a user to enter and binds it to be not Null and also between 3 and 15 characters 
	 */
	@NotNull(message = "Please enter a first name")
	@Size(min = 3, max = 15) 
	String firstName;
	
	/**
	 * this creates a last name for a user to enter and binds it to be not Null and also between 3 and 15 characters 
	 */
	@NotNull(message = "Please enter a last name")
	@Size(min = 3, max = 15)
	String lastName;
	
	/**
	 * constructor 
	 */
	public User() {
		
		this.firstName = "";
		this.lastName = "";
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
