
package application;

import java.util.LinkedList;

public class Transaction
{
	private String		transactionID;
	private Cashier		cashier;
	private Register	register;
	private String		date;
	public boolean		returnTransaction = false;

	LinkedList<Item>	items;

	public Transaction()
	{
		items = new LinkedList<>();
		cashier = new Cashier();
		register = new Register();
	}

	public Transaction copy()
	{
		Transaction tempTransaction = new Transaction();

		tempTransaction.transactionID = new String(transactionID);
		tempTransaction.date = new String(date);
		tempTransaction.cashier = cashier.copy();
		tempTransaction.register = register.copy();

		for (Item item : items)
		{
			tempTransaction.items.add(item.copy());
		}

		return tempTransaction;
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
		return cashier;
	}
	public void setCashier(Cashier Cashier)
	{
		this.cashier = Cashier;
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