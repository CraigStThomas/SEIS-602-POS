package application;

import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class InventoryWindow extends BaseWindow
{
	public InventoryWindow()
	{
		super();

		stage.setTitle("Inventory");
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

		for (Map.Entry<Item, Integer> entry : Inventory.item.entrySet())
		{
			horizontalIndex = 0;
			verticalIndex++;

		    Item key = entry.getKey();
		    Integer value = entry.getValue();

		    itemNameLabel = new Label(key.itemName);
			GridPane.setConstraints(itemNameLabel, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemNameLabel, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemNameLabel);

			itemCostLabel = new Label(String.format("%.2f", key.itemCost));
			GridPane.setConstraints(itemCostLabel, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemCostLabel, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemCostLabel);

			itemIDLabel = new Label(key.itemID);
			GridPane.setConstraints(itemIDLabel, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemIDLabel, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemIDLabel);

			itemQuantityLabel = new Label(value.toString());
			GridPane.setConstraints(itemQuantityLabel, horizontalIndex++, verticalIndex);
			GridPane.setMargin(itemQuantityLabel, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(itemQuantityLabel);
		}


		return myGridPane;
	}

	@Override
	protected GridPane createRightPane() {return null;}

	@Override
	protected VBox createBottomPane() {return null;}


}
