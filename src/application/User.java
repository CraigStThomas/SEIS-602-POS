
package application;

import java.io.Serializable;

public class User extends Cashier implements Serializable
{
	private static final long serialVersionUID = 888L;	//serializable wants this

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
