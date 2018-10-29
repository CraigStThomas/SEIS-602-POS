package application;

import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sun.awt.image.ImageWatched.Link;

public class OrderListWindow extends BaseWindow
{
	public OrderListWindow()
	{
		super();

		stage.setTitle("Orders");
	}

	private EventHandler<ActionEvent> openOrderWindow(int index)
    {
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
            	OrderWindow orderWindow = new OrderWindow(OrderList.order_list.get(index));
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
		int horizontalIndex = 0;
		int verticalIndex = 0;

		Label orderIDlabel = new Label("Order ID");
		orderIDlabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(orderIDlabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(orderIDlabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(orderIDlabel);

		Label orderDateCreatedLabel = new Label("Order Date Created");
		orderDateCreatedLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(orderDateCreatedLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(orderDateCreatedLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(orderDateCreatedLabel);

		Label orderDateReceivedLabel = new Label("Order Date Received");
		orderDateReceivedLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(orderDateReceivedLabel, horizontalIndex++, verticalIndex++);
		GridPane.setMargin(orderDateReceivedLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(orderDateReceivedLabel);

		for(int i = 0; i < OrderList.order_list.size(); i++)
		{
			horizontalIndex = 0;

			Label orderID = new Label(OrderList.order_list.get(i).getId());
    		GridPane.setConstraints(orderID, horizontalIndex++, verticalIndex);
    		GridPane.setMargin(orderID, new Insets(5, 5, 5, 5));
    		myGridPane.getChildren().add(orderID);

    		Label orderDateCreated = new Label(OrderList.order_list.get(i).getDateCreated());
    		GridPane.setConstraints(orderDateCreated, horizontalIndex++, verticalIndex);
    		GridPane.setMargin(orderDateCreated, new Insets(5, 5, 5, 5));
    		myGridPane.getChildren().add(orderDateCreated);

    		Label orderDateReceived = new Label(OrderList.order_list.get(i).getDateReceived());
    		GridPane.setConstraints(orderDateReceived, horizontalIndex++, verticalIndex);
    		GridPane.setMargin(orderDateReceived, new Insets(5, 5, 5, 5));
    		myGridPane.getChildren().add(orderDateReceived);

    		EventHandler<ActionEvent> action = openOrderWindow(i);
    		Button orderButton = new Button("Open");
    		orderButton.setOnAction(action);
    		GridPane.setConstraints(orderButton, horizontalIndex++, verticalIndex++);
    		GridPane.setMargin(orderButton, new Insets(5, 5, 5, 5));
    		myGridPane.getChildren().add(orderButton);
		}

		Button newOrderButton = new Button("New Order");
		newOrderButton.setOnAction(e ->
		{
			OrderList.order_list.add(new Order());
			mainLayout.setCenter(createCenterPane());
			stage.sizeToScene();
		});
		GridPane.setConstraints(newOrderButton, 0, verticalIndex++);
		GridPane.setMargin(newOrderButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(newOrderButton);

		Button refreshButton = new Button("Refresh\nOrders");
		refreshButton.setOnAction(e ->
		{
			mainLayout.setCenter(createCenterPane());
			stage.sizeToScene();
		});
		GridPane.setConstraints(refreshButton, 0, verticalIndex++);
		GridPane.setMargin(refreshButton, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(refreshButton);

		return myGridPane;
	}

	@Override
	protected GridPane createRightPane() {return null;}

	@Override
	protected VBox createBottomPane() {return null;}


}