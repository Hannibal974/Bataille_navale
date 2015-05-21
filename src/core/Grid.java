/**
  * @author Romain
 */
package core;

public class Grid 
{
	private Case[][] sea;
	
	public Grid()
	{
		sea = new Case [11][11];
		for(int i = 0; i < sea.length; i++)
		{
			for(int j = 0; j < sea[i].length; j++)
			{
				sea[i][j] = new Case();
			}
		}
	}

	public Case[][] getSea() {
		return sea;
	}

	public void setSea(Case[][] sea) {
		this.sea = sea;
	}
	
	public ResultAttack receiveAttack (Contact target) throws Exception
	{
		if(target == null)
		{
			throw new NullPointerException();
		}
		if(sea[target.getY()][target.getX()].isHit())
		{
			throw new Exception("Case déjà attaquée.");
		}
		else
		{
			Ship s = sea[target.getY()][target.getX()].hit();
			if(s == null)
			{
				return ResultAttack.FAILED;
			}
			else
			{
				if(s.isDown())
				{
					return ResultAttack.DOWN;
				}
				else return ResultAttack.HIT;
			}
		}
	}
	
	public boolean placeShip (Ship s, Contact target, boolean horizontal)
	{
		if(s == null || target == null)
		{
			throw new NullPointerException();
		}
		int posx = target.getX();
		int posy = target.getY();
		if(horizontal)
		{
			if(posx + s.getSize() > 11)
			{
				return false;
			}
			
			for(int i = 0; i < s.getSize(); i++)
			{
				if(!sea[posy][posx+1].IsEmpty())
				{
					return false;
				}
			}
			
			for(int j = 0; j < s.getSize(); j++)
			{
				sea[posy][posx+1] = new Case(s);
			}
		}
		else
		{
			if(posy + s.getSize() > 11)
			{
				return false;
			}
			
			for(int i = 0; i < s.getSize(); i++)
			{
				if(!sea[posy+i][posx].IsEmpty())
				{
					return false;
				}
			}
			
			for(int j = 0; j < s.getSize(); j++)
			{
				sea[posy+j][posx] = new Case(s);
			}
		}
		return true;
	}
	
	public boolean removeShip (Ship s)
	{
		if(s.getTarget() != null)
		{
			int posx = s.getTarget().getX();
			int posy = s.getTarget().getY();
			if(s.isOrientation())
			{
				for(int i = 0; i < s.getSize(); i++)
				{
					sea[posy][posx + i].removeShip();
				}
			}
			else
			{
				for(int i = 0; i < s.getSize(); i++)
				{
					sea[posy + i][posx].removeShip();
				}
			}
		}
		return false;
	}
	
	public Case[][] getGrid()
	{
		return sea.clone();
	}
}
