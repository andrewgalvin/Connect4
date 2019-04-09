package application;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

public class GameBoard extends GameRules{
	public static final int TILE_SIZE = 100;
	public static final int COLUMNS = 7;
	public static final int ROWS = 6;
	final int TOTAL_MOVES = 0;
	public static final int[][] board = new int[COLUMNS][ROWS];
	public static final Rectangle[] rect = new Rectangle[COLUMNS];
	public static final Circle[][] boardCirc = new Circle[COLUMNS][ROWS];
	public GridPane game = new GridPane();
	public Pane root = new Pane();
	private boolean turn = true;
	private int player = 1;
	Disk place = new Disk(turn);
	public static int playCount = 0;
	

	public Parent createContent() {
		makeGrid();
		Label turn = new Label("Turn " + Player.name);
		turn.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: #1e90ff;");
		root.getChildren().add(game);
		root.getChildren().addAll(makeRectangles());

		return root;
	}

	private void makeGrid() {
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				board[i][j] = 0;
				boardCirc[i][j] = new Circle(TILE_SIZE / 2);
				boardCirc[i][j].setFill(Color.WHITE);
				game.add(boardCirc[i][j], i, j);
			}
		}
	}

	private ArrayList<Rectangle> makeRectangles() {
		ArrayList<Rectangle> rect = new ArrayList<>();
		for (int i = 0; i < COLUMNS; i++) {
			int column = i;
			rect.add(new Rectangle(TILE_SIZE, ROWS * TILE_SIZE));
			rect.get(i).setTranslateX(i * (TILE_SIZE));
			rect.get(i).setFill(Color.TRANSPARENT);
			rect.get(i).setTranslateX(i * (TILE_SIZE));
			rect.get(i).setFill(Color.TRANSPARENT);

			rect.get(i).setOnMouseEntered(e -> rect.get(column).setFill(Color.rgb(240, 240, 0, 0.2)));
			rect.get(i).setOnMouseExited(e -> rect.get(column).setFill(Color.TRANSPARENT));
			rect.get(i).setOnMouseClicked(e -> {
				// placeDisk
				placeDisk(place, column, player, board, boardCirc, turn);
				playCount++;
				if(playCount == 42) {
					tie();
				}
				if (player == 1) {
					player = 2;
					turn = !turn;
				} else if (player == 2) {
					player = 1;
					turn = !turn;
				}
				if (checkWin(board) == true) {
					gameOver();
				}
				// System.out.println("__________________");
				// printBoard();
			});
		}
		return rect;
	}
	private void tie() {
		String tie = ("It's a tie.");
		BorderPane root = new BorderPane();
		Label winnerLabel = new Label(tie);
		winnerLabel.setFont(Font.font("Verdana", 25));
		winnerLabel.setAlignment(Pos.CENTER);
		root.setCenter(winnerLabel);
		winnerLabel.setPrefSize(350, 300);
		
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}
	private void gameOver() {
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene(endGame()));
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}

	private Parent endGame() {
		String gameOver = ("Winner: ");
		if(turn == true) {
			gameOver = gameOver + playerSelectController.player2Name;
		}else {
			gameOver = gameOver + playerSelectController.player1Name;
		}
		BorderPane root = new BorderPane();
		Label winnerLabel = new Label(gameOver);
		winnerLabel.setFont(Font.font("Verdana", 25));
		winnerLabel.setAlignment(Pos.CENTER);
		root.setCenter(winnerLabel);
		winnerLabel.setPrefSize(350, 300);

		return root;
	}
}
