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

	/**
	 * 
	 * Returns player's name
	 * @return
	 */
	public String getPlayerName() {
		//Return player's name
		return name;
	}
}
