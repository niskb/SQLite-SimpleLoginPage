package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.User;
import utils.SqliteUtils;

public class RegistrationPane {

	public static Label nameLabel = new Label("Enter Name:");
	public static TextField nameTextField = new TextField();

	public static Label usernameLabel = new Label("Enter Username:");
	public static TextField usernameTextField = new TextField();

	public static Label passwordLabel = new Label("Enter Password:");
	public static TextField passwordTextField = new TextField();

	public static Button submitButton = new Button("Submit");
	public static Label statusLabel = new Label("");
	
	public static Button goBackToMainPaneButton = new Button("Go Back to Login");

	public static VBox getRegistrationPane() {
		VBox registrationPane = new VBox();
		setUpButtonActions();
		registrationPane.getChildren().addAll(nameLabel, nameTextField, usernameLabel, usernameTextField, passwordLabel,
				passwordTextField, submitButton, goBackToMainPaneButton, statusLabel);
		return registrationPane;
	}

	private static void setUpButtonActions() {
		submitButton.setOnAction(e -> {
			if (!nameTextField.getText().trim().isEmpty() && !usernameTextField.getText().trim().isEmpty()
					&& !passwordTextField.getText().trim().isEmpty()) {
				User checkedUser = new User("", "", "");
				for (int i = 0; i < SceneBuilder.userList.size(); i++) {
					if (SceneBuilder.userList.get(i).getUsername().equalsIgnoreCase(usernameTextField.getText())) {
						statusLabel.setText("We already have that username registered!");
						checkedUser = SceneBuilder.userList.get(i);
						break;
					}
				}
				if (checkedUser.getId() <= -1) {
					User newUser = new User(nameTextField.getText(), usernameTextField.getText(),
							passwordTextField.getText());
					SceneBuilder.userList.add(newUser);
					SqliteUtils.insertToDatabase(newUser.getId(), newUser.getName(), newUser.getUsername(), newUser.getPassword());
					nameTextField.setText("");
					usernameTextField.setText("");
					passwordTextField.setText("");
					SceneBuilder.THE_PANE.setCenter(MainPane.getMainPane());
				}
			} else {
				statusLabel.setText("Please fill out ALL of the information in the form!");
			}
		});
		goBackToMainPaneButton.setOnAction(e -> {
			nameTextField.setText("");
			usernameTextField.setText("");
			passwordTextField.setText("");
			SceneBuilder.THE_PANE.setCenter(MainPane.getMainPane());
		});
	}

}
