
package application;

public class User extends Cashier
{
	public String	username;
	public String	password;

	public User()
	{

	}

	public User(String Name, String UserName, String Password, String inputID)
	{
		name = Name;
		username = UserName;
		password = Password;
		id = inputID;
	}

	public String getName()
	{
		return name;
	}

	public String getID()
	{
		return id;
	}

	public boolean validateUser(String inputUsername, String inputPassword)
	{

		if ((inputUsername.equals(username)) && (inputPassword.equals(password)))
		{
			return true;
		}
		return false;
	}
}
