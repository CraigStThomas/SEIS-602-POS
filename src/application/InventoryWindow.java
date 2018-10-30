package application;

import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class InventoryWindow extends BaseWindow
{
	Inventory inventory;
	boolean answerRequested;
	boolean refreshRequested;
	LinkedList<Button> itemButtons;

	public InventoryWindow(boolean answerWanted, boolean refreshWanted, Inventory inputInventory)
	{
		super(false);

		inventory = inputInventory;

		answerRequested = answerWanted;
		refreshRequested = refreshWanted;

		if (answerRequested)
		{
			itemButtons = new LinkedList<>();
		}
		else
		{
			buildStage(false);
			stage.setTitle("Inventory");
		}
//		buildStage(false);
//		stage.setTitle("Inventory");
	}

	private EventHandler<ActionEvent> removeProduct(int productIndex)
    {
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
            	inventory.prod_list.remove(productIndex);
            	mainLayout.setCenter(createCenterPane());
            	stage.sizeToScene();
            }
        };
    }

	private EventHandler<ActionEvent> pickMe()
    {
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                for (int i = 0; i < itemButtons.size(); i++)
                {
                    if (event.getSource() == itemButtons.get(i))
                    {
                    	answer = inventory.prod_list.get(i).getItem();
                    	stage.close();
                    }
                }
            }
        };
    }

	@Override
	protected VBox createTopPane() {return null;}

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

		for (int i = 0; i < inventory.prod_list.size(); i++)
		{
			horizontalIndex = 0;

			Label itemName = new Label(inventory.prod_list.get(i).getItem().getName());
			GridPane.setConstraints(itemName, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemName, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemName);

			Label itemCost = new Label(Double.toString(inventory.prod_list.get(i).getItem().getPrice()));
			GridPane.setConstraints(itemCost, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemCost, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemCost);

			Label itemID = new Label(inventory.prod_list.get(i).getItem().getId());
			GridPane.setConstraints(itemID, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemID, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemID);

			Label itemQuantity = new Label(Integer.toString(inventory.prod_list.get(i).getQty()));
			GridPane.setConstraints(itemQuantity, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemQuantity, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemQuantity);

			Label itemThreshold = new Label(Integer.toString(inventory.prod_list.get(i).getThreshold()));
			GridPane.setConstraints(itemThreshold, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemThreshold, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemThreshold);

			Label itemSupplier = new Label(inventory.prod_list.get(i).getSupplier());
			GridPane.setConstraints(itemSupplier, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemSupplier, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemSupplier);

			if (answerRequested)
			{
				EventHandler<ActionEvent> action = pickMe();
				Button itemButton = new Button("pick me");
				itemButton.setOnAction(action);
				itemButtons.add(itemButton);
				GridPane.setConstraints(itemButton, horizontalIndex++, verticalIndex);
				GridPane.setMargin(itemButton, new Insets(5, 5, 5, 5));
				myGridPane.getChildren().add(itemButton);
				if (inventory.prod_list.get(i).getQty() <= 0)
				{
					itemButton.setDisable(true);
				}
			}
			else
			{
				EventHandler<ActionEvent> action = removeProduct(i);
				Button removeProductButton = new Button("Remove Product");
				removeProductButton.setOnAction(action);
				GridPane.setConstraints(removeProductButton, horizontalIndex++, verticalIndex);
				GridPane.setMargin(removeProductButton, new Insets(5, 5, 5, 5));
				myGridPane.getChildren().add(removeProductButton);
			}

			verticalIndex++;
		}

		if (refreshRequested)
		{
			Button refreshButton = new Button("Refresh\nInventory");
			refreshButton.setOnAction(e ->
			{
				mainLayout.setCenter(createCenterPane());
				stage.sizeToScene();
			});
			GridPane.setConstraints(refreshButton, 0, verticalIndex);
			GridPane.setMargin(refreshButton, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(refreshButton);
		}

		return myGridPane;
	}

	@Override
	protected GridPane createRightPane() {return null;}

	@Override
	protected VBox createBottomPane() {return null;}


}
