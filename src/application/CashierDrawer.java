package application;

import java.util.LinkedList;

public class CashierDrawer
{
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
