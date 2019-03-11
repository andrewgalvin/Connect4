package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameRules {
	@FXML
	Label playerTurn;
	
	
	public boolean isFilled(Circle circle) {
		if(circle.getFill() == Color.WHITE) {
			return false;
		}else {
			return true;
		}
	}
	
	public void changeTurn() {
		if(Player.pieceColor == Color.RED) {
			Player.pieceColor = Color.YELLOW;
			playerTurn.setText("Yellow");
		}else {
			Player.pieceColor = Color.RED;
			playerTurn.setText("Red");
		}
	}
	

}