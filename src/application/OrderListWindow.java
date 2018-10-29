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

		Label orderDateLabel = new Label("Order Date");
		orderDateLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(orderDateLabel, horizontalIndex++, verticalIndex++);
		GridPane.setMargin(orderDateLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(orderDateLabel);

		for(int i = 0; i < OrderList.order_list.size(); i++)
		{
			horizontalIndex = 0;

			Label orderID = new Label(OrderList.order_list.get(i).getId());
    		GridPane.setConstraints(orderID, horizontalIndex++, verticalIndex);
    		GridPane.setMargin(orderID, new Insets(5, 5, 5, 5));
    		myGridPane.getChildren().add(orderID);

    		Label orderDate = new Label(OrderList.order_list.get(i).getDate());
    		GridPane.setConstraints(orderDate, horizontalIndex++, verticalIndex);
    		GridPane.setMargin(orderDate, new Insets(5, 5, 5, 5));
    		myGridPane.getChildren().add(orderDate);

    		EventHandler<ActionEvent> action = openOrderWindow(i);
    		Button orderButton = new Button("Open");
    		orderButton.setOnAction(action);
    		GridPane.setConstraints(orderButton, horizontalIndex++, verticalIndex++);
    		GridPane.setMargin(orderButton, new Insets(5, 5, 5, 5));
    		myGridPane.getChildren().add(orderButton);
		}

		return myGridPane;
	}

	@Override
	protected GridPane createRightPane() {return null;}

	@Override
	protected VBox createBottomPane() {return null;}


}