package application;

import application.Users.User;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class UsersWindow extends BaseWindow
{
	public UsersWindow()
	{
		super();

		stage.setTitle("Users");
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

		Label nameLabel = new Label("Name");
		nameLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(nameLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(nameLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(nameLabel);

		Label usernameLabel = new Label("Username");
		usernameLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(usernameLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(usernameLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(usernameLabel);

		Label passwordLabel = new Label("Password");
		passwordLabel.setStyle("-fx-font-weight: bold");
		GridPane.setConstraints(passwordLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(passwordLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(passwordLabel);

		//admin user
		verticalIndex++;
		horizontalIndex = 0;
		nameLabel = new Label(Users.admin.name);
		nameLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));
		GridPane.setConstraints(nameLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(nameLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(nameLabel);

		usernameLabel = new Label(Users.admin.userName);
		usernameLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));
		GridPane.setConstraints(usernameLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(usernameLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(usernameLabel);

		passwordLabel = new Label(Users.admin.password);
		passwordLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));
		GridPane.setConstraints(passwordLabel, horizontalIndex++, verticalIndex);
		GridPane.setMargin(passwordLabel, new Insets(5, 5, 5, 5));
		myGridPane.getChildren().add(passwordLabel);
		// end if admin user

		for (User user : Users.user)
		{
			horizontalIndex = 0;
			verticalIndex++;

			nameLabel = new Label(user.name);
			GridPane.setConstraints(nameLabel, horizontalIndex++, verticalIndex);
			GridPane.setMargin(nameLabel, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(nameLabel);

			usernameLabel = new Label(user.userName);
			GridPane.setConstraints(usernameLabel, horizontalIndex++, verticalIndex);
			GridPane.setMargin(usernameLabel, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(usernameLabel);

			passwordLabel = new Label(user.password);
			GridPane.setConstraints(passwordLabel, horizontalIndex++, verticalIndex);
			GridPane.setMargin(passwordLabel, new Insets(5, 5, 5, 5));
			myGridPane.getChildren().add(passwordLabel);
		}


		return myGridPane;
	}

	@Override
	protected GridPane createRightPane() {return null;}

	@Override
	protected VBox createBottomPane() {return null;}

}
