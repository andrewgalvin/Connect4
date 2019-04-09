/*package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class gameBoardController extends GameRules {
	// Rows
	@FXML
	Rectangle rect0;
	@FXML
	Rectangle rect1;
	@FXML
	Rectangle rect2;
	@FXML
	Rectangle rect3;
	@FXML
	Rectangle rect4;
	@FXML
	Rectangle rect5;
	@FXML
	Rectangle rect6;

	// Game board
	@FXML
	Circle circle05;
	@FXML
	Circle circle04;
	@FXML
	Circle circle03;
	@FXML
	Circle circle02;
	@FXML
	Circle circle01;
	@FXML
	Circle circle00;

	@FXML
	Circle circle15;
	@FXML
	Circle circle14;
	@FXML
	Circle circle13;
	@FXML
	Circle circle12;
	@FXML
	Circle circle11;
	@FXML
	Circle circle10;

	@FXML
	Circle circle25;
	@FXML
	Circle circle24;
	@FXML
	Circle circle23;
	@FXML
	Circle circle22;
	@FXML
	Circle circle21;
	@FXML
	Circle circle20;

	@FXML
	Circle circle35;
	@FXML
	Circle circle34;
	@FXML
	Circle circle33;
	@FXML
	Circle circle32;
	@FXML
	Circle circle31;
	@FXML
	Circle circle30;

	@FXML
	Circle circle45;
	@FXML
	Circle circle44;
	@FXML
	Circle circle43;
	@FXML
	Circle circle42;
	@FXML
	Circle circle41;
	@FXML
	Circle circle40;

	@FXML
	Circle circle55;
	@FXML
	Circle circle54;
	@FXML
	Circle circle53;
	@FXML
	Circle circle52;
	@FXML
	Circle circle51;
	@FXML
	Circle circle50;

	@FXML
	Circle circle65;
	@FXML
	Circle circle64;
	@FXML
	Circle circle63;
	@FXML
	Circle circle62;
	@FXML
	Circle circle61;
	@FXML
	Circle circle60;

	// Grid
	@FXML
	GridPane boardPane;
	
	//Turn
	@FXML
	Label playerTurn;

	public void highlight0() {
		rect0.setFill(Color.YELLOW);
		rect0.setOnMouseExited(e -> rect0.setFill(Color.TRANSPARENT));
		rect0.setOnMouseClicked(e -> {
			if (!isFilled(circle05)) {
				circle05.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle04)) {
				circle04.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle03)) {
				circle03.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle02)) {
				circle02.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle01)) {
				circle01.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle00)) {
				circle00.setFill(Player.pieceColor);
				changeTurn(playerTurn);
				try {
					checkTie();
				}catch(Exception e1) {
					System.out.println("ERROR");
				}
			}
		});

	}

	public void highlight1() {
		rect1.setFill(Color.YELLOW);
		rect1.setOnMouseExited(e -> rect1.setFill(Color.TRANSPARENT));
		rect1.setOnMouseClicked(e -> {
			if (!isFilled(circle15)) {
				circle15.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle14)) {
				circle14.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle13)) {
				circle13.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle12)) {
				circle12.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle11)) {
				circle11.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle10)) {
				circle10.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			}
		});
	}

	public void highlight2() {
		rect2.setFill(Color.YELLOW);
		rect2.setOnMouseExited(e -> rect2.setFill(Color.TRANSPARENT));
		rect2.setOnMouseClicked(e -> {
			if (!isFilled(circle25)) {
				circle25.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle24)) {
				circle24.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle23)) {
				circle23.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle22)) {
				circle22.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle21)) {
				circle21.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle20)) {
				circle20.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			}
		});
	}

	public void highlight3() {
		rect3.setFill(Color.YELLOW);
		rect3.setOnMouseExited(e -> rect3.setFill(Color.TRANSPARENT));
		rect3.setOnMouseClicked(e -> {
			if (!isFilled(circle35)) {
				circle35.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle34)) {
				circle34.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle33)) {
				circle33.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle32)) {
				circle32.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle31)) {
				circle31.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle30)) {
				circle30.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			}
		});
	}

	public void highlight4() {
		rect4.setFill(Color.YELLOW);
		rect4.setOnMouseExited(e -> rect4.setFill(Color.TRANSPARENT));
		rect4.setOnMouseClicked(e -> {
			if (!isFilled(circle45)) {
				circle45.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle44)) {
				circle44.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle43)) {
				circle43.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle42)) {
				circle42.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle41)) {
				circle41.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle40)) {
				circle40.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			}
		});
	}

	public void highlight5() {
		rect5.setFill(Color.YELLOW);
		rect5.setOnMouseExited(e -> rect5.setFill(Color.TRANSPARENT));
		rect5.setOnMouseClicked(e -> {
			if (!isFilled(circle55)) {
				circle55.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle54)) {
				circle54.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle53)) {
				circle53.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle52)) {
				circle52.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle51)) {
				circle51.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle50)) {
				circle50.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			}
		});
	}

	public void highlight6() {
		rect6.setFill(Color.YELLOW);
		rect6.setOnMouseExited(e -> rect6.setFill(Color.TRANSPARENT));
		rect6.setOnMouseClicked(e -> {
			if (!isFilled(circle65)) {
				circle65.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle64)) {
				circle64.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle63)) {
				circle63.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle62)) {
				circle62.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle61)) {
				circle61.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			} else if (!isFilled(circle60)) {
				circle60.setFill(Player.pieceColor);
				changeTurn(playerTurn);
			}
		});
	}
}*/
