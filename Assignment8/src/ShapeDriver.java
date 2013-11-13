import java.util.ArrayList;
import java.util.Scanner;

/*
 * ShapeDriver class.
 * Author: Thomas Hocking
 * Assignment #8
 * ShapeDriver class provides testing of Circle, Point, and Rectangle classes.
 * Can provide sum of total areas, test to see if Shapes contain points, and can display list of created shapes. 
 */

public class ShapeDriver {
	private ArrayList<Shape> shapeList;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the shape creator, area printer, and point checker program.");
		Scanner input = new Scanner(System.in);
		ShapeDriver driver = new ShapeDriver();
		driver.enterShape(input);
		driver.printShapes();
		System.out.println("Sum of all shapes areas = " + driver.sumOfAllShapesAreas());
		driver.testForContains(input);
		System.out.println("Goodbye!");
		
	}
	
	public ShapeDriver(){
		shapeList = new ArrayList<Shape>();
	}
	
	public void enterShape(Scanner input){
		String userInput = "";

		do{
			System.out.println("Enter in a shape. (type circle, rectangle, point, or \'q\' to quit.)");
			 userInput = input.nextLine();
				if(userInput.equalsIgnoreCase("circle")){
					this.shapeList.add(createCircle(input));
				}else if(userInput.equalsIgnoreCase("rectangle")){
					this.shapeList.add(createRectangle(input));
				}else if(userInput.equalsIgnoreCase("point")){
					this.shapeList.add(createPoint(input));
				}
			}while(!userInput.equalsIgnoreCase("q"));

	}
	
	public void testForContains(Scanner input){
		int userInput = 0;
		do{
			System.out.println("Type 1 to enter in a point, or 2 to quit.");
			userInput = input.nextInt();
			if(userInput == 1){
				System.out.println("Enter in the point's values (x y)");
				Point testP = new Point(input.nextDouble(), input.nextDouble());
				System.out.println();
				for(int i = 0; i < shapeList.size(); i++){
					if(shapeList.get(i).contains(testP)){
						System.out.println(shapeList.get(i) + " contains the point.");
					}else{
						System.out.println(shapeList.get(i) + " does not contain that point.");
					}
				}
			}
			System.out.println();
		}while(userInput == 1);
	}
	
	public void printShapes(){
		System.out.println("Printing list of shapes and points..");
		System.out.println();
		for(int i = 0; i < shapeList.size(); i++){
			System.out.println("\t" + shapeList.get(i));
		}
		System.out.println();
		
	}
	
	public double sumOfAllShapesAreas(){
		double accumulator = 0.0;
		for(int i = 0; i < this.shapeList.size(); i++){
			accumulator += shapeList.get(i).area();
		}
		return accumulator;
	}
	
	private static Circle createCircle(Scanner input){
		System.out.println("Enter in name of circle");
		String userInput = input.nextLine();
		System.out.println("Enter in radius of circle");
		double circleRadius = input.nextDouble();
		System.out.println("Enter in center point values (x y)");
		double xVal = input.nextDouble();
		double yVal = input.nextDouble();
		input.nextLine();
		return new Circle(userInput, new Point(xVal, yVal), circleRadius);
	}
	
	private static Rectangle createRectangle(Scanner input){
		System.out.println("Enter in name of Rectangle");
		String userInput = input.nextLine();
		System.out.println("Enter in x and y values of upper left vertex of rectangle");
		Point uL = new Point(input.nextDouble(), input.nextDouble());
		System.out.println("Enter in x and y values of lower right vertex of rectangle");
		Point lR = new Point(input.nextDouble(), input.nextDouble());
		input.nextLine();
		return new Rectangle(userInput, uL, lR);
	}
	
	private static Point createPoint(Scanner input){
		System.out.println("Enter in x and y values.");
		Point p = new Point(input.nextDouble(), input.nextDouble());
		input.nextLine();
		return p;
	}
}
