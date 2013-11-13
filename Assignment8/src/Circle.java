/*
 * Circle class extends NameShape class.
 * Has methods to access center, and radius, and area.
 * Also has method to test if circle contains  a particular point.
 */
public class Circle extends NamedShape{

	private Point center;
	private double radius;
	
	public Circle(String name, Point center, double radius) {
		super(name);
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(){
		super("");
	}

	public Point getCenter(){
		return this.center;
	}
	
	public double getRadius(){
		return this.radius;
	}
	
	@Override
	public Point center() {
		return this.center;
	}

	@Override
	public boolean contains(Point p) {
		double xDistanceSquared = Math.pow(this.center.getX() - p.getX(), 2);
		double yDistanceSquared = Math.pow(this.center.getY() - p.getY(), 2);
		double distance = Math.sqrt(xDistanceSquared + yDistanceSquared);
		return distance <= this.radius;
	}

	@Override
	public double area() {
		return (Math.PI * Math.pow(this.radius, 2));
	}
	
	public String toString(){
		return this.getName() + " C(" + this.getCenter() + "," + this.getRadius() + ")";
	}

	
}
