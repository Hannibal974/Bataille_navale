/**
  * @author Romain
 */

package core;

public class Ship 
{
	private Integer size;
	private String name;
	private Integer domage;
	private boolean orientation;
	private Contact target;
	
	public Ship(String nom, int nbCase)
	{
		size = nbCase;
		name = nom;
		domage = 0;
	}

	// Getters & Setters
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDomage() {
		return domage;
	}

	public void setDomage(Integer domage) {
		this.domage = domage;
	}

	public boolean isOrientation() {
		return orientation;
	}

	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}

	public Contact getTarget() {
		return target;
	}

	public void setTarget(Contact target) {
		this.target = target;
	}
	
	public void incDomage()
	{
		domage++;
	}
	
	// Retourne si le bâteau est coulé
	public boolean isDown()
	{
		return domage == size ? true : false;
	}
	
	public Ship clonerPrototype()
	{
		return new Ship(name, size);
	}
}
