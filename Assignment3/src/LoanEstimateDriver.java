import java.util.Scanner;

/*
 * Loan Estimate Drive class
 * Author: Thomas Hocking
 * CS 251
 * Assignment #3.
 * 
 * Driver class for testing Loan Estimate class.
 * Provides testing for 2 loans, and computes their values and compares.
 */

public class LoanEstimateDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Loan Estimation program!\n");

		LoanEstimate loan1 = new LoanEstimate();
		LoanEstimate loan2 = new LoanEstimate();
	
		setLoanInfo(sc, loan1);
		setLoanInfo(sc, loan2);
		
		LoanEstimate[] listOfLoans = {loan1, loan2};
		
		printLoanEstimates(listOfLoans);
		compareLoans(loan1, loan2);
				
	}
	
	//Method for setting values from user, passes in scanner, and a loan to setup.
	public static void setLoanInfo(Scanner sc, LoanEstimate loan){
		
		double principal, intRate;
		int years;
		
		do {
			System.out.print("Enter amount to borrow for Loan: ");
			principal = sc.nextDouble();
			if (principal <= 0.0)
				System.out.println("ERROR: amount must be positive!");
		} while (principal <= 0.0);
		loan.setPrincipal(principal);
		
		do {
			System.out.print("Enter years for Loan: ");
			years = sc.nextInt();
			if (years <= 0)
				System.out.println("ERROR: amount must be positive!");
		} while (years <= 0);
		loan.setYears(years);
		
		do {
			System.out.print("Enter percentage interest rate for Loan: ");
			intRate = sc.nextDouble();
			if (intRate <= 0.0)
				System.out.println("ERROR: amount must be positive!");
		} while (intRate <= 0.0);
		loan.setAnnualPercentRate(intRate);
	}
	
	//Prints loan estimates 
	public static void printLoanEstimates(LoanEstimate[] listOfLoans){
		System.out.println();
		System.out.println("Loan Comparison");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		for(int i = 0; i < listOfLoans.length; i++){
			System.out.printf("Loan %d:" , i+1);
			System.out.println(listOfLoans[i]);
			System.out.printf("Loan %d Monthly Payment:$%,.2f \n", i+1, listOfLoans[i].getMonthlyPayment());
			System.out.printf("Loan %d Total Cost: $%,.2f \n",i+1, listOfLoans[i].getTotalCost());
			System.out.printf("Loan %d Total Interest: %.3f \n",i+1, listOfLoans[i].getTotalInterest());
			System.out.println();
		}
	}
	
	public static void compareLoans(LoanEstimate loan1, LoanEstimate loan2){
		if(loan1.getMonthlyPayment() < loan2.getMonthlyPayment()){
			System.out.printf("Loan 1 has the lowest monthly payment, costing $%,.2f less per month \n", loan2.getMonthlyPayment()-loan1.getMonthlyPayment());
		}else{
			System.out.printf("Loan 2 has the lowest monthly payment, costing $%,.2f less per month \n", loan1.getMonthlyPayment()-loan2.getMonthlyPayment());
		}
		
		if(loan1.getTotalInterest() < loan2.getTotalInterest()){
			System.out.printf("Loan 1 has the lowest interest cost, costing $%,.2f less overall \n", loan2.getTotalInterest()-loan1.getTotalInterest());
		}else{
			System.out.printf("Loan 2 has the lowest interest cost, costing $%,.2f less overall \n", loan1.getTotalInterest()-loan2.getTotalInterest());
		}
	}
}