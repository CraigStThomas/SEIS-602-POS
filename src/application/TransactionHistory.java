package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class TransactionHistory
{
	private LinkedList<Transaction> transactions;

	public TransactionHistory()
	{
		transactions = new LinkedList<>();
	}

	public LinkedList<Transaction> getTransactions()
	{
		return transactions;
	}

	public boolean removeTransaction(Transaction transaction)
	{
		for (int i = 0; i < transactions.size(); i++)
		{
			if (transactions.get(i).getId().equals(transaction.getId()))
			{
				transactions.remove(i);
				return true;
			}
		}

		return false;
	}

	public void addTransaction(Transaction transaction)
	{
		transactions.add(transaction);
	}

	public void writeToFile()
	{
		final String filepath = "Reports";
		final String filename = "Transaction History.csv";
		final String tempfilename = "temp.txt";

		try
		{
			File dir = new File(filepath);
			if (dir.exists() == false)
			{
				dir.mkdir();
			}

			File file = new File(filepath + "\\" + filename);
			file.createNewFile();
			File tempfile = new File(filepath + "\\" + tempfilename);
			PrintWriter output = new PrintWriter(filepath + "\\" + tempfilename);


			output.println("Transaction ID" + "," +
		               	   "Transaction Date" + "," +
		               	   "Cashier Name" + "," +
		               	   "Cashier ID" + "," +
		               	   "Register ID" + "," +
		               	   "Register Model" + "," +
		               	   "Register Vendor" + "," +
		               	   "Items Returned?" + "," +
		               	   "Item Name" + "," +
		               	   "Item Price" + "," +
		               	   "Item ID");

			for (Transaction transaction : transactions)
			{
				int index = 0;

				output.println();

				for (Item item : transaction.items)
				{
					String transactionID = "";
					String transactionTime = "";
					String itemsReturned = "";
					String cashierName = "";
               	   	String cashierID = "";
               	   	String registerID = "";
               	   	String registerModel = "";
               	   	String registerVendor = "";
					if (index == 0)
					{
						transactionID = transaction.getId();
						transactionTime = transaction.getDate();
						cashierName = transaction.getCashier().getName();
						cashierID = transaction.getCashier().getId();
						registerID = transaction.getRegister().getId();
						registerModel = transaction.getRegister().getModel();
						registerVendor = transaction.getRegister().getVendor();
						itemsReturned = Boolean.toString(transaction.returnTransaction);
					}

					output.println(transactionID + "," +
					               transactionTime + "," +
					               cashierName + "," +
								   cashierID + "," +
								   registerID + "," +
								   registerModel + "," +
								   registerVendor + "," +
					               itemsReturned + "," +
					               item.getName() + "," +
					               item.getPrice() + "," +
					               item.getId());
					index++;
				}
			}
//			input.close();
			output.close();
			file.delete();
			tempfile.renameTo(file);

		}
		catch (IOException e)
		{

			e.printStackTrace();

		}
	}
}
