package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class HomeWindow extends BaseWindow
{
	protected String adminUsername = "banana";
	protected String adminPassword = "apple";

	private class AdminCheck extends PasswordWindow
	{
		public AdminCheck()
		{
			super("Enter Admin username/password");
		}

		@Override
		protected void checkLogin()
		{
			if (true)//(usernameInput.getText().equals(adminUsername) && passwordInput.getText().equals(adminPassword))
			{
				answer = new Boolean(true);
				stage.close();
			}
		}
	}

	public HomeWindow()
	{
		super(false);

		AdminCheck adminCheck = new AdminCheck();

		if ((Boolean)adminCheck.buildStage(true))
		{
			buildStage(true);
			stage.setTitle("Home Window");
		}
	}

	@Override
	protected VBox createTopPane()
	{
		Menu menu0 = new Menu("File");

		MenuItem menuItem = new MenuItem("Exit");
		menuItem.setOnAction(e -> closeWindow());
		menu0.getItems().add(menuItem);

		MenuBar menuBar = new MenuBar();

		menuBar.getMenus().addAll(menu0);

		VBox myVBox = new VBox();
		myVBox.setPadding(new Insets(0, 0, 0, 0));

		myVBox.getChildren().addAll(menuBar);

		return myVBox;
	}

	@Override
	protected GridPane createLeftPane()
	{
		return null;
	}

	@Override
	protected GridPane createCenterPane()
	{
		int index = 0;
		GridPane myGridPane = new GridPane();

		Button viewUser = new Button("Users");
		viewUser.setOnAction(e ->
		{
			Main.getApplicationWindows().add(new UsersWindow());
		});
		GridPane.setConstraints(viewUser, 0, index++);
		GridPane.setMargin(viewUser, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(viewUser);

		Button viewOrders = new Button("Orders");
		viewOrders.setOnAction(e ->
		{
//			Main.getApplicationWindows().add(new OrdersWindow());
		});
		GridPane.setConstraints(viewOrders, 0, index++);
		GridPane.setMargin(viewOrders, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(viewOrders);

		Button viewInventory = new Button("Inventory");
		viewInventory.setOnAction(e ->
		{
			Main.getApplicationWindows().add(new InventoryWindow());
		});
		GridPane.setConstraints(viewInventory, 0, index++);
		GridPane.setMargin(viewInventory, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(viewInventory);

		Button createRegister = new Button("Create\nRegister");
		createRegister.setTextAlignment(TextAlignment.CENTER);
		createRegister.setOnAction(e ->
		{
			Main.getApplicationWindows().add(new RegisterWindow());
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
