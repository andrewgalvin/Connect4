package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * Class to implement Rules for Connect 4
 * 
 * @author galvina
 *
 */
public class GameRules {
	public static final int COLUMNS = 7;
	public static final int ROWS = 6;
	public static final int TILE_SIZE = 100;

	/**
	 * 
	 * Method to check to see if a disk can be placed
	 * 
	 * Checks to see if there is an open space at the bottom of the row, if there
	 * is an open space, places the disk there, if there is not an open space then 
	 * it does not place a disk but continues the same player's turn.
	 * 
	 * @param disk
	 * @param column
	 * @param player
	 * @param board
	 * @param boardCirc
	 * @param turn
	 */
	public void placeDisk(Disk disk, int column, int player, int[][] board, Circle[][] boardCirc, boolean turn) {
		int i = 0;
		/*
		 * Loop to check to see if there is an empty space
		 * to place a disk at the bottom row and works
		 * its way up until full.
		 * 
		 * If the space is empty, places a 1 or 2 in the board array
		 * and changes the color of the circle in the board GridPane to red
		 * or yellow.
		 */
		for (i = 0; i < ROWS; i++) {
			//If the column is full do nothing
			if (board[column][0] != 0) {
				break;
			}
			//If the column and row is not empty, places disk 1 above the empty space
			if (board[column][i] == 1 || board[column][i] == 2) {
				board[column][i - 1] = player;
				boardCirc[column][i - 1].setFill(disk.getTurn() ? Color.RED : Color.YELLOW);
				//Change the player's turn
				disk.changeTurn();
				turn = disk.getTurn();
				//Display's whose turn it is
				displayTurn(turn, board);
				break;
			}
		}
		/*
		 * If loop completes and i == rows
		 * place disk 1 above the row.
		 * 
		 * Without this code the disk would only be placed in the 
		 * bottom row of the game board.
		 */
		if (i == ROWS) {
			board[column][i - 1] = player;
			boardCirc[column][i - 1].setFill(disk.getTurn() ? Color.RED : Color.YELLOW);
			//Change the player's turn
			disk.changeTurn();
			turn = disk.getTurn();
			//Display's whose turn it is
			displayTurn(turn, board);
		}

	}

	/**
	 * 
	 * Method to display whose turn it is during the game
	 * 
	 * @param turn
	 * @param board
	 */
	public void displayTurn(boolean turn, int[][] board) {
		/*
		 * Runs this code only if no one has won and the game is not
		 * a tie.
		 */
		if (checkWin(board) == false || GameBoard.playCount != 42) {
			Stage primaryStage = new Stage();

			String playerTurn = ("Turn: ");
			/*
			 * Checks to see whose name to show depending on whose
			 * turn it is.
			 */
			if (turn == true) {
				playerTurn = playerTurn + playerSelectController.player1Name;
			} else {
				playerTurn = playerTurn + playerSelectController.player2Name;
			}
			/*
			 * Code for pop-up window that displays the player's turn.
			 */
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
			/*
			 * When mouse clicks anywhere on the pane, closes it 
			 * so the player can continue playing.
			 */
			root.setOnMouseClicked(e -> primaryStage.close());
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		}

	}

	/**
	 * 
	 * Method to check to see if a player won.
	 * @param board
	 * @return true if game is over
	 */
	public boolean checkWin(int[][] board) {
		/*
		 * Checks all 4 ways of winning
		 */
		return checkVertical(board) || checkHorizontal(board) || checkLeftDiagonal(board) || checkRightDiagonal(board);
	}

	/**
	 * 
	 * Method to see if a player won vertically
	 * 
	 * @param board
	 * @return
	 */
	public boolean checkVertical(int[][] board) {
		/*
		 * 2D Loop to loop through the 2D board
		 * checks to see if 3 above one location are
		 * the same number in the 2D board, if they are
		 * then returns true: meaning a player won vertically.
		 * 
		 * Example winning case:
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 0 0 1 0 0 0 0
		 * 0 0 1 0 0 0 0
		 * 0 0 1 0 0 0 0
		 * 0 0 1 0 0 0 0
		 */
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

	/**
	 * 
	 * Method to see if a player won horizontally
	 * 
	 * @param board
	 * @return
	 */
	public boolean checkHorizontal(int[][] board) {
		/*
		 * 2D Loop to loop through the 2D board
		 * checks to see if 3 to the right of one location are
		 * the same number in the 2D board, if they are
		 * then returns true: meaning a player won horizontally.
		 * 
		 * Example winning case:
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 1 1 1 1 0 0 0
		 */
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

	/**
	 * 
	 * Method to see if a player won using the right diagonals
	 * 
	 * @param board
	 * @return
	 */
	public boolean checkRightDiagonal(int[][] board) {
		/*
		 * 2D Loop to loop through the 2D board
		 * checks to see if in the 2D board,
		 * the location based off one beginning location: 
		 * {1 to the right, 1 above}
		 * {2 to the right, 2 above}
		 * {3 to the right, 3 above}
		 * 
		 * If all 3 of these are the same number,
		 * a player has won using right diagonals.
		 * 
		 * Example winning case:
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 1
		 * 0 0 0 0 0 1 0
		 * 0 0 0 0 1 0 0
		 * 0 0 0 1 0 0 0
		 */
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

	/**
	 * 
	 * Method to see if a player won using the left diagonals
	 * 
	 * @param board
	 * @return
	 */
	public boolean checkLeftDiagonal(int[][] board) {
		/*
		 * 2D Loop to loop through the 2D board
		 * checks to see if in the 2D board,
		 * the location based off one beginning location: 
		 * {1 to the left, 1 above}
		 * {2 to the left, 2 above}
		 * {3 to the left, 3 above}
		 * 
		 * If all 3 of these are the same number,
		 * a player has won using left diagonals.
		 * 
		 * Example winning case:
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 1 0 0 0 0 0 0
		 * 0 1 0 0 0 0 0
		 * 0 0 1 0 0 0 0
		 * 0 0 0 1 0 0 0
		 */
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

	/**
	 * 
	 * Prints board for testing the 2D array of type Int
	 * 
	 * Method was used during testing, in final product it is not used.
	 * 
	 * @param board
	 */
	public void printBoard(int[][] board) {
		/*
		 * Loops through the 2D array and prints it out
		 * This was used for testing and making sure
		 * everything was working the way it should be
		 * before implementing the GUI.
		 */
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				System.out.print(board[j][i] + "|");
			}
			System.out.println();
		}
	}
}
