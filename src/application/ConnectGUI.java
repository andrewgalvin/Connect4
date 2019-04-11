/*package application;

import javafx.application.Application;
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

public class ConnectGUI extends Application {

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

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> Platform.exit());

	}

	private Parent createContent() {
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

	private Rectangle[] makeRectangles() {
		for (int i = 0; i < COLUMNS; i++) {
			int column = i;
			rect[i] = new Rectangle(TILE_SIZE, (ROWS) * TILE_SIZE);
			rect[i].setTranslateX(i * (TILE_SIZE));
			rect[i].setFill(Color.TRANSPARENT);
			rect[i].setTranslateX(i * (TILE_SIZE));
			rect[i].setFill(Color.TRANSPARENT);

			rect[i].setOnMouseEntered(e -> rect[column].setFill(Color.rgb(240, 240, 0, 0.2)));
			rect[i].setOnMouseExited(e -> rect[column].setFill(Color.TRANSPARENT));
			rect[i].setOnMouseClicked(e -> {
				// placeDisk
				placeDisk(place, column, player);
				if (player == 1) {
					player = 2;
				} else if (player == 2) {
					player = 1;
				}
				if (checkWin() == true) {
					gameOver();
				}
				//System.out.println("__________________");
				//printBoard();
			});
		}
		return rect;
	}

	private void placeDisk(Disk disk, int column, int player) {
		int i = 0;
		for (i = 0; i < ROWS; i++) {
			if(board[column][0] != 0) {
				break;
			}
			if (board[column][i] == 1 || board[column][i] == 2) {
				board[column][i - 1] = player;
				boardCirc[column][i - 1].setFill(disk.getTurn() ? Color.RED : Color.YELLOW);
				place.changeTurn();
				turn = place.getTurn();				
				break;
			}
		}
		if (i == ROWS) {
			board[column][i - 1] = player;
			boardCirc[column][i - 1].setFill(disk.getTurn() ? Color.RED : Color.YELLOW);
			place.changeTurn();
			turn = place.getTurn();
		}

	}
	

	public boolean checkWin() {
		return checkVertical() || checkHorizontal() || checkLeftDiagonal() || checkRightDiagonal();
	}

	public boolean checkVertical() {
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

	public boolean checkHorizontal() {
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

	public boolean checkLeftDiagonal() {
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

	public boolean checkRightDiagonal() {
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

	private void gameOver() {
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene(endGame()));
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}

	private Parent endGame() {
		String winner = ("Winner: ");
		if (turn == true) {
			winner = winner + "YELLOW";
		} else {
			winner = winner + "RED";
		}
		BorderPane root = new BorderPane();
		Label winnerLabel = new Label(winner);
		winnerLabel.setFont(Font.font("Verdana", 25));
		winnerLabel.setAlignment(Pos.CENTER);
		root.setCenter(winnerLabel);
		winnerLabel.setPrefSize(350, 300);

		return root;
	}

	public void printBoard() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				System.out.print(board[j][i] + "|");
			}
			System.out.println();
		}
	}

}*/
