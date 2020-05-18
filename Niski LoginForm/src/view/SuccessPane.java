package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SuccessPane {

	public static Label idLabel = new Label("Id:");
	public static Label yourIdLabel = new Label();
	
	public static Label nameLabel = new Label("Name:");
	public static Label yourNameLabel = new Label();
	
	public static Label usernameLabel = new Label("Username:");
	public static Label yourUsernameLabel = new Label();
	
	public static Button logoutButton = new Button("Logout");

	public static VBox getSuccessPane() {
		VBox successPane = new VBox();
		setUpButtonActions();
		successPane.getChildren().addAll(idLabel, yourIdLabel, nameLabel, yourNameLabel, usernameLabel, yourUsernameLabel, logoutButton);
		return successPane;
	}

	private static void setUpButtonActions() {
		logoutButton.setOnAction(e -> {
			yourIdLabel.setText("");
			yourNameLabel.setText("");
			yourUsernameLabel.setText("");
			SceneBuilder.THE_PANE.setCenter(MainPane.getMainPane());
		});
	}
	
	
	
}
