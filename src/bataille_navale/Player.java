package bataille_navale;

/**
  * @author Romain
 */


import java.util.LinkedList;
import java.util.List;

import core.Case;
import core.Contact;
import core.Grid;
import core.Radar;
import core.Ship;

public class Player 
{
	private String username;
	private Integer numberOfShots;
	private Radar ennemySea;
	private Grid sea;
	private List<Ship> fleet;
	private Contact target;
	private boolean ready;
	
	public Player (String name)
	{
		username = name;
		numberOfShots = 0;
		sea = new Grid();
		fleet = new LinkedList<Ship> ();
		ready = false;
	}
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Integer getNumberOfShots() {
		return numberOfShots;
	}


	public void setNumberOfShots(Integer numberOfShots) {
		this.numberOfShots = numberOfShots;
	}


	public Radar getEnnemySea() {
		return ennemySea;
	}


	public void setEnnemySea(Radar ennemySea) {
		this.ennemySea = ennemySea;
	}


	public Grid getSea() {
		return sea;
	}


	public void setSea(Grid sea) {
		this.sea = sea;
	}


	public List<Ship> getFleet() {
		return fleet;
	}


	public void setFleet(List<Ship> fleet) {
		this.fleet = fleet;
	}


	public Contact getTarget() {
		return target;
	}


	public void setTarget(Contact target) {
		this.target = target;
	}
	

	public boolean isReady() {
		return ready;
	}


	public void setReady(boolean ready) {
		this.ready = ready;
	}


	// Récupère la grille de l'ennemy
	public void init (Radar ennemyGrid) throws NullPointerException
	{
		if(ennemyGrid == null)
		{
			throw new NullPointerException("Le radar fournit au joueur" + username + "est incorrect");
		}
		ennemySea = ennemyGrid;
	}
	
	// Retourne les coordonnées de la cible visée
	public Contact launchAttack ()
	{
		numberOfShots++;
		return target;
	}
	
	// Retourne la case correspondante aux coordonnées choisies
	public Case getCase(Contact target)
	{
		return getSea().getSea()[target.getY()][target.getX()];
	}
	
	public void Imready ()
	{
		ready = !ready;
	}
	
	
}
