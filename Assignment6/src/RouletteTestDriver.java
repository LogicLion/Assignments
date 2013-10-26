import java.util.ArrayList;
import java.util.Scanner;


public class RouletteTestDriver {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Roulette Simulator!");
		System.out.print("Enter number of roulette tests to run: ");
		int numOfTests = input.nextInt();
		System.out.print("Enter number of spins per test: ");
		int numOfSpins = input.nextInt();
		
		RouletteTest test = new RouletteTest(numOfSpins);
		System.out.println(test.getStdDev());
		
		RouletteTest[] rouletteTests = new RouletteTest[numOfTests];
		
		for(int i = 0; i < numOfTests; i++){
			rouletteTests[i] = new RouletteTest(numOfSpins);
		}
		
		System.out.print("Least Variable Test: ");
		printTestSummary(rouletteTests[getTestWithLowestStdDiv(rouletteTests)]);
		System.out.println();
		System.out.print("Most Variable Test: ");
		printTestSummary(rouletteTests[getTestWithHighestStdDiv(rouletteTests)]);
		System.out.println();
		sortRouletteTest(rouletteTests);
		System.out.println("");
		printTestSummary(rouletteTests);
	
		
	}
	
	private static void sortRouletteTest(RouletteTest[] rTests){
		double[] listOfStdDivs = new double[rTests.length];
		for(int i = 0; i < rTests.length; i++){
			listOfStdDivs[i] = rTests[i].getStdDev();
		}
		listOfStdDivs = insertionSort(listOfStdDivs);
	}
	
	private static void printTestSummary(RouletteTest test){
			System.out.print("Standard Div: " + test.getStdDev() + ", Hottest: " + test.getHottestPocket() + " (" + test.getPocketCount(test.getHottestPocket()) + ")" 
					+ ", Coldest: " + test.getColdestPocket() + " (" + test.getPocketCount(test.getColdestPocket()) + ")");
	
	}
	
	private static void printTestSummary(RouletteTest[] rTest){
		for(int i = 0; i < rTest.length; i++){
			System.out.println("Standard Div: " + rTest[i].getStdDev() + ", Hottest: " + rTest[i].getHottestPocket() + " (" + rTest[i].getPocketCount(rTest[i].getHottestPocket()) + ")" 
					+ ", Coldest: " + rTest[i].getColdestPocket() + " (" + rTest[i].getPocketCount(rTest[i].getColdestPocket()) + ")");
		}
	}
	
	public static double[] insertionSort(double[] nums){
		double tempVal;
		for(int i = 1; i < nums.length; i++){
			for(int j = i; j > 0; j--){
				if(nums[j] < nums[j-1]){
					tempVal = nums[j];
					nums[j] = nums[j-1];
					nums[j] = tempVal;
				}
			}
		}
		return nums;
	 }
	
	private static int getTestWithLowestStdDiv(RouletteTest[] rTest){
		double startingStdDiv = rTest[0].getStdDev();
		int indexOfLowestStdDiv= 0;
		
		for(int i = 0; i < rTest.length; i++){
			if(startingStdDiv > rTest[i].getStdDev()){
				startingStdDiv = rTest[i].getStdDev();
				indexOfLowestStdDiv = i;
			}
		}
		return indexOfLowestStdDiv;
	}
	
	private static int getTestWithHighestStdDiv(RouletteTest[] rTest){
		double startingStdDiv = rTest[0].getStdDev();
		int indexOfHighestStdDiv = 0;
		
		for(int i = 0; i < rTest.length; i++){
			if(startingStdDiv < rTest[i].getStdDev()){
				startingStdDiv = rTest[i].getStdDev();
				indexOfHighestStdDiv = i;
			}
		}
		return indexOfHighestStdDiv;
	}
}	
