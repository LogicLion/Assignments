import java.util.ArrayList;
import java.util.Random;


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
	
	public RouletteTest(){
		this.pocketCount[0]=1;
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
		double summation = 0;
		double stdDev = 0.0;
		//double mean = getMean();
		for(int i = 0; i < pocketCount.length; i++){
			summation += Math.pow((pocketCount[i]-(this.numSpins/pocketCount.length)),2);
		}
		stdDev = Math.sqrt(summation/this.numSpins - 1);
		return stdDev;
	}
	
	public double getMean(){
		double accumulator = 0.0;
		for(int i = 0; i < pocketCount.length; i++){
			accumulator += pocketCount[i];
		}
		return accumulator/pocketCount.length;
	}
	
	public String toString(){
		String stringToReturn = "";
		for(int i = 0; i < pocketCount.length; i++){
			if(i%5==0){
				stringToReturn+="\n\t";
			}
			
			stringToReturn += " " + pocketCount[i];
			
			if(i==1||i==36){
				stringToReturn+="\n";
			}
		}
		return "[ " + stringToReturn + " ]";  
	}
	
	 
}
