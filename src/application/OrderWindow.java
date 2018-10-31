package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OrderWindow extends BaseWindow
{
	Inventory inventory;
	Order order;
	TextField newOrderItemName;
	TextField newOrderItemCost;
	TextField newOrderItemID;
	TextField newOrderItemQuantity;
	TextField newOrderItemThreshold;
	TextField newOrderItemSupplier;

	public OrderWindow(Order inputOrder, Inventory inputInventory)
	{
		super(false);
		inventory = inputInventory;
		order = inputOrder;
		buildStage(false);
	}

	private void addItemToOrder()
	{
		Item tempItem = new Item(newOrderItemName.getText(), Double.parseDouble(newOrderItemCost.getText()), newOrderItemID.getText());
		Product tempProduct = new Product(tempItem, Integer.parseInt(newOrderItemQuantity.getText()), Integer.parseInt(newOrderItemThreshold.getText()), newOrderItemSupplier.getText());
		order.addProduct(tempProduct);
		mainLayout.setCenter(createCenterPane());
		stage.sizeToScene();
	}

	@Override
	protected VBox createTopPane()
	{
		VBox myVBox = new VBox(5);

		Label orderIDlabel = new Label("Order ID:");
		orderIDlabel.setStyle("-fx-font-weight: bold");

		Label orderIDvalue = new Label(order.getId());

		Label orderDateCreatedLabel = new Label("Order Date Created:");
		orderDateCreatedLabel.setStyle("-fx-font-weight: bold");

		Label orderDateCreatedValue = new Label(order.getDateCreated());

		Label orderDateReceivedLabel = new Label("Order Date Received:");
		orderDateReceivedLabel.setStyle("-fx-font-weight: bold");

		Label orderDateReceivedValue = new Label(order.getDateReceived());

		myVBox.setPadding(new Insets(5, 5, 5, 5));

		myVBox.getChildren().addAll(orderIDlabel, orderIDvalue, orderDateCreatedLabel, orderDateCreatedValue, orderDateReceivedLabel, orderDateReceivedValue);

		return myVBox;
	}

	@Override
	protected GridPane createLeftPane() {return null;}

	@Override
	protected GridPane createCenterPane()
	{
		GridPane myGridPane = new GridPane();

		int verticalIndex = 0;
		int horizontalIndex = 0;

		Label itemNameLabel = new Label("Item Name");
		itemNameLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(itemNameLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(itemNameLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(itemNameLabel);

		Label itemCostLabel = new Label("Item Cost");
		itemCostLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(itemCostLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(itemCostLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(itemCostLabel);

		Label itemIDLabel = new Label("Item ID");
		itemIDLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(itemIDLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(itemIDLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(itemIDLabel);

		Label itemQuantityLabel = new Label("Item Quantity");
		itemQuantityLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(itemQuantityLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(itemQuantityLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(itemQuantityLabel);

		Label itemThresholdLabel = new Label("Item Threshold");
		itemThresholdLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(itemThresholdLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(itemThresholdLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(itemThresholdLabel);

		Label itemSupplierLabel = new Label("Item Supplier");
		itemSupplierLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(itemSupplierLabel, horizontalIndex++, verticalIndex++);
		GridPane.setMargin(itemSupplierLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(itemSupplierLabel);

		for (int i = 0; i < order.getProductList().size(); i++)
		{
			horizontalIndex = 0;

			Label itemName = new Label(order.getProductList().get(i).getItem().getName());
			GridPane.setConstraints(itemName, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemName, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemName);

			Label itemCost = new Label(String.format("%.2f", order.getProductList().get(i).getItem().getPrice()));
			GridPane.setConstraints(itemCost, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemCost, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemCost);

			Label itemID = new Label(order.getProductList().get(i).getItem().getId());
			GridPane.setConstraints(itemID, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemID, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemID);

			Label itemQuantity = new Label(Integer.toString(order.getProductList().get(i).getQty()));
			GridPane.setConstraints(itemQuantity, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemQuantity, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemQuantity);

			Label itemThreshold = new Label(Integer.toString(order.getProductList().get(i).getThreshold()));
			GridPane.setConstraints(itemThreshold, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemThreshold, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemThreshold);

			Label itemSupplier = new Label(order.getProductList().get(i).getSupplier());
			GridPane.setConstraints(itemSupplier, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemSupplier, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemSupplier);

			verticalIndex++;
		}

		if (order.getOrderReceived() == false)
		{

//			TextField newOrderItemName;
//			TextField newOrderItemCost;
//			TextField newOrderItemID;
//			TextField newOrderItemQuantity;
//			TextField newOrderItemSupplier;

			horizontalIndex = 0;

			newOrderItemName = new TextField();
			newOrderItemName.setPromptText("New Item's Name");
			GridPane.setConstraints(newOrderItemName, horizontalIndex++, verticalIndex);
			GridPane.setMargin(newOrderItemName, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(newOrderItemName);

			newOrderItemCost = new TextField();
			newOrderItemCost.setPromptText("New Item's Cost");
			GridPane.setConstraints(newOrderItemCost, horizontalIndex++, verticalIndex);
			GridPane.setMargin(newOrderItemCost, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(newOrderItemCost);

			newOrderItemID = new TextField();
			newOrderItemID.setPromptText("New Item's ID");
			GridPane.setConstraints(newOrderItemID, horizontalIndex++, verticalIndex);
			GridPane.setMargin(newOrderItemID, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(newOrderItemID);

			newOrderItemQuantity = new TextField();
			newOrderItemQuantity.setPromptText("New Item's Quantity");
			GridPane.setConstraints(newOrderItemQuantity, horizontalIndex++, verticalIndex);
			GridPane.setMargin(newOrderItemQuantity, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(newOrderItemQuantity);

			newOrderItemThreshold = new TextField();
			newOrderItemThreshold.setPromptText("New Item's Threshold");
			GridPane.setConstraints(newOrderItemThreshold, horizontalIndex++, verticalIndex);
			GridPane.setMargin(newOrderItemThreshold, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(newOrderItemThreshold);

			newOrderItemSupplier = new TextField();
			newOrderItemSupplier.setPromptText("New Item's Supplier");
			GridPane.setConstraints(newOrderItemSupplier, horizontalIndex++, verticalIndex);
			GridPane.setMargin(newOrderItemSupplier, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(newOrderItemSupplier);

			Button addItemButton = new Button("Add Item");
			addItemButton.setOnAction(e ->
			{
				addItemToOrder();
			});
			GridPane.setConstraints(addItemButton, horizontalIndex++, verticalIndex++);
			GridPane.setMargin(addItemButton, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(addItemButton);

			Button receiveOrderButton = new Button("Receive\nOrder");
			receiveOrderButton.setOnAction(e ->
			{
				for (int i = 0; i < order.getProductList().size(); i++)
				{
					boolean createNewProduct = true;

					for (int j = 0; j < inventory.prod_list.size(); j++)
					{
						if (order.getProductList().get(i).equals(inventory.prod_list.get(j)))
						{
							createNewProduct = false;
							inventory.prod_list.get(j).setQty(inventory.prod_list.get(j).getQty() + order.getProductList().get(i).getQty());
							if (order.getProductList().get(i).getThreshold() >= 0)
							{
								inventory.prod_list.get(j).setThreshold(order.getProductList().get(i).getThreshold());
							}
							break;
						}
					}

					if (createNewProduct)
					{
						inventory.addProduct(order.getProductList().get(i));
					}
				}

				inventory.writeFile();

				order.setOrderReceived(true);
				order.setDateReceived(DateAndTime.getDateAndTime());
				mainLayout.setTop(createTopPane());
				mainLayout.setCenter(createCenterPane());
				stage.sizeToScene();
			});
			GridPane.setConstraints(receiveOrderButton, 0, verticalIndex);
			GridPane.setMargin(receiveOrderButton, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(receiveOrderButton);
		}

		return myGridPane;
	}

	@Override
	protected GridPane createRightPane() {return null;}

	@Override
	protected VBox createBottomPane() {return null;}

}
