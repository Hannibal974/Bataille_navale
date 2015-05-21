/**
  * @author Romain
 */

package core;

public class Radar 
{
	private Grid monitoredSea;
	
	public Radar(Grid monitoringSea) throws NullPointerException
	{
		if(monitoringSea == null)
		{
			throw new NullPointerException("Le radar doit surveiller une mer");
		}
		monitoredSea = monitoringSea;
	}

	public Grid getMonitoredSea() {
		return monitoredSea;
	}

	public void setMonitoredSea(Grid monitoredSea) {
		this.monitoredSea = monitoredSea;
	}
	
	public boolean AlreadyShoot (Contact target)
	{
		if(target != null)
		{
			Case[][] grid = monitoredSea.getGrid();
			return grid[target.getY()][target.getX()].isHit();
		}
		return false;
	}
	
	// Retourne true s'il un bâteau est sur la case et qu'il est touché
	public boolean ShipIsHit (Contact target)
	{
		if(target != null)
		{
			Case[][] grid = monitoredSea.getGrid();
			Case c = grid[target.getY()][target.getX()];
			return c.isHit() && c.IsEmpty() == false;
		}
		return false;
	}
	
	public boolean ShipIsDown(Contact target)
	{
		if(target != null)
		{
			Case [][] grid = monitoredSea.getGrid();
			Case c = grid[target.getY()][target.getX()];
			Ship s = c.getBoat();
			return c.isHit() == true && s != null && s.isDown();
		}
		return false;
	}
}
