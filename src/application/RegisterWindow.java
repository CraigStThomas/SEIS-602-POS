package application;

import java.util.LinkedList;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
			Cashier returnCashier = usersList.validateUserCredentials(usernameInput.getText(), passwordInput.getText());
			if (returnCashier != null)
			{
				answer = returnCashier;
				stage.close();
			}
		}
	}

//    LinkedList<Item> mySampleItems;
	UsersList usersList;
	Inventory inventory;
	TransactionHistory transactionHistory;
    LinkedList<Button> removeItemButtons;
    Transaction myTransaction;
    Transaction myTransactionCopy;
    CashierDrawer cashierDrawer;
    Register thisRegister;
    RegisterDrawer registerDrawer;

    boolean validCashier;
    Cashier thisCashier;
    Button cashierLoginButton;
    Button cashierLogoutButton;
//    Button printReportButton;
    Button closeRegisterButton;
    Button newTransactionButton;
    Button itemReturnButton;

    @Override
    protected void closeWindow()
	{
//		stage.close();
	}

    void disableRegisterButtons()
    {
    	cashierLoginButton.setDisable(true);
    	cashierLogoutButton.setDisable(true);
//    	printReportButton.setDisable(true);
//    	closeRegisterButton.setDisable(true);
    	newTransactionButton.setDisable(true);
    	itemReturnButton.setDisable(true);
    }

    void enableRegisterButtons()
    {
    	if (validCashier == false)
    	{
    		cashierLoginButton.setDisable(false);
    	}
    	cashierLogoutButton.setDisable(false);
//    	printReportButton.setDisable(false);
//    	closeRegisterButton.setDisable(false);
    	newTransactionButton.setDisable(false);
    	itemReturnButton.setDisable(false);
    }

    void loginCashier()
    {

    	cashierDrawer = new CashierDrawer();
    	cashierDrawer.cashier = thisCashier;
    	cashierDrawer.register = thisRegister;
    	cashierDrawer.loginTime = DateAndTime.getDateAndTime();

    	validCashier = true;
    	cashierLoginButton.setDisable(true);
    	cashierLogoutButton.setDisable(false);
    	closeRegisterButton.setDisable(true);
    }

    void logoutCashier()
    {
    	cashierDrawer.logoutTime = DateAndTime.getDateAndTime();
    	cashierDrawer.writeToFile();

    	validCashier = false;
    	cashierLoginButton.setDisable(false);
    	cashierLogoutButton.setDisable(true);
    	closeRegisterButton.setDisable(false);
    }

    void closeRegister()
    {
    	stage.close();
    	registerDrawer.logoutTime = DateAndTime.getDateAndTime();
    	registerDrawer.writeToFile();
    }

    public RegisterWindow(Register inputRegister,
    		              RegisterDrawer inputRegisterDrawer,
    		              Inventory inputInventory,
    		              UsersList inputUserList,
    		              TransactionHistory inputTransactionHistory)
    {
    	super(false);
    	inventory = inputInventory;
    	usersList = inputUserList;
    	transactionHistory = inputTransactionHistory;
    	thisCashier = new Cashier();
		thisRegister = inputRegister;
		registerDrawer = inputRegisterDrawer;
    	validCashier = false;
    	buildStage(false);
		stage.setTitle("Register");
    }

    private EventHandler<ActionEvent> removeItemTransaction(int itemIndex)
    {
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
//                for (int i = 0; i < removeItemButtons.size(); i++)
//                {
//                    if (event.getSource() == removeItemButtons.get(i))
//                    {
            			inventory.buyItem(myTransaction.items.get(itemIndex));
                    	myTransaction.items.remove(itemIndex);
                        mainLayout.setRight(createTransaction());
                        stage.sizeToScene();
//                    }
//                }
            }
        };
    }

    private EventHandler<ActionEvent> removeItemItemReturn(int itemIndex)
    {
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
            	myTransaction.items.remove(itemIndex);
                mainLayout.setRight(itemReturn(myTransaction));
                stage.sizeToScene();
            }
        };
    }

    private EventHandler<ActionEvent> addItem()
    {
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
//                switch ((int)(Math.random() * ((5) + 1)))
//                {
//                    case 0:
//                        mySampleItems.add(new Item("83nf8", 1.95,  "banana"));
//                        break;
//                    case 1:
//                        mySampleItems.add(new Item("asbp9", 22.15, "pretzels"));
//                        break;
//                    case 2:
//                        mySampleItems.add(new Item("e8hen", 12.05, "potato"));
//                        break;
//                    case 3:
//                        mySampleItems.add(new Item("sd0v8", 7.35,  "shirt"));
//                        break;
//                    default:
//                        mySampleItems.add(new Item("sav8h", 2.77,  "crayons"));
//                        break;
//                }
            	InventoryWindow testInventory = new InventoryWindow(true, false, inventory);
            	Item thisItem = (Item)testInventory.buildStage(true);
            	if (thisItem != null)
            	{
	            	inventory.sellItem(thisItem);
	            	myTransaction.items.add(thisItem);
	                mainLayout.setRight(createTransaction());
	                stage.sizeToScene();
            	}
            }
        };
    }

    protected GridPane createTransaction()
    {
    	disableRegisterButtons();

    	GridPane myGridPane = new GridPane();

    	if (myTransaction == null)
    	{
//    		mySampleItems = new LinkedList<>();
    		removeItemButtons = new LinkedList<>();
    		myTransaction = new Transaction();

    		myTransaction.setDate(DateAndTime.getDateAndTime());
    		myTransaction.setCashier(thisCashier);
    		myTransaction.setRegister(thisRegister);
    		myTransaction.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 10));
    	}

		int index = 0;

		//cashier
		Label cashierNameTitle = new Label("Cashier Name:");
		cashierNameTitle.setStyle("-fx-font-weight: bold");
		Label cashierValue = new Label(thisCashier.getName());
		GridPane.setConstraints(cashierNameTitle, 0, index++);
		GridPane.setMargin(cashierNameTitle, new Insets(5, 5, 0, 5));
		myGridPane.getChildren().add(cashierNameTitle);
		GridPane.setConstraints(cashierValue, 0, index++);
		GridPane.setMargin(cashierValue, new Insets(0, 5, 5, 5));
		myGridPane.getChildren().add(cashierValue);

		//cashier ID
		Label cashierIDTitle = new Label("Cashier ID:");
		cashierIDTitle.setStyle("-fx-font-weight: bold");
		Label cashierIDValue = new Label(thisCashier.getId());
		GridPane.setConstraints(cashierIDTitle, 0, index++);
		GridPane.setMargin(cashierIDTitle, new Insets(5, 5, 0, 5));
		myGridPane.getChildren().add(cashierIDTitle);
		GridPane.setConstraints(cashierIDValue, 0, index++);
		GridPane.setMargin(cashierIDValue, new Insets(0, 5, 5, 5));
		myGridPane.getChildren().add(cashierIDValue);

		//register ID
		Label registerIDtitle = new Label("Register ID:");
		registerIDtitle.setStyle("-fx-font-weight: bold");
		Label registerIDvalue = new Label(thisRegister.getId());
		GridPane.setConstraints(registerIDtitle, 0, index++);
		GridPane.setMargin(registerIDtitle, new Insets(5, 5, 0, 5));
		myGridPane.getChildren().add(registerIDtitle);
		GridPane.setConstraints(registerIDvalue, 0, index++);
		GridPane.setMargin(registerIDvalue, new Insets(0, 5, 5, 5));
		myGridPane.getChildren().add(registerIDvalue);

		//transaction ID
		Label transactionrIDtitle = new Label("Transaction ID:");
		transactionrIDtitle.setStyle("-fx-font-weight: bold");
		Label transactionIDvalue = new Label(myTransaction.getId());
		GridPane.setConstraints(transactionrIDtitle, 0, index++);
		GridPane.setMargin(transactionrIDtitle, new Insets(5, 5, 0, 5));
		myGridPane.getChildren().add(transactionrIDtitle);
		GridPane.setConstraints(transactionIDvalue, 0, index++);
		GridPane.setMargin(transactionIDvalue, new Insets(0, 5, 5, 5));
		myGridPane.getChildren().add(transactionIDvalue);

		//date
		Label dateTitle = new Label("Date:");
		dateTitle.setStyle("-fx-font-weight: bold");
		Label dateValue = new Label(myTransaction.getDate());
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

		for (int i = 0; i < myTransaction.items.size(); i++)
		{
			Label itemName = new Label(myTransaction.items.get(i).getName());
			GridPane.setConstraints(itemName, 0, index);
			GridPane.setMargin(itemName, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemName);
			Label itemCost = new Label(String.format("%.2f", myTransaction.items.get(i).getPrice()));
			GridPane.setConstraints(itemCost, 1, index);
			GridPane.setMargin(itemCost, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemCost);
			Label itemID = new Label(myTransaction.items.get(i).getId());
			GridPane.setConstraints(itemID, 2, index);
			GridPane.setMargin(itemID, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemID);

			action = removeItemTransaction(i);
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

		for (Item item : myTransaction.items)
		{
			transactionTotalPrice += item.getPrice();
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
//			newTransactionButton.setDisable(false);
//			itemReturnButton.setDisable(false);
			inventory.writeFile();
			cashierDrawer.transactionList.add(myTransaction);
			transactionHistory.addTransaction(myTransaction);
			transactionHistory.writeToFile();
			registerDrawer.transactionList.add(myTransaction);
			enableRegisterButtons();
			mainLayout.setRight(null);
	        stage.sizeToScene();
		});
        GridPane.setConstraints(completeTransactionButton, 0, index);
        GridPane.setMargin(completeTransactionButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(completeTransactionButton);
        if (myTransaction.items.size() == 0)
        {
        	completeTransactionButton.setDisable(true);
        }

        //cancel transaction
        Button cancelTransactionButton = new Button("Cancel Transaction");
        cancelTransactionButton.setOnAction(e ->
        {
//        	newTransactionButton.setDisable(false);
//        	itemReturnButton.setDisable(false);
        	for (Item item : myTransaction.items)
			{
				inventory.buyItem(item);
			}
        	enableRegisterButtons();
        	mainLayout.setRight(null);
            stage.sizeToScene();
        });
        GridPane.setConstraints(cancelTransactionButton, 1, index++);
        GridPane.setMargin(cancelTransactionButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(cancelTransactionButton);

		myGridPane.setStyle("-fx-border-color: black");

		return myGridPane;
    }

    protected GridPane itemReturn(Transaction transaction)
    {
    	int verticalIndex = 0;
    	int horizontalIndex = 0;

    	disableRegisterButtons();

    	GridPane myGridPane = new GridPane();

    	if (transaction == null)
    	{
	    	//transaction id label
	        Label transactionIDtitle = new Label("Transaction ID:");
	        GridPane.setConstraints(transactionIDtitle, horizontalIndex++, verticalIndex);
	        GridPane.setMargin(transactionIDtitle, new Insets(5, 5, 5, 5));
	        myGridPane.getChildren().add(transactionIDtitle);

	        //transaction id textfield
			TextField transactionID = new TextField();
			transactionID.setPromptText("transaction ID");
			GridPane.setConstraints(transactionIDtitle, horizontalIndex++, verticalIndex++);
	        GridPane.setMargin(transactionIDtitle, new Insets(5, 5, 5, 5));
	        myGridPane.getChildren().add(transactionID);

	        horizontalIndex = 0;

	        //transaction id button
	        Button transactionIDbutton = new Button("OK");
	        transactionIDbutton.setOnAction(e ->
	        {
	        	// get the transaction, repaint this screen
//	        	myTransaction = new Transaction();
//	        	myTransaction.setCashier(new Cashier("some guy", "abcd"));
//	        	myTransaction.setRegister(new Register("112233", "", ""));
//	        	myTransaction.setId("111222333");
//	        	myTransaction.setDate("today");
//	        	for (int i = 0; i < inventory.prod_list.size() && i < 3; i++)
//	        	{
//		        	myTransaction.items.add(inventory.prod_list.get(i).getItem());
//	        	}
	        	for (Transaction tempTransaction : transactionHistory.getTransactions())
				{
					if (tempTransaction.getId().equals(transactionID.getText()))
					{
						myTransaction = tempTransaction.copy();
						myTransactionCopy = tempTransaction.copy();
						myTransaction.returnTransaction = true;
						myTransaction.getCashier().setName(thisCashier.getName());
						myTransaction.getCashier().setId(thisCashier.getId());

			        	mainLayout.setRight(itemReturn(myTransaction));
			        	stage.sizeToScene();
					}
				}
	        });
	        GridPane.setConstraints(transactionIDbutton, horizontalIndex, verticalIndex++);
	        GridPane.setMargin(transactionIDbutton, new Insets(5, 5, 5, 5));
	        myGridPane.getChildren().add(transactionIDbutton);

	        //transaction id cancel button
	        Button transactionIDcancelButton = new Button("Cancel");
	        transactionIDcancelButton.setOnAction(e ->
	        {
	        	enableRegisterButtons();
            	mainLayout.setRight(null);
                stage.sizeToScene();
	        });
	        GridPane.setConstraints(transactionIDcancelButton, horizontalIndex, verticalIndex);
	        GridPane.setMargin(transactionIDcancelButton, new Insets(5, 5, 5, 5));
	        myGridPane.getChildren().add(transactionIDcancelButton);
    	}
    	else
    	{
    		int index = 0;

    		//cashier
    		Label cashierNameTitle = new Label("Cashier Name:");
    		cashierNameTitle.setStyle("-fx-font-weight: bold");
    		Label cashierValue = new Label(thisCashier.getName());
    		GridPane.setConstraints(cashierNameTitle, 0, index++);
    		GridPane.setMargin(cashierNameTitle, new Insets(5, 5, 0, 5));
    		myGridPane.getChildren().add(cashierNameTitle);
    		GridPane.setConstraints(cashierValue, 0, index++);
    		GridPane.setMargin(cashierValue, new Insets(0, 5, 5, 5));
    		myGridPane.getChildren().add(cashierValue);

    		//cashier ID
    		Label cashierIDTitle = new Label("Cashier ID:");
    		cashierIDTitle.setStyle("-fx-font-weight: bold");
    		Label cashierIDValue = new Label(thisCashier.getId());
    		GridPane.setConstraints(cashierIDTitle, 0, index++);
    		GridPane.setMargin(cashierIDTitle, new Insets(5, 5, 0, 5));
    		myGridPane.getChildren().add(cashierIDTitle);
    		GridPane.setConstraints(cashierIDValue, 0, index++);
    		GridPane.setMargin(cashierIDValue, new Insets(0, 5, 5, 5));
    		myGridPane.getChildren().add(cashierIDValue);

    		//register ID
    		Label registerIDtitle = new Label("Register ID:");
    		registerIDtitle.setStyle("-fx-font-weight: bold");
    		Label registerIDvalue = new Label(thisRegister.getId());
    		GridPane.setConstraints(registerIDtitle, 0, index++);
    		GridPane.setMargin(registerIDtitle, new Insets(5, 5, 0, 5));
    		myGridPane.getChildren().add(registerIDtitle);
    		GridPane.setConstraints(registerIDvalue, 0, index++);
    		GridPane.setMargin(registerIDvalue, new Insets(0, 5, 5, 5));
    		myGridPane.getChildren().add(registerIDvalue);

    		//transaction ID
    		Label transactionrIDtitle = new Label("Transaction ID:");
    		transactionrIDtitle.setStyle("-fx-font-weight: bold");
    		Label transactionIDvalue = new Label(myTransaction.getId());
    		GridPane.setConstraints(transactionrIDtitle, 0, index++);
    		GridPane.setMargin(transactionrIDtitle, new Insets(5, 5, 0, 5));
    		myGridPane.getChildren().add(transactionrIDtitle);
    		GridPane.setConstraints(transactionIDvalue, 0, index++);
    		GridPane.setMargin(transactionIDvalue, new Insets(0, 5, 5, 5));
    		myGridPane.getChildren().add(transactionIDvalue);

    		//date
    		Label dateTitle = new Label("Date:");
    		dateTitle.setStyle("-fx-font-weight: bold");
    		Label dateValue = new Label(myTransaction.getDate());
    		GridPane.setConstraints(dateTitle, 0, index++);
    		GridPane.setMargin(dateTitle, new Insets(5, 5, 0, 5));
    		myGridPane.getChildren().add(dateTitle);
    		GridPane.setConstraints(dateValue, 0, index++);
    		GridPane.setMargin(dateValue, new Insets(0, 5, 5, 5));
    		myGridPane.getChildren().add(dateValue);

    		//items
//    		EventHandler<ActionEvent> action = addItem();
//    		Button addItem = new Button("Add Item");
//    		addItem.setOnAction(action);
//    		GridPane.setConstraints(addItem, 0, index++);
//    		GridPane.setMargin(addItem, new Insets(5, 5, 5, 5));
//    		myGridPane.getChildren().add(addItem);
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

    		for (int i = 0; i < myTransaction.items.size(); i++)
    		{
    			Label itemName = new Label(myTransaction.items.get(i).getName());
    			GridPane.setConstraints(itemName, 0, index);
    			GridPane.setMargin(itemName, new Insets(5, 5, 5, 5));
    			myGridPane.getChildren().add(itemName);
    			Label itemCost = new Label(String.format("%.2f", -1 * myTransaction.items.get(i).getPrice()));
    			GridPane.setConstraints(itemCost, 1, index);
    			GridPane.setMargin(itemCost, new Insets(5, 5, 5, 5));
    			myGridPane.getChildren().add(itemCost);
    			Label itemID = new Label(myTransaction.items.get(i).getId());
    			GridPane.setConstraints(itemID, 2, index);
    			GridPane.setMargin(itemID, new Insets(5, 5, 5, 5));
    			myGridPane.getChildren().add(itemID);

    			EventHandler<ActionEvent> action = removeItemItemReturn(i);
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

    		for (Item item : myTransaction.items)
    		{
    			transactionTotalPrice += item.getPrice();
    		}

    		Label transactionTotalValue = new Label(String.format("%.2f", -1 * transactionTotalPrice));
    		transactionTotalValue.setStyle("-fx-font-weight: bold");
    		GridPane.setConstraints(transactionTotalValue, 1, index++);
    		GridPane.setMargin(transactionTotalValue, new Insets(5, 5, 5, 5));
    		myGridPane.getChildren().add(transactionTotalValue);

    		//complete transaction
    		Button completeItemReturnButton = new Button("Complete Item Return");
    		completeItemReturnButton.setOnAction(e ->
    		{
//    			newTransactionButton.setDisable(false);
//    			itemReturnButton.setDisable(false);
    			for (Item item : myTransaction.items)	//return items to inventory
				{
					inventory.buyItem(item);
				}

    			inventory.writeFile();

    			transactionHistory.removeTransaction(myTransactionCopy);	//remove transaction from history

    			for (Item item : myTransaction.items)	//remove items from transaction copy
				{
					myTransactionCopy.items.remove(item);
				}

    			if (myTransactionCopy.items.size() > 0)	//if there are still items in the transaction copy, place the remainder in the transaction history
    			{
    				transactionHistory.addTransaction(myTransactionCopy);
    			}

    			transactionHistory.writeToFile();

    			myTransaction.returnTransaction = true;
    			cashierDrawer.transactionList.add(myTransaction);	//record the return transaction
    			registerDrawer.transactionList.add(myTransaction);

    			enableRegisterButtons();
    			mainLayout.setRight(null);
    	        stage.sizeToScene();
    		});
            GridPane.setConstraints(completeItemReturnButton, 0, index);
            GridPane.setMargin(completeItemReturnButton, new Insets(5, 5, 5, 5));
            myGridPane.getChildren().add(completeItemReturnButton);

            //cancel transaction
            Button cancelItemReturnButton = new Button("Cancel Item Return");
            cancelItemReturnButton.setOnAction(e ->
            {
//            	newTransactionButton.setDisable(false);
//            	itemReturnButton.setDisable(false);
            	enableRegisterButtons();
            	mainLayout.setRight(null);
                stage.sizeToScene();
            });
            GridPane.setConstraints(cancelItemReturnButton, 1, index++);
            GridPane.setMargin(cancelItemReturnButton, new Insets(5, 5, 5, 5));
            myGridPane.getChildren().add(cancelItemReturnButton);

    		myGridPane.setStyle("-fx-border-color: black");
    	}

    	return myGridPane;
    }

    @Override
    protected VBox createTopPane()
	{
//		Menu menu0 = new Menu("File");
//
//		MenuItem menuItem = new MenuItem("Exit");
//		menuItem.setOnAction(e -> closeWindow());
//		menu0.getItems().add(menuItem);
//
//		MenuBar menuBar = new MenuBar();
//
//		menuBar.getMenus().addAll(menu0);
//
//		VBox myVBox = new VBox();
//		myVBox.setPadding(new Insets(0, 0, 0, 0));
//
//		myVBox.getChildren().addAll(menuBar);
//
//		return myVBox;
    	return null;
	}

    @Override
	protected GridPane createLeftPane()
	{
    	GridPane myGridPane = new GridPane();

    	int index = 0;

        //id
        Label registerIDtitle = new Label("Register ID:");
        registerIDtitle.setStyle("-fx-font-weight: bold");
        Label registerIDvalue = new Label(thisRegister.getId());
        GridPane.setConstraints(registerIDtitle, 0, index++);
        GridPane.setMargin(registerIDtitle, new Insets(5, 5, 0, 5));
        myGridPane.getChildren().add(registerIDtitle);
        GridPane.setConstraints(registerIDvalue, 0, index++);
        GridPane.setMargin(registerIDvalue, new Insets(0, 5, 5, 5));
        myGridPane.getChildren().add(registerIDvalue);

        //model
        Label registerModelTitle = new Label("Register Model:");
        registerModelTitle.setStyle("-fx-font-weight: bold");
        Label registerModelValue = new Label(thisRegister.getModel());
        GridPane.setConstraints(registerModelTitle, 0, index++);
        GridPane.setMargin(registerModelTitle, new Insets(5, 5, 0, 5));
        myGridPane.getChildren().add(registerModelTitle);
        GridPane.setConstraints(registerModelValue, 0, index++);
        GridPane.setMargin(registerModelValue, new Insets(0, 5, 5, 5));
        myGridPane.getChildren().add(registerModelValue);

        //vendor
        Label registerVendorTitle = new Label("Register Vendor:");
        registerVendorTitle.setStyle("-fx-font-weight: bold");
        Label registerVendorValue = new Label(thisRegister.getVendor());
        GridPane.setConstraints(registerVendorTitle, 0, index++);
        GridPane.setMargin(registerVendorTitle, new Insets(5, 5, 0, 5));
        myGridPane.getChildren().add(registerVendorTitle);
        GridPane.setConstraints(registerVendorValue, 0, index++);
        GridPane.setMargin(registerVendorValue, new Insets(0, 5, 5, 5));
        myGridPane.getChildren().add(registerVendorValue);

        //cashier name
        Label cashierNameTitle = new Label("Cashier Name:");
        cashierNameTitle.setStyle("-fx-font-weight: bold");
        Label cashierNamevalue = new Label(thisCashier.getName());
        GridPane.setConstraints(cashierNameTitle, 0, index++);
        GridPane.setMargin(cashierNameTitle, new Insets(5, 5, 0, 5));
        myGridPane.getChildren().add(cashierNameTitle);
        GridPane.setConstraints(cashierNamevalue, 0, index++);
        GridPane.setMargin(cashierNamevalue, new Insets(0, 5, 5, 5));
        myGridPane.getChildren().add(cashierNamevalue);

        //cashier id
        Label cashierIDTitle = new Label("Cashier ID:");
        cashierIDTitle.setStyle("-fx-font-weight: bold");
        Label cashierIDvalue = new Label(thisCashier.getId());
        GridPane.setConstraints(cashierIDTitle, 0, index++);
        GridPane.setMargin(cashierIDTitle, new Insets(5, 5, 0, 5));
        myGridPane.getChildren().add(cashierIDTitle);
        GridPane.setConstraints(cashierIDvalue, 0, index++);
        GridPane.setMargin(cashierIDvalue, new Insets(0, 5, 5, 5));
        myGridPane.getChildren().add(cashierIDvalue);

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
        	CashierCheck userCheck = new CashierCheck();

        	thisCashier = (Cashier)userCheck.buildStage(true);

    		if (thisCashier != null)
    		{
    			mainLayout.setLeft(createLeftPane());
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
        	thisCashier = new Cashier();
        	mainLayout.setLeft(createLeftPane());
        	disableRegisterButtons();
        	closeRegisterButton.setDisable(false);
        	logoutCashier();
        });
        GridPane.setConstraints(cashierLogoutButton, 0, index++);
        GridPane.setMargin(cashierLogoutButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(cashierLogoutButton);

//        printReportButton = new Button("Print Report");
//        GridPane.setConstraints(printReportButton, 0, index++);
//        GridPane.setMargin(printReportButton, new Insets(5, 5, 5, 5));
//        myGridPane.getChildren().add(printReportButton);

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
        	myTransaction = null;
        	mainLayout.setRight(createTransaction());
            stage.sizeToScene();
        });
        GridPane.setConstraints(newTransactionButton, 0, index++);
        GridPane.setMargin(newTransactionButton, new Insets(25, 5, 5, 5));
        myGridPane.getChildren().add(newTransactionButton);

        itemReturnButton = new Button("Item Return");
        itemReturnButton.setOnAction(e ->
        {
        	mainLayout.setRight(itemReturn(null));
            stage.sizeToScene();
        });
        GridPane.setConstraints(itemReturnButton, 0, index++);
        GridPane.setMargin(itemReturnButton, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(itemReturnButton);

        disableRegisterButtons();
        cashierLoginButton.setDisable(false);
        closeRegisterButton.setDisable(false);

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
