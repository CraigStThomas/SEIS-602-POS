
package application;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	Inventory inventory;
	OrderList orderList;
	UsersList usersList;
	TransactionHistory transactionHistory;

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

	@Override
	public void start(Stage primaryStage)
	{
		orderList = new OrderList(1);
		inventory = new Inventory(1, orderList);
		usersList = new UsersList(1);
		transactionHistory = new TransactionHistory();

//		FileIO.test();


		applicationWindows.add(new HomeWindow(inventory, usersList, orderList, transactionHistory));
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
