package application;

import java.util.LinkedList;

public class Users
{
	public class User
	{
		String name;
		String userName;
		String password;

		public User(String inputName, String inputUserName, String inputPassword)
		{
			name = inputName;
			userName = inputUserName;
			password = inputPassword;
		}
	}

	public static User admin;
	public static LinkedList<User> user;

	public Users()
	{
		admin = new User("admin", "banana", "apple");

		user = new LinkedList<>();
		user.add(new User("Aba",    "Aba",    "1234"));
		user.add(new User("Adrien", "Adrien", "1234"));
		user.add(new User("Craig",  "Craig",  "1234"));
		user.add(new User("Ishan",  "Ishan",  "1234"));
	}

	public static void addUser(User newUser)
	{
		user.add(newUser);
	}
}
