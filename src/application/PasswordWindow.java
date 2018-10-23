package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public abstract class PasswordWindow extends BaseWindow
{
	protected Label instructionsLabel;
	protected TextField usernameInput;
	protected TextField passwordInput;

	public PasswordWindow(String title)
	{
		super(false);

		if (title != null)
		{
			instructionsLabel = new Label(title);
			instructionsLabel.setFont(new Font("Courier New", 12));
		}
	}

	protected abstract void checkLogin();

	@Override
	protected VBox createTopPane()
	{
		if (instructionsLabel != null)
		{
			VBox myVBox = new VBox();
			myVBox.setPadding(new Insets(10, 10, 10, 10));
			myVBox.setAlignment(Pos.CENTER);

			myVBox.getChildren().addAll(instructionsLabel);

			return myVBox;
		}
		else
		{
			return null;
		}
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
		usernameInput = new TextField();
		usernameInput.setPromptText("type: banana");
		Label passwordLabel = new Label("Password:");
		passwordInput = new TextField();
		passwordInput.setPromptText("type: apple");
		Button loginButton = new Button("Log In");
		loginButton.setOnAction(e ->
		{
			checkLogin();
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
