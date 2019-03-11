package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {
	
	@FXML private Button startGameButton;
	@FXML private TextField yellowName;
	@FXML private TextField redName;
	@FXML private Label errorNameLabel;
	
	public static String player1Name;
	public static String player2Name;
	
	public void startGameButtonClicked() throws IOException {
		Stage stage = (Stage) startGameButton.getScene().getWindow();
		if(yellowName.getText().trim().isEmpty() || redName.getText().trim().isEmpty()) {
			errorNameLabel.setTextFill(Color.RED);
		}else {
			stage.close();
			
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gameBoard.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			player1Name = redName.getText();
			player2Name = yellowName.getText();
			System.out.println("Player 1 " + player1Name);
			System.out.println("Player 2 " + player2Name);
		}
	}

}
