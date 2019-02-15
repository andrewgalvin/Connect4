package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gameBoard.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Stage primaryStage3 = new Stage();
			Parent playerSelect = FXMLLoader.load(getClass().getClassLoader().getResource("playerSelectConnect4.fxml"));
			Scene scene3 = new Scene(playerSelect);
			scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage3.setScene(scene3);
			primaryStage3.show();
			
			/*Stage primaryStage2 = new Stage();
			Parent startMenu = FXMLLoader.load(getClass().getClassLoader().getResource("startMenu.fxml"));
			Scene scene2 = new Scene(startMenu);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage2.setScene(scene2);
			primaryStage2.show();*/
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
