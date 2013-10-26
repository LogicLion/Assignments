/*
 * Range class.
 * Author: Thomas Hocking
 * CS 251
 * Assignment #4.
 * 
 * Class provides functionality for a Range object.
 * Range objects contain a min and max value that represents a number range.
 * Provides basic comparison, and overlap functionality.
 */
public class Range {
	private double min;
	private double max;
	
	public Range(){
		this(0.0,0.0);
	}
	
	public Range(double min, double max){
		if(max > min)
		{
			this.min = min;
			this.max = max;
		}else{
			
		}
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		if(!(min > this.max)){
			this.min = min;
		}
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		if(!(max < this.min)){
			this.max = max;
		}
	}
	
	public void setRange(double min, double max){
		if(max > min){
			this.min = min;
			this.max = max;
		}
	}
	
	public boolean overlaps(Range r2){
		return (this.min <= r2.max && r2.min <= this.max);
	}
	
	public boolean contains(double num){
		return this.max >= num  && this.min <= num;
	}
	
	public boolean contains(Range r2){
		return this.max > r2.max && this.min < r2.min;
	}
	
	public Range combineWith(Range r2){
		if(!this.overlaps(r2)){
			return null;
		}
		double newMin;
		double newMax;
		if(this.min > r2.min){
			newMin = r2.min;
		}else{
			newMin = this.min;
		}
		
		if(this.max > r2.max){
			newMax = this.max;
		}else{
			newMax = r2.max;
		}
		return new Range(newMin, newMax);
	}
	
	public boolean equals(Range r2){
		return this.max == r2.max && this.min == r2.min;
	}
	
	public String toString(){
		return  "("+this.min + "," + this.max+")";
	}
}
