/**
  * @author Romain
 */
package core;

import java.util.LinkedList;
import java.util.List;

import bataille_navale.Player;

public class Game 
{
	private static Game instance = null;
	private Match match;
	private List<Player> players;
	
	public static Game getInstance ()
	{
		if(instance == null)
		{
			instance = new Game();
		}
		return instance;
	}
	
	private Game ()
	{
		players = new LinkedList<Player> ();
		match = null;
	}
	
	public Match newMatch(Player p1, Player p2) throws NullPointerException
	{
		match = new Match(p1, p2);
		if(!players.contains(p1))
		{
			players.add(p1);
		}
		if(!players.contains(p2))
		{
			players.add(p2);
		}
		return match;
	}
	
	public Match getMatch ()
	{
		return match;
	}
	
	public Player [] getPlayers ()
	{
		return players.toArray(new Player[0]);
	}
}
