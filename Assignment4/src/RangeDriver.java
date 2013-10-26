
/*
 * RangeDriver class.
 * Author: Thomas Hocking
 * CS 251
 * Assignment #4.
 * 
 * Class provides a test for the Range Class.
 * RangeDriver tests two ranges for validation during construction, comparison, and equality.
 */


import java.util.Scanner;


public class RangeDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the range testing program!'\n");
		System.out.println("Starting Range entry and testing of constructors\n");
		System.out.print("Enter min and max values for Range 1: ");
		Range r1 = new Range(input.nextDouble(), input.nextDouble());
		System.out.println("Range 1 created as " + r1);
		Range r2 = new Range();
		System.out.println("Created Range 2 with default constructor: " + r2);
		System.out.print("Enter new max for Range 2: ");
		r2.setMax(input.nextDouble());
		System.out.println("Range 2 changed by setMax(): " + r2);
		System.out.print("Enter new min for Range 2: ");
		r2.setMin(input.nextDouble());
		System.out.println("Range 2 changed by setMin(): " + r2);
		System.out.print("Enter new min and max for Range 2: ");
		r2.setRange(input.nextDouble(), input.nextDouble());
		System.out.println("Range 2 changed by setRange(): " + r2);
		System.out.println("Ending Range entry and testing of constructors\n");
		System.out.println("Starting overlap and containment testing\n");
		System.out.print("Enter value X for containment testing: ");
		double containmentVal = input.nextDouble();
		if(r1.contains(containmentVal)){
			System.out.println("Range 1 contains: " + containmentVal);
		}else{
			System.out.println("Range 1 does not contain " + containmentVal);
		}
		
		if(r2.contains(containmentVal)){
			System.out.println("Range 2 contains: " + containmentVal);
		}else{
			System.out.println("Range 2 does not contain " + containmentVal);
		}
		
		if(r1.overlaps(r2)){
			System.out.println("Range 1 and Range 2 overlap");
		}else{
			System.out.println("Range 1 and Range 2 do not overlap.");
		}
		
		if(r1.contains(r2)){
			System.out.println("Range 1 contains Range 2");
		}else{
			System.out.println("Range 1 does not contain Range 2");
		}
		
		if(r2.contains(r1)){
			System.out.println("Range 2 contains Range 1");
		}else{
			System.out.println("Range 2 does not contain Range 1");
		}
		
		System.out.println("Ending overlap and containment testing\n");
		System.out.println("Starting combine and equality testing\n");
		
		Range r3 = r1.combineWith(r2);
		Range r4 = r2.combineWith(r1);
		System.out.println("Range 3 = Range 1 combined with Range 2: " + r3);
		System.out.println("Range 4 = Range 2 combined with Range 1: " + r4);
		if(r1.equals(r2)){
			System.out.println("Range 1 and Range 2 are equal");
		}else{
			System.out.println("Range 1 and Range 2 and not equal");
		}
		
		if(r3 == null || r4 == null){
			System.out.println("Range 3 and Range 4 are null");
		}
		else if(r3.equals(r4)){
			System.out.println("Range 3 and Range 4 are equal");
		}else{
			System.out.println("Range 3 and Range 4 and not equal");
		}
	}

}
