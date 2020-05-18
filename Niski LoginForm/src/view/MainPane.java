package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainPane {

	public static Label usernameLabel = new Label("Enter Username:");
	public static TextField usernameTextField = new TextField();
	
	public static Label passwordLabel = new Label("Enter Password:");
	public static PasswordField passwordField = new PasswordField();
	
	public static Button loginButton = new Button("Login");
	public static Button registerButton = new Button("Register New User");
	
	public static VBox getMainPane() {
		VBox mainPane = new VBox();
		setUpButtonActions();
		mainPane.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordField, loginButton, registerButton);
		return mainPane;
	}
	
	private static void setUpButtonActions() {
		loginButton.setOnAction(e -> {
			for(int i = 0; i < SceneBuilder.userList.size(); i++) {
				if(usernameTextField.getText().equals(SceneBuilder.userList.get(i).getUsername()) && passwordField.getText().equals(SceneBuilder.userList.get(i).getPassword())) {
					SceneBuilder.THE_STATUS_BAR.setText("");
					SuccessPane.yourIdLabel.setText(String.valueOf(SceneBuilder.userList.get(i).getId()));
					SuccessPane.yourNameLabel.setText(SceneBuilder.userList.get(i).getName());
					SuccessPane.yourUsernameLabel.setText(SceneBuilder.userList.get(i).getUsername());
					SceneBuilder.THE_PANE.setCenter(SuccessPane.getSuccessPane());
					break;
				} else {
					SceneBuilder.THE_STATUS_BAR.setText("Logging in...? Please check your username and password!");
					continue;
				}
			}
		});
		registerButton.setOnAction(e -> {
			SceneBuilder.THE_PANE.setCenter(RegistrationPane.getRegistrationPane());
		});
	}
	
}
