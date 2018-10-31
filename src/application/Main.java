
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

	public static LinkedList<BaseWindow> getApplicationWindows()
	{
		return applicationWindows;
	}

	@Override
	public void start(Stage primaryStage)
	{
		orderList = new OrderList(1);
		inventory = new Inventory(orderList);
		inventory.readFile();
		usersList = new UsersList();
		usersList.readFile();
		transactionHistory = new TransactionHistory();
		transactionHistory.readFile();

//		CashierDrawer cashierDrawer = new CashierDrawer();
//		cashierDrawer.register = new Register("reg123", "b.47A", "acme registers");
//		cashierDrawer.cashier = new Cashier("my dude", "dude123");
//		cashierDrawer.loginTime = DateAndTime.getDateAndTime();
//		cashierDrawer.logoutTime = DateAndTime.getDateAndTime();
//
//		Transaction myTransaction = new Transaction();
//		myTransaction.returnTransaction = true;
//		myTransaction.setCashier(new Cashier("some guy", "abcd"));
//		myTransaction.setRegister(new Register("112233", "", ""));
//		myTransaction.setId("111222333");
//		myTransaction.setDate(DateAndTime.getDateAndTime());
//
//		myTransaction.items.add(new Item("Thing 1", 1.99, "asg7"));
//		myTransaction.items.add(new Item("Thing 2", 2.99, "aehr"));
//		myTransaction.items.add(new Item("Thing 3", 3.99, "24yb"));
//		cashierDrawer.transactionList.add(myTransaction);
//
//		myTransaction = new Transaction();
//		myTransaction.returnTransaction = true;
//		myTransaction.setCashier(new Cashier("some guy", "abcd"));
//		myTransaction.setRegister(new Register("112233", "", ""));
//		myTransaction.setId("333222111");
//		myTransaction.setDate(DateAndTime.getDateAndTime());
//
//		myTransaction.items.add(new Item("Thing 1", 1.99, "asg7"));
//		myTransaction.items.add(new Item("Thing 2", 2.99, "aehr"));
//		myTransaction.items.add(new Item("Thing 3", 3.99, "24yb"));
//		cashierDrawer.addTransaction(myTransaction);
//
//		cashierDrawer.writeFile();
//
//		RegisterDrawer registerDrawer = new RegisterDrawer(new Register("jyct6", "b.47a", "acme registers"));
//		registerDrawer.loginTime = DateAndTime.getDateAndTime();
//		registerDrawer.logoutTime = DateAndTime.getDateAndTime();
//
//		myTransaction = new Transaction();
//		myTransaction.returnTransaction = true;
//		myTransaction.setCashier(new Cashier("some guy", "abcd"));
//		myTransaction.setRegister(new Register("112233", "", ""));
//		myTransaction.setId("111222333");
//		myTransaction.setDate(DateAndTime.getDateAndTime());
//
//		myTransaction.items.add(new Item("Thing 1", 1.99, "asg7"));
//		myTransaction.items.add(new Item("Thing 2", 2.99, "aehr"));
//		myTransaction.items.add(new Item("Thing 3", 3.99, "24yb"));
//		registerDrawer.transactionList.add(myTransaction);
//
//		myTransaction = new Transaction();
//		myTransaction.setCashier(new Cashier("some guy", "abcd"));
//		myTransaction.setRegister(new Register("112233", "", ""));
//		myTransaction.setId("333222111");
//		myTransaction.setDate(DateAndTime.getDateAndTime());
//
//		myTransaction.items.add(new Item("Thing 1", 1.99, "asg7"));
//		myTransaction.items.add(new Item("Thing 2", 2.99, "aehr"));
//		myTransaction.items.add(new Item("Thing 3", 3.99, "24yb"));
//		registerDrawer.transactionList.add(myTransaction);
//
//		registerDrawer.writeFile();

//		usersList.writeFile();
//
//		UsersList tempList = new UsersList();
//		tempList.readFile();

//		inventory.writeFile();
//
//		Inventory inventory2 = new Inventory();
//		inventory2.readFile();

//		System.out.println();

//		System.out.println(transactionHistory);


		applicationWindows.add(new HomeWindow(inventory, usersList, orderList, transactionHistory));
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
