/*
 * Shape class. All other classes in program extend this class.
 * Provides very generic methods such as center, area, and contains.
 */
public abstract class Shape {
	
	public Shape(){}
	public abstract Point center();
	public abstract double area();
	public boolean contains(Point p) {
		System.out.println("Contains method Must be overwritten.");
		return false;
	}
	
	
}