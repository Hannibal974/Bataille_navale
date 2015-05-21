/**
  * @author Romain
 */
package core;

public class Contact 
{
	private byte x;
	private byte y;
	
	public Contact (char contactVertical, int contactHorizontal)
	{
		this(contactVertical-65, contactVertical-1);
	}
	
	public Contact(int y, int x)
	{
		if(y < 0 || y > 11 || x < 0 || x > 11)
		{
			throw new IllegalArgumentException();
		}
		this.x = (byte)x;
		this.y = (byte)y;
	}
	
	public Contact (String contact)
	{
		this(contact.charAt(0), Integer.parseInt(Character.toString(contact.charAt(1))));
	}

	public byte getX() {
		return x;
	}

	public void setX(byte x) {
		this.x = x;
	}

	public byte getY() {
		return y;
	}

	public void setY(byte y) {
		this.y = y;
	}
	
	public int getChiffre ()
	{
		return x+1;
	}
	
	public char getLettre()
	{
		return (char) (y+'A');
	}
	
	@Override
	public String toString ()
	{
		return "" + this.getLettre () + this.getChiffre();
	}
}
