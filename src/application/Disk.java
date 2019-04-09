package application;

public class Disk {
	private boolean turn = true;
	
	public Disk(boolean turn) {
		this.turn = turn;
	}
	
	public void changeTurn() {
		turn = !turn;
	}
	
	public boolean getTurn() {
		return turn;
	}

}
