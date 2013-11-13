
/*
 * Named Shape class that is subclass of Shape.
 * Provides name field to Shape class.
 */

public abstract class NamedShape extends Shape {
	private String name;
	
	public NamedShape(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return this.getName();
	}
	
}
