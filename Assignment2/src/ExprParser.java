/*
 * Expression Parser.
 * A program made by: Thomas Hocking.
 * CS 251
 * Assignment #2.
 * 
 * Purpose of program is to parse and compute expressions.
 * Program accepts a string input of a whole line and computes the string into a series of expressions.
 * Program only accepts the addition operation, as well as negative or positive integers ranging from 0-9.
 */


import java.util.Scanner;


public class ExprParser {
	public static void main(String[] args){
		System.out.println("Welcome to the Expression Parser!");
		System.out.println("Please enter in an expression: ");
		Scanner input = new Scanner(System.in);
		String userEnteredExpression = input.nextLine();
		parseExpression(userEnteredExpression);
	}

	
	//Main method that gets called on user entered expression.
	//Resposible for breaking down expression into subexpressions, and then computing them.
	public static void parseExpression(String expression)
	{
		int numOfSubExpressions = numberOfValidSubExpressions(expression);
		if(numOfSubExpressions > 1){
			String[] arrayOfSubExpressions = new String[numOfSubExpressions];
			arrayOfSubExpressions = createSubExpressions(numOfSubExpressions, expression, arrayOfSubExpressions);
			for(int i = 0; i < arrayOfSubExpressions.length; i++){
				computeExpression(arrayOfSubExpressions[i]);
			}
		}else{
			expression = checkSingleExpressionForErrors(expression);
			computeExpression(expression);
		}
	}

	//Creates subexpressions based on number of them inside of main expression, also passes in array to hold onto all of the subexpressions.
	public static String[] createSubExpressions(int numOfSubExpressions, String mainExpression, String[] arrayToHoldSubExpressions){
		for(int i = 0; i < arrayToHoldSubExpressions.length; i++){
			int startIndex = mainExpression.indexOf('(');
			int endIndex = mainExpression.indexOf(')');
			//check to make sure subexpression beings with '(' and ends in ')'
			if(startIndex != -1 && endIndex != -1)
			{
				arrayToHoldSubExpressions[i] = mainExpression.substring(startIndex, endIndex + 1);
				int newStartIndex = endIndex + 1;
				mainExpression = mainExpression.substring(newStartIndex,  mainExpression.length());
			}
		}
		
		return arrayToHoldSubExpressions;
	}
	
	//Method combs through main expression and finds total number of valid sub expressions 
	public static int numberOfValidSubExpressions(String expression){
		int numOfSubExpressions = 0;
		for(int i = 0; i < expression.length(); i++){
			if(expression.charAt(i) == '(')
			{
				for(int j = i; j < expression.length(); j++){
					if(expression.charAt(j) == ')'){
						numOfSubExpressions++;
						j = expression.length();
					}
				}
			}
		}
		return numOfSubExpressions;
	}
	
	//Takes subexpression and computes the values contained inside of it.
	//Checks to make sure that no expressions get computed that contain values other than '(', ')', +, - and digits.
	public static void computeExpression(String expression){
		int accumulator = 0;
		int number = 0;
		boolean parseSuccess = true;
		int startIndex = expression.indexOf('(');
		int endIndex = expression.indexOf(')');
		if(endIndex == startIndex + 1){
			System.out.println("Empty Expression: " + expression);
		}else if(startIndex != -1 && endIndex != -1)
			{
				System.out.println("Computing expression: " + expression);
				for(int i = 1; i < expression.length()-1; i++)
				{			
					//check for validity inside of each index of expression.
					if(!Character.isDigit(expression.charAt(i))
							&& expression.charAt(i) != '-' 
							&& !Character.isWhitespace(expression.charAt(i))
							&& expression.charAt(i) != '+')
					{
						//On fail, report unknown character, move to next expression.
						System.out.println("Unknown character: " + expression.charAt(i) + " cannot parse expression.");
						parseSuccess = false;
						i = expression.length()-1;
						}else{
							if(Character.isDigit(expression.charAt(i))){
								number = Integer.parseInt(expression.substring(i, i+1));
								accumulator += number;
							}else if(expression.charAt(i) == '-'){
								number = Integer.parseInt(expression.substring(i, i+2));
								accumulator += number;
								i++;
							}
						}
				}
			if(parseSuccess){
				System.out.println(expression + " equals: " + accumulator);
			}
		}else{
			System.out.println("Improperly formed");
		}
		System.out.println("Goodbye!'");
	}
	
	//If single expression is found, it will parse only expression found inside of '(', ')'. Other external 'garbage' will be discarded and not computed/parsed.
	public static String checkSingleExpressionForErrors(String expression){
		if(expression.indexOf('(') == -1){
			expression = expression.substring(0, expression.length());
		}else{
			expression = expression.substring(expression.indexOf('('), expression.indexOf(')') + 1);
		}
		return expression;
	}
}
