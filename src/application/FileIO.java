
package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileIO
{
	public FileIO()
	{

	}

	public static void test()
	{

		TransactionHistory transactionHistory = new TransactionHistory();

		try
		{
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(transactionHistory);

			o.close();
			f.close();

			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			TransactionHistory transactionHistory2 = (TransactionHistory) oi.readObject();

			oi.close();
			fi.close();

		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch (IOException e)
		{
			System.out.println("Error initializing stream");
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Object readFile(String filename)
	{
		Object obj = new Object();

		try
		{
			FileInputStream fi = new FileInputStream(new File(filename));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			obj = oi.readObject();

			oi.close();
			fi.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch (IOException e)
		{
			System.out.println("Error initializing stream");
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	public static void writeFile(String filename, Object obj)
	{
		try
		{
			FileOutputStream f = new FileOutputStream(new File(filename));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(obj);

			o.close();
			f.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch (IOException e)
		{
			System.out.println("Error initializing stream");
		}
	}
}
