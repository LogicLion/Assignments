/*
 * LoanEstimate class.
 * Author: Thomas Hocking
 * CS 251
 * Assignment #3.
 * 
 * Class provides functionality for loan estimation.
 * allows principal, years, and percent rate to be set.
 */


public class LoanEstimate {
	private double principal;
	private int years;
	private double annualPercentRate;
	
	public double getPrincipal() {
		return principal;
	}
	
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public double getAnnualPercentRate() {
		return annualPercentRate;
	}
	public void setAnnualPercentRate(double annualPercentRate) {
		this.annualPercentRate = annualPercentRate;
	}		
	
	public double getMonthlyPayment(){
		double i = (getAnnualPercentRate() / 100) / 12;
		int N = getYears() * 12;
		double monthlyPayment = i*((getPrincipal()*(Math.pow((1+i), N))/(Math.pow(1+i, N) -1)));
		return monthlyPayment;
	}
	
	public double getTotalInterest(){
		return getTotalCost() - getPrincipal();
	}
	
	public double getTotalCost(){
		return getMonthlyPayment() * (getYears() * 12);
	}
	
	public String toString(){
		String loanStringFormatted = String.format("$%,.0f for %d years at %.3f%%" ,this.getPrincipal(), this.getYears(), this.getAnnualPercentRate());
		return loanStringFormatted;
	}
}
