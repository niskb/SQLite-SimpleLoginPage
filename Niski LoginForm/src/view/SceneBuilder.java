package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.User;
import utils.SqliteUtils;

public class SceneBuilder {

	public static List<User> userList = new ArrayList<User>();
	
	public static BorderPane THE_PANE = new BorderPane();
	public static Scene THE_SCENE = new Scene(THE_PANE, 480, 240);
	public static Label THE_STATUS_BAR = new Label("This is the login status!");
	
	public SceneBuilder(Stage primaryStage) {
		THE_PANE.setTop(THE_STATUS_BAR);
		THE_PANE.setCenter(MainPane.getMainPane());
	}

	public Scene getScene() {
		SqliteUtils.readAllData();
		return THE_SCENE;
	}
	
	
	
}
