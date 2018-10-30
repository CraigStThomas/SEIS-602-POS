package application;

import java.io.Serializable;
import java.util.LinkedList;

public class TransactionHistory implements Serializable
{
	private static final long serialVersionUID = 333L;	//serializable wants this

	LinkedList<Transaction> transactions;

	public TransactionHistory()
	{
		transactions = new LinkedList<>();
	}
}
