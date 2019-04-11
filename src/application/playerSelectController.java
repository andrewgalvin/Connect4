package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class playerSelectController extends GameBoard {

	@FXML
	private Button startGameButton;
	@FXML
	private TextField yellowName;
	@FXML
	private TextField redName;
	@FXML
	private Label errorNameLabel;

	public static String player1Name;
	public static String player2Name;

	/**
	 * Method to say what pressing the ENTER key does
	 */
	public void enter() {
		
		//What to do when ENTER is pressed while in yellowName TextField
		yellowName.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				try {
					startGameButtonClicked();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		//What to do when ENTER is pressed while in redName textField
		redName.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				try {
					startGameButtonClicked();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Method to begin the game off of the Player Select GUI
	 * 
	 * @throws IOException
	 */
	public void startGameButtonClicked() throws IOException {
		Stage stage = (Stage) startGameButton.getScene().getWindow();
		//Checks to see if both TextFields are not empty
		if (yellowName.getText().trim().isEmpty() || redName.getText().trim().isEmpty()) {
			//Error message to display if one or both are empty
			errorNameLabel.setTextFill(Color.RED);
		} else {
			stage.close();
			
			//Starts game
			GameBoard game = new GameBoard();
			stage.setScene(new Scene(game.createBoard()));
			stage.setTitle("Connect 4!");
			stage.show();
			stage.setOnCloseRequest(e -> Platform.exit());
			player1Name = redName.getText();
			player2Name = yellowName.getText();
		}
	}

}
