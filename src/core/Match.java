/**
  * @author Romain
 */
package core;

import bataille_navale.Player;

public class Match 
{
	private Player p1;
	private Player p2;
	private State state;
	private Player winner;
	
	public Match (Player player1, Player player2) throws NullPointerException
	{
		if(player1 == null || player2 == null)
		{
			throw new NullPointerException("Une partie nécessite 2 joueurs.");
		}
		player1.init(new Radar(player2.getSea()));
		player2.init(new Radar(player1.getSea()));
		p1 = player1;
		p2 = player2;
		winner = null;
		state = State.NOT_LAUNCH;
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	public boolean positionShip (Player p, Ship s, Contact c, boolean h) throws Exception
	{
		if(state != State.NOT_LAUNCH)
		{
			throw new Exception("Impossible de placer des bâteaux en dehors de la phase d'initialisation");
		}
		if(p == null)
		{
			throw new NullPointerException();
		}
		p.getSea().removeShip(s);
		
		boolean ok = p.getSea().placeShip(s, c, h);
		if(ok)
		{
			p.getFleet().remove(s);
			s.setTarget(c);
			s.setOrientation(h);
			p.getFleet().add(s);
		}
		else if (s.getTarget() != null)
		{
			p.getSea().placeShip(s, c, h);
		}
		return ok;
	}
	
	public boolean removeShip(Player p, Ship s) throws Exception
	{
		if(state != State.NOT_LAUNCH)
		{
			throw new Exception("Impossible de placer des bâteaux en dehors de la phase d'initialisation");
		}
		if(p == null)
		{
			throw new NullPointerException();
		}
		boolean ok = p.getSea().removeShip(s);
		s.setTarget(null);
		return ok;
	}
	
	public void launchMatch () throws Exception
	{
		if(state != State.NOT_LAUNCH)
		{
			throw new Exception("La partie ne peut être lancée");
		}
		state = State.IN_GAME;
	}
	
	public void finishMatch (Player p) throws Exception
	{
		winner = p;
		state = State.FINISH;
	}
	
	public ResultAttack attack(Player p) throws Exception
	{
		if(state != State.IN_GAME)
		{
			throw new Exception("La partie n'est pas lancée ou terminée");
		}
		if(p == null)
		{
			throw new NullPointerException();
		}
		if(p != p1 && p != p2)
		{
			throw new IllegalArgumentException();
		}
		Player atk = p1 == p ? p2 : p1;
		Contact target = atk.launchAttack();
		ResultAttack rslt = atk.getSea().receiveAttack(target);
		if(rslt == ResultAttack.DOWN)
		{
			boolean end = true;
			for(Ship s : atk.getFleet())
			{
				if(!s.isDown())
				{
					end = false;
					break;
				}
			}
			if(end)
			{
				winner = atk;
				state = State.FINISH;
			}
		}
		return rslt;
	}
}
