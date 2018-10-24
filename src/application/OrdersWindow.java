package application;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OrdersWindow extends BaseWindow
{
	public OrdersWindow()
	{
		super();

		stage.setTitle("Orders");
	}

	@Override
	protected VBox createTopPane() {return null;}

	@Override
	protected GridPane createLeftPane() {return null;}

	@Override
	protected GridPane createCenterPane() {return null;}

	@Override
	protected GridPane createRightPane() {return null;}

	@Override
	protected VBox createBottomPane() {return null;}


}
