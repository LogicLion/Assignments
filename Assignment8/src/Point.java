/*
 * Point class, simple class that provides function of a point with x and y cords.
 */
public class Point extends Shape{
	private double x;
	private double y;
		
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Point(){
		this(0.0,0.0);
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public Point center(){
		return this;	
	}
	
	public double area(){
		return 0;
	}
	
	public boolean contains(Point p){
		return (this.x == p.getX() && this.y == p.getY());
	}
	
	public double distance(Point p){
		double xPointsSquared = Math.pow((this.x - p.getX()),2);
		double yPointsSquared = Math.pow((this.y - p.getY()), 2);
		return Math.sqrt( (xPointsSquared)+(yPointsSquared) );
	}
	
	public String toString(){
		return "P(" + this.x + "," + this.y + ")";
	}
}
