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

	public void enter() {
		yellowName.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				try {
					startGameButtonClicked();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
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

	public void startGameButtonClicked() throws IOException {
		Stage stage = (Stage) startGameButton.getScene().getWindow();
		if (yellowName.getText().trim().isEmpty() || redName.getText().trim().isEmpty()) {
			errorNameLabel.setTextFill(Color.RED);
		} else {

			stage.close();

			GameBoard game = new GameBoard();
			stage.setScene(new Scene(game.createContent()));
			stage.setTitle("Connect 4!");
			stage.show();
			stage.setOnCloseRequest(e -> Platform.exit());
			player1Name = redName.getText();
			player2Name = yellowName.getText();
			System.out.println("Player 1 " + player1Name);
			System.out.println("Player 2 " + player2Name);
		}
	}

}
