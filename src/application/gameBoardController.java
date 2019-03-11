package application;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class gameBoardController {
	@FXML Rectangle rect1;
	@FXML Rectangle rect2;
	@FXML Rectangle rect3;
	@FXML Rectangle rect4;
	@FXML Rectangle rect5;
	@FXML Rectangle rect6;
	@FXML Rectangle rect7;
	@FXML Circle circle05;
	
	
	public void highlight() {
		rect1.setFill(Color.YELLOW);
		rect1.setOnMouseExited(e -> rect1.setFill(Color.TRANSPARENT));
		rect1.setOnMouseClicked(e-> circle05.setFill(Color.YELLOW));
	}
	
	public void highlight2() {
		rect2.setFill(Color.YELLOW);
		rect2.setOnMouseExited(e -> rect2.setFill(Color.TRANSPARENT));
	}
	
	public void highlight3() {
		rect3.setFill(Color.YELLOW);
		rect3.setOnMouseExited(e -> rect3.setFill(Color.TRANSPARENT));
	}
	
	public void highlight4() {
		rect4.setFill(Color.YELLOW);
		rect4.setOnMouseExited(e -> rect4.setFill(Color.TRANSPARENT));
	}
	
	public void highlight5() {
		rect5.setFill(Color.YELLOW);
		rect5.setOnMouseExited(e -> rect5.setFill(Color.TRANSPARENT));
	}
	
	public void highlight6() {
		rect6.setFill(Color.YELLOW);
		rect6.setOnMouseExited(e -> rect6.setFill(Color.TRANSPARENT));
	}
	
	public void highlight7() {
		rect7.setFill(Color.YELLOW);
		rect7.setOnMouseExited(e -> rect7.setFill(Color.TRANSPARENT));
	}
}
