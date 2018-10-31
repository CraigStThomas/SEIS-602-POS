
package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class CashierDrawer
{
	LinkedList<Transaction>		transactionList;
	Register					register;
	Cashier						cashier;
	String						loginTime;
	String						logoutTime;

	public CashierDrawer()
	{
		transactionList = new LinkedList<>();
	}

	public void addTransaction(Transaction transaction)
	{
		transactionList.add(transaction);
	}

	public void writeFile()
	{
		final String reportsFolder = "Reports";
		final String filepath = "Reports\\Cashier Reports";
		String[] dateParts = logoutTime.replace(":", "-").split(" ");
		StringBuffer dateStringBuffer = new StringBuffer("");
		for (int i = 0; i < dateParts.length; i++)
		{
			if (i != 0)
			{
				if (i == 3)
				{
					dateStringBuffer.append("_");
				}
				else
				{
					dateStringBuffer.append("-");
				}
			}
			dateStringBuffer.append(dateParts[i]);
		}

		final String filename = cashier.id + "_" + dateStringBuffer + ".csv";
		final String tempfilename = "temp.txt";

		try
		{
			File dir0 = new File(reportsFolder);
			if (dir0.exists() == false)
			{
				dir0.mkdir();
			}

			File dir = new File(filepath);
			if (dir.exists() == false)
			{
				dir.mkdir();
			}

			File file = new File(filepath + "\\" + filename);
			file.createNewFile();
			File tempfile = new File(filepath + "\\" + tempfilename);
//			Scanner input = new Scanner(file);
			PrintWriter output = new PrintWriter(filepath + "\\" + tempfilename);
//			while (input.hasNext())
//			{
//				String dataline = input.nextLine();
//				String[] values = dataline.split(",");
//				output.println(values[0] + "," + values[1] + "," + values[2] + "," + values[3] + "," + values[4] + "," + values[5] + "," + values[6] + "," + values[7] + "," + values[8]);
//			}

			output.println("Cashier Name" + "," + cashier.name);
			output.println("Cashier ID" + "," + cashier.id);
			output.println("Register ID" + "," + register.getId());
			output.println("Register Model" + "," + register.getModel());
			output.println("Register Vendor" + "," + register.getVendor());
			output.println();


			output.println("Transaction ID" + "," +
		               	   "Transaction Date" + "," +
		               	   "Items Returned?" + "," +
		               	   "Item Name" + "," +
		               	   "Item Price" + "," +
		               	   "Item ID");

			double drawerTotal = 0;

			for (Transaction transaction : transactionList)
			{
				int index = 0;

				output.println();

				for (Item item : transaction.items)
				{
					String transactionID = "";
					String transactionTime = "";
					String itemsReturned = "";
					if (index == 0)
					{
						transactionID = transaction.getId();
						transactionTime = transaction.getDate();
						itemsReturned = Boolean.toString(transaction.returnTransaction);
					}

					output.println(transactionID + "," +
					               transactionTime + "," +
					               itemsReturned + "," +
					               item.getName() + "," +
					               item.getPrice() + "," +
					               item.getId());

					if (transaction.returnTransaction)
					{
						drawerTotal -= item.getPrice();
					}
					else
					{
						drawerTotal += item.getPrice();
					}

					index++;
				}
			}

			output.println();
			output.println("" + "," +
		               	   "" + "," +
		               	   "" + "," +
		               	   "Total" + "," +
		               	   drawerTotal);
//		               	   String.format("%.2", drawerTotal));

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
