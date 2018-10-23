package application;

import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class RegisterWindow extends BaseWindow
{
	private class CashierCheck extends PasswordWindow
	{
		public CashierCheck()
		{
			super("Enter cashier username/password");
		}

		@Override
		protected void checkLogin()
		{
			if (true)
			{
				answer = new Boolean(true);
				stage.close();
			}
		}
	}

    LinkedList<Item> mySampleItems;
    LinkedList<Button> removeItemButtons;

    boolean validCashier;
    Button cashierLoginButton;
    Button cashierLogoutButton;
    Button printReportButton;
    Button closeRegisterButton;
    Button newTransactionButton;

    void disableRegisterButtons()
    {
    	cashierLoginButton.setDisable(true);
    	cashierLogoutButton.setDisable(true);
    	printReportButton.setDisable(true);
    	closeRegisterButton.setDisable(true);
    	newTransactionButton.setDisable(true);
    }

    void enableRegisterButtons()
    {
    	cashierLoginButton.setDisable(false);
    	cashierLogoutButton.setDisable(false);
    	printReportButton.setDisable(false);
    	closeRegisterButton.setDisable(false);
    	newTransactionButton.setDisable(false);
    }

    void loginCashier()
    {
    	validCashier = true;
    	cashierLoginButton.setDisable(true);
    	cashierLogoutButton.setDisable(false);
    }

    void logoutCashier()
    {
    	validCashier = false;
    	cashierLoginButton.setDisable(false);
    	cashierLogoutButton.setDisable(true);
    }

    void closeRegister()
    {
    	stage.close();
    }

    public RegisterWindow()
    {
    	super();
		stage.setTitle("Register");
    	validCashier = false;
    }

    private EventHandler<ActionEvent> removeItem(int itemIndex)
    {
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                for (int i = 0; i < removeItemButtons.size(); i++)
                {
                    if (event.getSource() == removeItemButtons.get(i))
                    {
                        mySampleItems.remove(i);
                        mainLayout.setRight(createTransaction());
                        stage.sizeToScene();
                    }
                }
            }
        };
    }

    private EventHandler<ActionEvent> addItem()
    {
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                switch ((int)(Math.random() * ((5) + 1)))
                {
                    case 0:
                        mySampleItems.add(new Item("83nf8", 1.95,  "banana"));
                        break;
                    case 1:
                        mySampleItems.add(new Item("asbp9", 22.15, "pretzels"));
                        break;
                    case 2:
                        mySampleItems.add(new Item("e8hen", 12.05, "potato"));
                        break;
                    case 3:
                        mySampleItems.add(new Item("sd0v8", 7.35,  "shirt"));
                        break;
                    default:
                        mySampleItems.add(new Item("sav8h", 2.77,  "crayons"));
                        break;
                }
                mainLayout.setRight(createTransaction());
                stage.sizeToScene();
            }
        };
    }

    protected GridPane createTransaction()
    {
    	GridPane myGridPane = new GridPane();

    	if (mySampleItems == null)
    	{
    		mySampleItems = new LinkedList<>();
    		removeItemButtons = new LinkedList<>();

    		mySampleItems.add(new Item("83nf8", 1.95,  "banana"));
            mySampleItems.add(new Item("asbp9", 22.15, "pretzels"));
            mySampleItems.add(new Item("e8hen", 12.05, "potato"));
            mySampleItems.add(new Item("sd0v8", 7.35,  "shirt"));
            mySampleItems.add(new Item("sav8h", 2.77,  "crayons"));
    	}

		int index = 0;

		//cashier
		Label cashierTitle = new Label("Cashier:");
		cashierTitle.setStyle("-fx-font-weight: bold");
		Label cashierValue = new Label("That Guy");
		GridPane.setConstraints(cashierTitle, 0, index++);
		GridPane.setMargin(cashierTitle, new Insets(5, 5, 0, 5));
		myGridPane.getChildren().add(cashierTitle);
		GridPane.setConstraints(cashierValue, 0, index++);
		GridPane.setMargin(cashierValue, new Insets(0, 5, 5, 5));
		myGridPane.getChildren().add(cashierValue);

		//register ID
		Label registerIDtitle = new Label("Register ID:");
		registerIDtitle.setStyle("-fx-font-weight: bold");
		Label registerIDvalue = new Label("97whghb4");
		GridPane.setConstraints(registerIDtitle, 0, index++);
		GridPane.setMargin(registerIDtitle, new Insets(5, 5, 0, 5));
		myGridPane.getChildren().add(registerIDtitle);
		GridPane.setConstraints(registerIDvalue, 0, index++);
		GridPane.setMargin(registerIDvalue, new Insets(0, 5, 5, 5));
		myGridPane.getChildren().add(registerIDvalue);

		//transaction ID
		Label transactionrIDtitle = new Label("Transaction ID:");
		transactionrIDtitle.setStyle("-fx-font-weight: bold");
		Label transactionIDvalue = new Label("sdbasb7sg232");
		GridPane.setConstraints(transactionrIDtitle, 0, index++);
		GridPane.setMargin(transactionrIDtitle, new Insets(5, 5, 0, 5));
		myGridPane.getChildren().add(transactionrIDtitle);
		GridPane.setConstraints(transactionIDvalue, 0, index++);
		GridPane.setMargin(transactionIDvalue, new Insets(0, 5, 5, 5));
		myGridPane.getChildren().add(transactionIDvalue);

		//customer
		Label customerNameTitle = new Label("Customer Name:");
		customerNameTitle.setStyle("-fx-font-weight: bold");
		Label customerNameValue = new Label("Someone buying stuff");
		GridPane.setConstraints(customerNameTitle, 0, index++);
		GridPane.setMargin(customerNameTitle, new Insets(5, 5, 0, 5));
		myGridPane.getChildren().add(customerNameTitle);
		GridPane.setConstraints(customerNameValue, 0, index++);
		GridPane.setMargin(customerNameValue, new Insets(0, 5, 5, 5));
		myGridPane.getChildren().add(customerNameValue);

		//date
		Label dateTitle = new Label("Date:");
		dateTitle.setStyle("-fx-font-weight: bold");
		Label dateValue = new Label("Yesterday");
		GridPane.setConstraints(dateTitle, 0, index++);
		GridPane.setMargin(dateTitle, new Insets(5, 5, 0, 5));
		myGridPane.getChildren().add(dateTitle);
		GridPane.setConstraints(dateValue, 0, index++);
		GridPane.setMargin(dateValue, new Insets(0, 5, 5, 5));
		myGridPane.getChildren().add(dateValue);

		//items
		EventHandler<ActionEvent> action = addItem();
		Button addItem = new Button("Add Item");
		addItem.setOnAction(action);
		GridPane.setConstraints(addItem, 0, index++);
		GridPane.setMargin(addItem, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(addItem);
		//header
		Label itemNameTitle = new Label("Item Name");
		itemNameTitle.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(itemNameTitle, 0, index);
		GridPane.setMargin(itemNameTitle, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(itemNameTitle);
		Label itemCostTitle = new Label("Item Cost");
		itemCostTitle.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(itemCostTitle, 1, index);
		GridPane.setMargin(itemCostTitle, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(itemCostTitle);
		Label itemIDtitle = new Label("Item ID");
		itemIDtitle.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(itemIDtitle, 2, index++);
		GridPane.setMargin(itemIDtitle, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(itemIDtitle);

		removeItemButtons = new LinkedList<>();

		for (int i = 0; i < mySampleItems.size(); i++)
		{
			Label itemName = new Label(mySampleItems.get(i).itemName);
			GridPane.setConstraints(itemName, 0, index);
			GridPane.setMargin(itemName, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemName);
			Label itemCost = new Label(String.format("%.2f", mySampleItems.get(i).itemCost));
			GridPane.setConstraints(itemCost, 1, index);
			GridPane.setMargin(itemCost, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemCost);
			Label itemID = new Label(mySampleItems.get(i).itemID);
			GridPane.setConstraints(itemID, 2, index);
			GridPane.setMargin(itemID, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemID);

			action = removeItem(i);
			Button removeItem = new Button("Remove Item");
			removeItem.setOnAction(action);
			GridPane.setConstraints(removeItem, 3, index++);
			GridPane.setMargin(removeItem, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(removeItem);
			removeItemButtons.add(removeItem);
		}

		Label transactionTotalTitle = new Label("total cost = ");
		transactionTotalTitle.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(transactionTotalTitle, 0, index);
		GridPane.setMargin(transactionTotalTitle, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(transactionTotalTitle);

		double transactionTotalPrice = 0;

		for (Item item : mySampleItems)
		{
			transactionTotalPrice += item.itemCost;
		}

		Label transactionTotalValue = new Label(String.format("%.2f", transactionTotalPrice));
		transactionTotalValue.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(transactionTotalValue, 1, index++);
		GridPane.setMargin(transactionTotalValue, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(transactionTotalValue);

		//complete transaction
		Button completeTransactionButton = new Button("Complete Transaction");
		completeTransactionButton.setOnAction(e ->
		{
			mainLayout.setRight(null);
	        stage.sizeToScene();
		});
        GridPane.setConstraints(completeTransactionButton, 0, index);
        GridPane.setMargin(completeTransactionButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(completeTransactionButton);

        //cancel transaction
        Button cancelTransactionButton = new Button("Cancel Transaction");
        cancelTransactionButton.setOnAction(e ->
        {
        	mainLayout.setRight(null);
            stage.sizeToScene();
        });
        GridPane.setConstraints(cancelTransactionButton, 1, index++);
        GridPane.setMargin(cancelTransactionButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(cancelTransactionButton);

		myGridPane.setStyle("-fx-border-color: black");

		return myGridPane;
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
    	GridPane myGridPane = new GridPane();

    	int index = 0;

        //id
        Label registerIDtitle = new Label("Register ID:");
        registerIDtitle.setStyle("-fx-font-weight: bold");
        Label registerIDvalue = new Label("97whghb4");
        GridPane.setConstraints(registerIDtitle, 0, index++);
        GridPane.setMargin(registerIDtitle, new Insets(5, 5, 0, 5));
        myGridPane.getChildren().add(registerIDtitle);
        GridPane.setConstraints(registerIDvalue, 0, index++);
        GridPane.setMargin(registerIDvalue, new Insets(0, 5, 5, 5));
        myGridPane.getChildren().add(registerIDvalue);

        //model
        Label registerModelTitle = new Label("Register Model:");
        registerModelTitle.setStyle("-fx-font-weight: bold");
        Label registerModelValue = new Label("apsib8");
        GridPane.setConstraints(registerModelTitle, 0, index++);
        GridPane.setMargin(registerModelTitle, new Insets(5, 5, 0, 5));
        myGridPane.getChildren().add(registerModelTitle);
        GridPane.setConstraints(registerModelValue, 0, index++);
        GridPane.setMargin(registerModelValue, new Insets(0, 5, 5, 5));
        myGridPane.getChildren().add(registerModelValue);

        //vendor
        Label registerVendorTitle = new Label("Register Vendor:");
        registerVendorTitle.setStyle("-fx-font-weight: bold");
        Label registerVendorValue = new Label("Acme Registers");
        GridPane.setConstraints(registerVendorTitle, 0, index++);
        GridPane.setMargin(registerVendorTitle, new Insets(5, 5, 0, 5));
        myGridPane.getChildren().add(registerVendorTitle);
        GridPane.setConstraints(registerVendorValue, 0, index++);
        GridPane.setMargin(registerVendorValue, new Insets(0, 5, 5, 5));
        myGridPane.getChildren().add(registerVendorValue);

        myGridPane.setStyle("-fx-border-color: black");

        return myGridPane;
	}

    @Override
	protected GridPane createCenterPane()
	{
    	GridPane myGridPane = new GridPane();

        int index = 0;

        cashierLoginButton = new Button("Cashier Login");
        cashierLoginButton.setOnAction(e ->
        {
        	CashierCheck adminCheck = new CashierCheck();

    		if ((Boolean)adminCheck.buildStage(true))
    		{
    			enableRegisterButtons();
    			loginCashier();
    		}
        });
        GridPane.setConstraints(cashierLoginButton, 0, index++);
        GridPane.setMargin(cashierLoginButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(cashierLoginButton);

        cashierLogoutButton = new Button("Cashier Logout");
        cashierLogoutButton.setOnAction(e ->
        {
        	disableRegisterButtons();
        	logoutCashier();
        });
        GridPane.setConstraints(cashierLogoutButton, 0, index++);
        GridPane.setMargin(cashierLogoutButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(cashierLogoutButton);

        printReportButton = new Button("Print Report");
        GridPane.setConstraints(printReportButton, 0, index++);
        GridPane.setMargin(printReportButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(printReportButton);

        closeRegisterButton = new Button("Close Register");
        closeRegisterButton.setOnAction(e ->
        {
        	closeRegister();
        });
        GridPane.setConstraints(closeRegisterButton, 0, index++);
        GridPane.setMargin(closeRegisterButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(closeRegisterButton);

        newTransactionButton = new Button("New Transaction");
        newTransactionButton.setOnAction(e ->
        {
        	mainLayout.setRight(createTransaction());
            stage.sizeToScene();
        });
        GridPane.setConstraints(newTransactionButton, 0, index++);
        GridPane.setMargin(newTransactionButton, new Insets(25, 5, 5, 5));
        myGridPane.getChildren().add(newTransactionButton);

        disableRegisterButtons();
        cashierLoginButton.setDisable(false);

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
