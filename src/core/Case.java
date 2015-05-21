/**
  * @author Romain
 */
package core;

public class Case 
{
	private Ship boat;
	private boolean hit;
	
	public Case ()
	{
		boat = null;
		hit = false;
	}
	
	public Case (Ship s) throws NullPointerException
	{
		if(s == null)
		{
			throw new NullPointerException();
		}
		boat = s;
	}
	
	// Getters & Setters
	public Ship getBoat() {
		return boat;
	}

	public void setBoat(Ship boat) {
		this.boat = boat;
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	// Retourne true si la case contient un bâteau sinon false
	public boolean IsEmpty()
	{
		return boat == null ? true : false;
	}
	
	// Attaque du bâteau s'il existe sur la case et qu'elle n'a pas déjà été attaqué
	public Ship hit ()
	{
		if(boat != null && hit == false)
		{
			boat.incDomage();
			hit = true;
			return boat;
		}
		else if(hit == false)
		{
			hit = true;
		}
		return null;
	}
	
	// Suppression du bâteau sur la case
	public void removeShip()
	{
		boat = null;
	}
}
