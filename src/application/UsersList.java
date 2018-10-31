package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class UsersList
{
	public User				admin;
	public LinkedList<User>	user;

	public UsersList()
	{
		user = new LinkedList<>();
	}

	public UsersList(int test)
	{
		user = new LinkedList<>();

		makeDummyData();
	}

	private void makeDummyData()
	{
		admin = new User("admin", "admin", "admin", "0");

		user.add(new User("Aba", "Aba", "1234", "doug1324"));
		user.add(new User("Adrien", "Adrien", "1234", "buff2949"));
		user.add(new User("Craig", "Craig", "1234", "gabe2453"));
		user.add(new User("Ishan", "Ishan", "1234", "mish6742"));
	}

	public void setAdmin(User newAdmin)
	{
		admin = newAdmin;
	}

	public void addUser(User newUser)
	{
		user.add(newUser);
	}

//	public void removeUser(User newUser)
//	{
//		user.remove(newUser);
//	}

	public boolean validateAdmin(String inputUsername, String inputPassword)
	{
		if (admin.validateUser(inputUsername, inputPassword))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public Cashier validateUserCredentials(String inputUsername, String inputPassword)
	{
		for (int i = 0; i < user.size(); i++)
		{
			if (user.get(i).validateUser(inputUsername, inputPassword))
			{
				return new Cashier(user.get(i).name, user.get(i).id);
			}
		}
		return null;
	}

	public void writeFile()
	{
		final String filepath = "Reports";
		final String filename = "UserList.csv";
		final String tempfilename = "temp.txt";

		try
		{
			File dir = new File(filepath);
			if (dir.exists() == false)
			{
				dir.mkdir();
			}

			File file = new File(filepath + "\\" + filename);
			File tempfile = new File(filepath + "\\" + tempfilename);
			file.createNewFile();
			PrintWriter output = new PrintWriter(filepath + "\\" + tempfilename);

			output.println("Name" + "," +
				   	   	   "ID" + "," +
				   	   	   "Username" + "," +
				   	   	   "Password");

			output.println(admin.name + "," +
					   	   admin.id + "," +
					   	   admin.username + "," +
					   	   admin.password);

			for (User tempUser : user)
			{
				output.println(tempUser.name + "," +
							   tempUser.id + "," +
							   tempUser.username + "," +
							   tempUser.password);

			}
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
		final String filename = "UserList.csv";

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

			if (input.hasNext())
			{
				data = input.nextLine();
				values = data.split(",");

				User tempUser = new User(values[0], values[2], values[3], values[1]);
				admin = tempUser;
			}

			while (input.hasNext())
			{
				data = input.nextLine();
				values = data.split(",");

				User tempUser = new User(values[0], values[2], values[3], values[1]);
				user.add(tempUser);

			}

			input.close();

		}
		catch (FileNotFoundException e)
		{
			makeDummyData();
		}
	}
}