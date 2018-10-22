package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HomeWindow extends BaseWindow
{
	public HomeWindow()
	{
		super();

		stage.setTitle("Home Window");
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

		Button createUser = new Button("create user");
		createUser.setOnAction(e ->
		{
//			Main.getApplicationWindows().add(new UsersWindow());
		});
		GridPane.setConstraints(createUser, 0, index++);
		GridPane.setMargin(createUser, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(createUser);

		Button viewOrders = new Button("view orders");
		viewOrders.setOnAction(e ->
		{
//			Main.getApplicationWindows().add(new OrdersWindow());
		});
		GridPane.setConstraints(viewOrders, 0, index++);
		GridPane.setMargin(viewOrders, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(viewOrders);

		Button createRegister = new Button("create register");
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
