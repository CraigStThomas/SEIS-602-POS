package application;

import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OrderWindow extends BaseWindow
{
	Order order;

	public OrderWindow(Order inputOrder)
	{
		super(false);

		order = inputOrder;
		buildStage(false);
	}

	@Override
	protected VBox createTopPane()
	{
		VBox myVBox = new VBox(5);

		Label orderIDlabel = new Label("Order ID:");
		orderIDlabel.setStyle("-fx-font-weight: bold");

		Label orderIDvalue = new Label(order.getId());

		Label orderDateLabel = new Label("Order Date:");
		orderDateLabel.setStyle("-fx-font-weight: bold");

		Label orderDateValue = new Label(order.getDate());

		myVBox.setPadding(new Insets(5, 5, 5, 5));

		myVBox.getChildren().addAll(orderIDlabel, orderIDvalue, orderDateLabel, orderDateValue);

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

//		Label orderIDlabel = new Label("Order ID:");
//		orderIDlabel.setStyle("-fx-font-weight: bold");
//		GridPane.setConstraints(orderIDlabel, horizontalIndex, verticalIndex++);
//		GridPane.setMargin(orderIDlabel, new Insets(5, 5, 5, 5));
//		myGridPane.getChildren().add(orderIDlabel);
//
//		Label orderIDvalue = new Label(order.getId());
//		GridPane.setConstraints(orderIDvalue, horizontalIndex, verticalIndex++);
//		GridPane.setMargin(orderIDvalue, new Insets(5, 5, 5, 5));
//		myGridPane.getChildren().add(orderIDvalue);
//
//		Label orderDateLabel = new Label("Order Date:");
//		orderDateLabel.setStyle("-fx-font-weight: bold");
//		GridPane.setConstraints(orderDateLabel, horizontalIndex, verticalIndex++);
//		GridPane.setMargin(orderDateLabel, new Insets(5, 5, 5, 5));
//		myGridPane.getChildren().add(orderDateLabel);
//
//		Label orderDateValue = new Label(order.getDate());
//		GridPane.setConstraints(orderDateValue, horizontalIndex, verticalIndex++);
//		GridPane.setMargin(orderDateValue, new Insets(5, 5, 5, 5));
//		myGridPane.getChildren().add(orderDateValue);

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

			Label itemCost = new Label(Double.toString(order.getProductList().get(i).getItem().getPrice()));
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
			Button receiveOrderButton = new Button("Receive\nOrder");
			receiveOrderButton.setOnAction(e ->
			{
				for (int i = 0; i < order.getProductList().size(); i++)
				{
					boolean createNewProduct = true;

					for (int j = 0; j < Inventory.prod_list.size(); j++)
					{
						if (order.getProductList().get(i).equals(Inventory.prod_list.get(j)))
						{
							createNewProduct = false;
							Inventory.prod_list.get(j).setQty(Inventory.prod_list.get(j).getQty() + order.getProductList().get(i).getQty());
							break;
						}
					}

					if (createNewProduct)
					{
						Inventory.addProduct(order.getProductList().get(i));
					}
				}

				order.setOrderReceived(true);
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
