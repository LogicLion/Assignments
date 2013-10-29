import java.util.ArrayList;
import java.util.Random;

/*
 * RouletteTest class
 * Author: Thomas Hocking
 * CS 251
 * Assignment #6.
 * 
 * RouletteTest class for simulating a Roulette wheel.
 * Provides methods such as Standard Deviation, and Hottest/Coldest pocket value.
 */

public class RouletteTest {
	private static final int NUM_POCKETS = 38;
	private int[] pocketCount = new int[NUM_POCKETS];
	private int numSpins;
	
	public RouletteTest(int theNumSpins){
		this.numSpins = theNumSpins;
		Random generator = new Random();
		int winningPocket;
		for(int i = 1; i <= theNumSpins; i++){
			winningPocket = generator.nextInt(NUM_POCKETS);
			pocketCount[winningPocket] = pocketCount[winningPocket] + 1;
		}
	}
	
	public void getNumSpins(int numOfSpins){
		this.numSpins = numOfSpins;
	}
	
	public void printStats(){
		for(int i = 0; i < pocketCount.length; i++){
			System.out.println(pocketCount[i]);
	}
		
		int hottestIndex = this.getHottestPocket();
		System.out.println("Hottest Pocket:" + hottestIndex + " with a value of: " + this.getPocketCount(hottestIndex));
		System.out.println();
	}
	
	public int getHottestPocket(){
		int hottestPocket = pocketCount[0];
		int indexOfHottestPocket = 0;
		
		for(int i = 0; i < pocketCount.length; i++){
			if(hottestPocket < pocketCount[i]){
				hottestPocket = pocketCount[i];
				indexOfHottestPocket = i;
			}
		}
		return indexOfHottestPocket;
	}
	
	
	public int getColdestPocket(){
		int coldestPocket = pocketCount[0];
		int indexOfColdestPocket = 0;
		
		for(int i = 0; i < pocketCount.length; i++){
			if(coldestPocket > pocketCount[i]){
				pocketCount[i] = coldestPocket;
				indexOfColdestPocket = i;
			}	
		}
	
		 
		return indexOfColdestPocket;
	}
	
	public int getPocketCount(int numPocket){
		return pocketCount[numPocket];
	}
	
	public double getStdDev(){
		double accumulator = 0;
		double mean = getMean();
		
		for(int i = 0; i < pocketCount.length; i++){
			accumulator+=Math.pow((pocketCount[i] - mean),2);
		}
		
		return Math.sqrt(accumulator/(this.numSpins-1));
	}

	private double getMean(){
			return this.numSpins / pocketCount.length;
	}
	
	public String toString(){
		String stringToReturn = "";
		for(int i = 0; i < pocketCount.length; i++){
			if(i%5==0){
				stringToReturn+="\n";
			}
			
			stringToReturn += " " + pocketCount[i];
			
			//if(i==1||i==36){
				//stringToReturn+="\n";
			//}
		}
		return "[ " + stringToReturn + "\n\t\t]";  
	}
	
	 
}
