package application;

public class Disk {
	private boolean turn = true;
	
	/*
	 * True: red turn
	 * False: yellow turn
	 */
	
	/**
	 * Constructor method
	 * 
	 * @param turn
	 */
	public Disk(boolean turn) {
		//Creates default turn
		this.turn = turn;
	}
	
	/**
	 * Method to change the player's turn
	 */
	public void changeTurn() {
		//Changes the turn.
		turn = !turn;
	}
	
	/**
	 * Method to get which player's turn it is
	 * 
	 * @return
	 */
	public boolean getTurn() {
		//Returns whose turn it is.
		return turn;
	}

}
