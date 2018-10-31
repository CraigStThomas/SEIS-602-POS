package application;

import java.util.LinkedList;

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
		admin = new User("admin", "admin", "admin", "0");

		user = new LinkedList<>();
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
}