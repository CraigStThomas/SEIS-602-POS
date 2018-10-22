package application;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PasswordWindow extends BaseWindow
{
	public PasswordWindow(String title)
	{
		super();

		stage.setTitle(title);
		mainLayout.requestFocus();	//this prevents a textfield from defaulting to focus, so we can read the prompt text
	}

	@Override
	protected GridPane createLeftPane()
	{
		return null;
	}

	@Override
	protected GridPane createCenterPane()
	{
		GridPane myGridPane = new GridPane();

		int verticalIndex = 0;
		int horizontalIndex = 0;

		Label usernameLabel = new Label("Username:");
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("type: banana");
		Label passwordLabel = new Label("Password:");
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("type: apple");
		Button loginButton = new Button("Log In");
		loginButton.setOnAction(e ->
		{
			Main.setLoginValid(true);
		});

		horizontalIndex = 0;
		GridPane.setConstraints(usernameLabel, horizontalIndex++, verticalIndex);
        GridPane.setMargin(usernameLabel, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(usernameLabel);
		GridPane.setConstraints(usernameInput, horizontalIndex++, verticalIndex++);
        GridPane.setMargin(usernameInput, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(usernameInput);

        horizontalIndex = 0;
		GridPane.setConstraints(passwordLabel, horizontalIndex++, verticalIndex);
        GridPane.setMargin(passwordLabel, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(passwordLabel);
		GridPane.setConstraints(passwordInput, horizontalIndex, verticalIndex++);
        GridPane.setMargin(passwordInput, new Insets(5, 5, 5, 5));
        myGridPane.getChildren().add(passwordInput);

		GridPane.setConstraints(loginButton, horizontalIndex, verticalIndex);
        GridPane.setMargin(loginButton, new Insets(5, 5, 5, 5));
        GridPane.setHalignment(loginButton, HPos.RIGHT);
        myGridPane.getChildren().add(loginButton);

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
