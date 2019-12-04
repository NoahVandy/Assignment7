package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {

	@Inject
	OrdersBusinessInterface service;
	
	
	/**
	 * this function is called when the user submits their data on the TestForm and
	 * checks with the user class to make sure that is uses the correct user
	 * parameters, then sends the user that it just created to the TestResponse JSF
	 * 
	 * @param user
	 * @return
	 */
	public String onLogOff()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "TestResponse.xhtml?faces-redirect=true";
	}
	
	
	public OrdersBusinessInterface getService() 
	{
		return service;
	}
}
