package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class TransactionHistory
{
	private LinkedList<Transaction> transactions;

	public TransactionHistory()
	{
		transactions = new LinkedList<>();
	}

	public TransactionHistory(int test)
	{
		transactions = new LinkedList<>();

		makeDummyData();
	}

	private void makeDummyData()
	{
		Transaction myTransaction = new Transaction();
		myTransaction.returnTransaction = false;
		myTransaction.setCashier(new Cashier("Aba", "doug1324"));
		myTransaction.setRegister(new Register("abc123", "B.47A", "Acme Registers"));
		myTransaction.setId("abc123abc123");
		myTransaction.setDate(DateAndTime.getDateAndTime());
		myTransaction.items.add(new Item("Banana", 0.99, "4011"));
		myTransaction.items.add(new Item("Banana", 0.99, "4011"));
		transactions.add(myTransaction);

		myTransaction = new Transaction();
		myTransaction.returnTransaction = false;
		myTransaction.setCashier(new Cashier("Adrien", "buff2949"));
		myTransaction.setRegister(new Register("abc123", "B.47A", "Acme Registers"));
		myTransaction.setId("abc456abc456");
		myTransaction.setDate(DateAndTime.getDateAndTime());
		myTransaction.items.add(new Item("Apple", 1.49, "3294"));
		myTransaction.items.add(new Item("Apple", 1.49, "3294"));
		transactions.add(myTransaction);

		myTransaction = new Transaction();
		myTransaction.returnTransaction = false;
		myTransaction.setCashier(new Cashier("Craig", "gabe2453"));
		myTransaction.setRegister(new Register("def456", "B.47A", "Acme Registers"));
		myTransaction.setId("abc789abc789");
		myTransaction.setDate(DateAndTime.getDateAndTime());
		myTransaction.items.add(new Item("Bell Pepper", 0.99, "4088"));
		myTransaction.items.add(new Item("Bell Pepper", 0.99, "4088"));
		transactions.add(myTransaction);

		myTransaction = new Transaction();
		myTransaction.returnTransaction = false;
		myTransaction.setCashier(new Cashier("Ishan", "mish6742"));
		myTransaction.setRegister(new Register("def456", "B.47A", "Acme Registers"));
		myTransaction.setId("456def456def");
		myTransaction.setDate(DateAndTime.getDateAndTime());
		myTransaction.items.add(new Item("Banana", 0.99, "4011"));
		myTransaction.items.add(new Item("Apple", 1.49, "3294"));
		myTransaction.items.add(new Item("Bell Pepper", 0.99, "4088"));
		transactions.add(myTransaction);

		writeFile();
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

	public void writeFile()
	{
		final String filepath = "Reports";
		final String filename = "TransactionHistory.csv";
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

//				output.println();

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

	public void readFile()
	{
		final String filepath = "Reports";
		final String filename = "TransactionHistory.csv";

		File file = new File(filepath + "\\" + filename);

		String data;
		String[] values;
		try
		{
			Scanner input = new Scanner(file);

			//burn the header
			if (input.hasNext())
			{
				data = input.nextLine();
			}

			int index = 0;
			Transaction tempTransaction = new Transaction();

			while (input.hasNextLine())
			{
				data = input.nextLine();
				values = data.split(",");

				if (values[0].equals(""))
				{
					tempTransaction.items.add(new Item(values[8], Double.parseDouble(values[9]), values[10]));
				}
				else
				{
					if (index != 0)
					{
						transactions.add(tempTransaction);
					}

					tempTransaction = new Transaction();

					tempTransaction.setId(values[0]);
					tempTransaction.setDate(values[1]);
					tempTransaction.getCashier().setName(values[2]);
					tempTransaction.getCashier().setId(values[3]);
					tempTransaction.getRegister().setId(values[4]);
					tempTransaction.getRegister().setModel(values[5]);
					tempTransaction.getRegister().setVendor(values[6]);
					tempTransaction.returnTransaction = Boolean.parseBoolean(values[7]);
					tempTransaction.items.add(new Item(values[8], Double.parseDouble(values[9]), values[10]));
				}
				index++;
			}

			transactions.add(tempTransaction);

			input.close();

		}
		catch (FileNotFoundException e)
		{
			makeDummyData();
		}
	}
}
