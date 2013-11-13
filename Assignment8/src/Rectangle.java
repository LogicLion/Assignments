
/*
 * Rectangle class extends NameShape class.
 * Has methods to access different vertices of rect, and access area.
 * Also has method to test if rectangle contains a particular point.
 */


public class Rectangle extends NamedShape {

	private Point upperLeftVertex;
	private Point lowerRightVertex;
	private double width;
	private double height;
	
	public Rectangle(String name, Point upperLeftVertex, Point lowerRightVertex) {
		super(name);
		this.upperLeftVertex = upperLeftVertex;
		this.lowerRightVertex = lowerRightVertex;
		this.width = Math.abs(lowerRightVertex.getX() - upperLeftVertex.getX());
		this.height = Math.abs(upperLeftVertex.getY() - lowerRightVertex.getY());
	}

	public Rectangle(){
		super("");
	}
	
	public Point getUL(){
		return upperLeftVertex;
	}
	
	public Point getUR(){
		return new Point(lowerRightVertex.getX(),upperLeftVertex.getY());
	}
	
	public Point getLL(){
		return new Point(upperLeftVertex.getX(), lowerRightVertex.getY());
	}
	
	public Point getLR(){
		return lowerRightVertex;
	}
	
	public boolean contains(Point p){
		double xMin = this.center().getX() - (this.width /2);
		double xMax = this.center().getX() + (this.width /2);
		double yMin = this.center().getY() - (this.height /2);
		double yMax = this.center().getY() + (this.height /2);
		return (p.getX() <= xMax && p.getX() >= xMin) && (p.getY() <= yMax && p.getY() >= yMin);
		
	}
	
	@Override
	public Point center(){
		return new Point(this.width /2, this.height /2);
	}

	@Override
	public double area() {
		return width * height;
	}
	
	public String toString(){
		return this.getName() + " R(" + this.getUL() + "," + this.getLR() + ")";
	}

}
