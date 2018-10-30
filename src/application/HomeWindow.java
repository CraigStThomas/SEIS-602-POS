package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class HomeWindow extends BaseWindow
{
	Inventory inventory;
	UsersList usersList;
	OrderList orderList;
	TransactionHistory transactionHistory;

	private class AdminCheck extends PasswordWindow
	{
		public AdminCheck()
		{
			super("Enter Admin username/password");
		}

		@Override
		protected void checkLogin()
		{
			if (usersList.validateAdmin(usernameInput.getText(), passwordInput.getText()))
			{
				answer = new Boolean(true);
				stage.close();
			}
		}
	}

	public HomeWindow(Inventory inputInventory, UsersList inputUserList, OrderList inputOrderList, TransactionHistory inputTransactionHistory)
	{
		super(false);

		inventory = inputInventory;
		usersList = inputUserList;
		orderList = inputOrderList;
		transactionHistory = inputTransactionHistory;

		AdminCheck adminCheck = new AdminCheck();

		if ((Boolean)adminCheck.buildStage(true))
		{
			buildStage(false);
			stage.setTitle("POS: Admin Window");
			stage.setMinWidth(300);
//			stage.setMinHeight(190);
//			stage.setResizable(false);
		}
	}

	@Override
	protected VBox createTopPane() {return null;}

	@Override
	protected GridPane createLeftPane() {return null;}

	@Override
	protected GridPane createCenterPane()
	{
		int index = 0;
		GridPane myGridPane = new GridPane();

		Button viewUser = new Button("Users");
		viewUser.setOnAction(e ->
		{
			Main.getApplicationWindows().add(new UsersWindow(usersList));
		});
		GridPane.setConstraints(viewUser, 0, index++);
		GridPane.setMargin(viewUser, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(viewUser);

		Button viewOrders = new Button("Orders");
		viewOrders.setOnAction(e ->
		{
			Main.getApplicationWindows().add(new OrderListWindow(inventory, orderList));
		});
		GridPane.setConstraints(viewOrders, 0, index++);
		GridPane.setMargin(viewOrders, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(viewOrders);

		Button viewInventory = new Button("Inventory");
		viewInventory.setOnAction(e ->
		{
			Main.getApplicationWindows().add(new InventoryWindow(false, true, inventory));
		});
		GridPane.setConstraints(viewInventory, 0, index++);
		GridPane.setMargin(viewInventory, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(viewInventory);

		TextField registerID = new TextField();
		registerID.setPromptText("set register ID");
		GridPane.setConstraints(registerID, 1, index);
		GridPane.setMargin(registerID, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(registerID);

		Button createRegister = new Button("Create\nRegister");
		createRegister.setTextAlignment(TextAlignment.CENTER);
		createRegister.setOnAction(e ->
		{
			if (!registerID.getText().equals(""))
			{
				Register myRegister = new Register();
				myRegister.setId(registerID.getText());
				myRegister.setModel("B.47A");
				myRegister.setVendor("Acme Registers");
				mainLayout.setCenter(createCenterPane());
				Main.getApplicationWindows().add(new RegisterWindow(myRegister, inventory, usersList, transactionHistory));
			}
		});
		GridPane.setConstraints(createRegister, 0, index++);
		GridPane.setMargin(createRegister, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(createRegister);

		return myGridPane;
	}

	@Override
	protected GridPane createRightPane()
	{
		return null;
	}

	@Override
	protected VBox createBottomPane()
	{
		return null;
	}
}
