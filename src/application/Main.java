package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application{
		
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent playerSelect = FXMLLoader.load(getClass().getClassLoader().getResource("playerSelect.fxml"));
			Scene scene3 = new Scene(playerSelect);
			scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene3);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Welcome to Connect 4!");
			primaryStage.show();		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
