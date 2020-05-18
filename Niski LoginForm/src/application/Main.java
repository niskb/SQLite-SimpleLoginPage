package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.SceneBuilder;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Simple Login Page");
			primaryStage.setScene(new SceneBuilder(primaryStage).getScene());
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
