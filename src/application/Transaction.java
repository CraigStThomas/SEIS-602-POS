
package application;

import java.util.LinkedList;

public class Transaction
{
	private String		transactionID;
	private Cashier		Cashier;
	private Register	register;
	private String		date;

	LinkedList<Item>	items;

	public Transaction()
	{
		items = new LinkedList<>();
	}

	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}

	public String getId()
	{
		return transactionID;
	}
	public void setId(String Id)
	{
		transactionID = Id;
	}
	public Cashier getCashier()
	{
		return Cashier;
	}
	public void setCashier(Cashier Cashier)
	{
		this.Cashier = Cashier;
	}
	public Register getRegister()
	{
		return register;
	}
	public void setRegister(Register inputRegister)
	{
		register = inputRegister;
	}
}