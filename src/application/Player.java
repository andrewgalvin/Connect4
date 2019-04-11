package application;

public abstract class Player {

	public static String name;

	/**
	 * 
	 * Constructor for player name
	 * 
	 * @param name
	 */
	public Player(String name) {
		//Sets player name
		Player.name = name;
	}

	public Player() {
		// TODO Auto-generated constructor stub
		Player.name = "Player";
	}

	/**
	 * 
	 * Returns player's name
	 * @return
	 */
	public String getPlayerName() {
		//Return player's name
		return name;
	}
	
	public abstract boolean getTurn();
	
	public abstract void changeTurn();
	
}
