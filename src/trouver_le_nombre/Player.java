package trouver_le_nombre;

/**
  * @author Romain
 */

public class Player 
{
	private String username;
	private int GamePort;
	
	
	public Player (String name)
	{
		username = name;
	}
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getGamePort() {
		return GamePort;
	}


	public void setGamePort(int gamePort) {
		GamePort = gamePort;
	}

}
