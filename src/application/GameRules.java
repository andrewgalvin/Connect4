package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameRules {
	public static final int COLUMNS = 7;
	public static final int ROWS = 6;

	public void placeDisk(Disk disk, int column, int player, int[][] board, Circle[][] boardCirc, boolean turn) {
		int i = 0;
		for (i = 0; i < ROWS; i++) {
			if (board[column][0] != 0) {
				break;
			}
			if (board[column][i] == 1 || board[column][i] == 2) {
				board[column][i - 1] = player;
				boardCirc[column][i - 1].setFill(disk.getTurn() ? Color.RED : Color.YELLOW);
				disk.changeTurn();
				turn = disk.getTurn();
				displayTurn(turn, board);
				break;
			}
		}
		if (i == ROWS) {
			board[column][i - 1] = player;
			boardCirc[column][i - 1].setFill(disk.getTurn() ? Color.RED : Color.YELLOW);
			disk.changeTurn();
			turn = disk.getTurn();
			displayTurn(turn, board);
		}

	}

	public void displayTurn(boolean turn, int[][] board) {
		if (checkWin(board) == false || GameBoard.playCount == 42) {
			Stage primaryStage = new Stage();

			String playerTurn = ("Turn: ");
			if (turn == true) {
				playerTurn = playerTurn + playerSelectController.player1Name;
			} else {
				playerTurn = playerTurn + playerSelectController.player2Name;
			}
			BorderPane root = new BorderPane();
			Label close = new Label("To close, click anywhere inside window.");
			Label winnerLabel = new Label(playerTurn);
			winnerLabel.setFont(Font.font("Verdana", 25));
			close.setFont(Font.font("Verdana", 15));
			winnerLabel.setAlignment(Pos.CENTER);
			close.setAlignment(Pos.CENTER);
			root.setCenter(winnerLabel);
			root.setBottom(close);
			winnerLabel.setPrefSize(300, 75);
			primaryStage.setTitle("Player's turn.");
			root.setOnMouseClicked(e -> primaryStage.close());
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		}

	}

	public boolean checkWin(int[][] board) {
		return checkVertical(board) || checkHorizontal(board) || checkLeftDiagonal(board) || checkRightDiagonal(board);
	}

	public boolean checkVertical(int[][] board) {
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS - 3; j++) {
				if (board[i][j] != 0) {
					if (board[i][j] == board[i][j + 1]) {
						if (board[i][j] == board[i][j + 2]) {
							if (board[i][j] == board[i][j + 3]) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public boolean checkHorizontal(int[][] board) {
		for (int i = 0; i < COLUMNS - 3; i++) {
			for (int j = 0; j < ROWS; j++) {
				if (board[i][j] != 0) {
					if (board[i][j] == board[i + 1][j]) {
						if (board[i][j] == board[i + 2][j]) {
							if (board[i][j] == board[i + 3][j]) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public boolean checkLeftDiagonal(int[][] board) {
		for (int i = 0; i < COLUMNS - 3; i++) {
			for (int j = 0; j < ROWS - 3; j++) {
				if (board[i][j] != 0) {
					if (board[i][j] == board[i + 1][j + 1]) {
						if (board[i][j] == board[i + 2][j + 2]) {
							if (board[i][j] == board[i + 3][j + 3]) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public boolean checkRightDiagonal(int[][] board) {
		for (int i = 3; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS - 3; j++) {
				if (board[i][j] != 0) {
					if (board[i][j] == board[i - 1][j + 1]) {
						if (board[i][j] == board[i - 2][j + 2]) {
							if (board[i][j] == board[i - 3][j + 3]) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public void printBoard(int[][] board) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				System.out.print(board[j][i] + "|");
			}
			System.out.println();
		}
	}
}
