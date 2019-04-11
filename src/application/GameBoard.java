package application;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameBoard extends GameRules {
	
	/*
	 * Variables used
	 */
	public static final int TILE_SIZE = 100;
	public static final int COLUMNS = 7;
	public static final int ROWS = 6;
	public static final int[][] board = new int[COLUMNS][ROWS];
	public static final Circle[][] boardCirc = new Circle[COLUMNS][ROWS];
	public GridPane game = new GridPane();
	public Pane root = new Pane();
	private boolean turn = true;
	private int player = 1;
	Disk place = new Disk(turn);
	public static int playCount = 0;

	/**
	 * 
	 * Method to create the game board GUI
	 * 
	 * @return root
	 */
	public Parent createBoard() {
		
		//Makes the grid for the 2D array and GridPane
		makeGrid();
		//Sets the background color to Connect 4 
		root.setStyle("-fx-background-color: #1e90ff;");
		//Adds the game GridPane to the root
		root.getChildren().add(game);
		//Adds the rectangles to the root
		root.getChildren().addAll(makeRectangles());

		return root;
	}

	/**
	 * Method to fill the GridPane and 2D array
	 */
	private void makeGrid() {
		/*
		 * 2D loop to fill the 2D int array with 0's
		 * and fill the GridPane up with circles and set
		 * the circle's color to white for default color.
		 */
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				board[i][j] = 0;
				boardCirc[i][j] = new Circle(TILE_SIZE / 2);
				boardCirc[i][j].setFill(Color.WHITE);
				game.add(boardCirc[i][j], i, j);
			}
		}
	}

	/**
	 * Method to create the rectangles into an ArrayList
	 * 
	 * These rectangles are used to help the user know which row he/she is going to place
	 * their disk.
	 * 
	 * These rectangles also control the placing of disks.
	 * 
	 * @return rect
	 */
	private ArrayList<Rectangle> makeRectangles() {
		//Makes new ArrayList of type Rectangle
		ArrayList<Rectangle> rect = new ArrayList<>();
		
		/*
		 * Loops through COLUMNS times and makes a new rectangle for each column
		 */
		for (int i = 0; i < COLUMNS; i++) {
			int column = i;
			//Adds a new rectangle to the ArrayList
			rect.add(new Rectangle(TILE_SIZE, ROWS * TILE_SIZE));
			//Sets location of rectangle
			rect.get(i).setTranslateX(i * (TILE_SIZE));
			//Sets color to transparent default
			rect.get(i).setFill(Color.TRANSPARENT);
			
			//Changes color of rectangle when mouse enters it
			rect.get(i).setOnMouseEntered(e -> rect.get(column).setFill(Color.rgb(240, 240, 0, 0.2)));
			//Changes color of rectangle when mouse leaves it back to the default color
			rect.get(i).setOnMouseExited(e -> rect.get(column).setFill(Color.TRANSPARENT));
			/*
			 * When a rectangle is clicked:
			 * 
			 * Tries to place a disk
			 * Changes the turn
			 * Check to see if someone won
			 * 
			 */
			rect.get(i).setOnMouseClicked(e -> {
				//Tries placeDisk
				placeDisk(place, column, player, board, boardCirc, turn);
				//Add 1 to playCount
				playCount++;
				//If board is full and no one has won, it is a tie
				if (playCount == 42) {
					tie();
				}
				//Changes turn
				if (player == 1) {
					player = 2;
					turn = !turn;
				} else if (player == 2) {
					player = 1;
					turn = !turn;
				}
				//Checks to see if someone won
				if (checkWin(board) == true) {
					gameOver();
				}
			});
		}
		//Returns the ArrayList
		return rect;
	}

	/**
	 * Method to create the window if the game is a tie
	 * 
	 */
	private void tie() {
		/*
		 * Creates and displays a:
		 * 
		 * It's a tie.
		 * 
		 * Window if the game ends in a tie.
		 */
		String tie = ("It's a tie.");
		BorderPane root = new BorderPane();
		Label winnerLabel = new Label(tie);
		
		/*
		 * Font/alignment/center/PrefSize
		 */
		winnerLabel.setFont(Font.font("Verdana", 25));
		winnerLabel.setAlignment(Pos.CENTER);
		root.setCenter(winnerLabel);
		winnerLabel.setPrefSize(350, 300);
		//Creates scene and shows it
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		//What to do when close requested
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}

	/**
	 * Method to display the winner of the game
	 * 
	 */
	private void gameOver() {
		
		//Creates the gameOver window using the endGame root.
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene(endGame()));
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}

	/**
	 * 
	 * Method to create the window for the game winner
	 * 
	 * @return root
	 */
	private Parent endGame() {
		String gameOver = ("Winner: ");
		//Check to see who won
		if (turn == true) {
			gameOver = gameOver + playerSelectController.player2Name;
		} else {
			gameOver = gameOver + playerSelectController.player1Name;
		}
		//Code to create window for the winner window
		BorderPane root = new BorderPane();
		Label winnerLabel = new Label(gameOver);
		
		/*
		 * Font/alignment/center/size
		 */
		winnerLabel.setFont(Font.font("Verdana", 25));
		winnerLabel.setAlignment(Pos.CENTER);
		root.setCenter(winnerLabel);
		winnerLabel.setPrefSize(350, 300);

		return root;
	}
}
