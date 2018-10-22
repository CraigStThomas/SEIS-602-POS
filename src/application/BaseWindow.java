package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class BaseWindow
{
	protected Stage stage;
	protected Scene scene;
	protected BorderPane mainLayout;

	protected VBox topPane;

	protected GridPane leftPane;
	protected GridPane centerPane;
	protected GridPane rightPane;
	protected VBox bottomPane;

	protected abstract GridPane createLeftPane();
	protected abstract GridPane createCenterPane();
	protected abstract GridPane createRightPane();
	protected abstract VBox     createBottomPane();

	protected void closeWindow()
	{
		stage.close();
	}

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

	public BaseWindow()
	{
		stage = new Stage();
		mainLayout = new BorderPane();

		// create each pane for mainLayout
		topPane = createTopPane();
		leftPane = createLeftPane();
		centerPane = createCenterPane();
		rightPane = createRightPane();
		bottomPane = createBottomPane();
		// end of pane creation

		mainLayout.setTop(topPane);
		mainLayout.setLeft(leftPane);
		mainLayout.setCenter(centerPane);
		mainLayout.setRight(rightPane);
		mainLayout.setBottom(bottomPane);


		scene = new Scene(mainLayout);
		stage.setOnCloseRequest(e ->
		{
			e.consume(); // consumes the request to close the window, we are going to handle it manually
			closeWindow();
		});
		stage.setTitle("Base Window");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

}
