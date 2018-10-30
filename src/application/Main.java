
package application;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	private static LinkedList<BaseWindow> applicationWindows = new LinkedList<>();
	private static boolean loginValid = false;
	private static String usernameAdmin = "banana";
	private static String passwordAdmin = "apple";

	static boolean checkUsernameAdmin(String inputString)
	{
		boolean returnValue = false;

		if (inputString.equals(usernameAdmin))
		{
			returnValue = true;
		}

		return returnValue;
	}

	static boolean checkPasswordAdmin(String inputString)
	{
		boolean returnValue = false;

		if (inputString.equals(passwordAdmin))
		{
			returnValue = true;
		}

		return returnValue;
	}

	public static LinkedList<BaseWindow> getApplicationWindows()
	{
		return applicationWindows;
	}

	public static void setLoginValid(boolean status)
	{
		loginValid = status;

		applicationWindows.get(0).closeWindow();
		applicationWindows.remove(0);
		applicationWindows.add(new HomeWindow());
	}

	@Override
	public void start(Stage primaryStage)
	{
		Inventory inventory = new Inventory(1);
		OrderList orderList = new OrderList(1);
		UsersList userList = new UsersList(1);

//		FileIO test = new FileIO();
//		test.testWrite();
//		test.testRead();


		applicationWindows.add(new HomeWindow());
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
