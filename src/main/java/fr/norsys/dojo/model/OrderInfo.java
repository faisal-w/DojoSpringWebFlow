package fr.norsys.dojo.model;

import java.io.Serializable;

public class OrderInfo implements Serializable {
	
	private static final long serialVersionUID = 8784268505637555847L;
	
	private String firstName;
	private String lastName;
	private String adress;
	private String creditCardNumber;
	
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	

	
}
