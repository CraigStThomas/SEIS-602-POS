package application;

import java.io.Serializable;
import java.util.LinkedList;

public class CashierDrawer implements Serializable
{
	private static final long serialVersionUID = 121212L;	//serializable wants this

	LinkedList<Transaction> transactionList;
	Register register;
	Cashier cashier;
	String loginTime;
	String logoutTime;

	public CashierDrawer()
	{
		transactionList = new LinkedList<>();
	}
}
