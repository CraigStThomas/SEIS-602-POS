
package application;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Main extends Application
{
	private static LinkedList<BaseWindow> applicationWindows = new LinkedList<>();
	private static boolean loginValid = false;
	private static String usernameAdmin = "banana";
	private static String passwordAdmin = "apple";

	static boolean checkUsernameAdmin(String inputString)
	{
		boolean returnValue = false;

		if (inputString.equals(usernameAdmin))
		{
			returnValue = true;
		}

		return returnValue;
	}

	static boolean checkPasswordAdmin(String inputString)
	{
		boolean returnValue = false;

		if (inputString.equals(passwordAdmin))
		{
			returnValue = true;
		}

		return returnValue;
	}

	public static LinkedList<BaseWindow> getApplicationWindows()
	{
		return applicationWindows;
	}

	public static void setLoginValid(boolean status)
	{
		loginValid = status;

		applicationWindows.get(0).closeWindow();
		applicationWindows.remove(0);
		applicationWindows.add(new HomeWindow());
	}

	@Override
	public void start(Stage primaryStage)
	{
		applicationWindows.add(new HomeWindow());
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
