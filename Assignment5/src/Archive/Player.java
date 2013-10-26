/*
 * Player class.
 * Author: Thomas Hocking
 * CS 251
 * Assignment #5.
 * 
 * Class provides functionality for player playing the game.
 * Player has a name, and holds 3 cards at random.
 */

public class Player {
	private String name;
	private Card card1;
	private Card card2;
	private Card card3;
	
	public Player(String name, Card c1, Card c2, Card c3){
		this.name = name;
		this.card1 = c1;
		this.card2 = c2;
		this.card3 = c3;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Card getCard(int cardNum){
		if(cardNum == 1)
			return card1;
		else if(cardNum == 2)
			return card2;
		else if(cardNum == 3)
			return card3;
		else
			return null;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setCard(int cardNum, Card c){
		if(cardNum == 1)
			this.card1 = c;
		else if(cardNum == 2)
			this.card2 = c;
		else if(cardNum == 3)
			this.card3 = c;
		else
			System.out.println("Cannot initalize card with: " + cardNum);
	}
	
	public int getNumOfColors(){
		
		int redCount = 0;
		int blueCount = 0;
		int greenCount = 0;
		
		Card[] arrayOfCards = {this.card1, this.card2, this.card3};
		for(int i = 0; i < arrayOfCards.length; i++){
			switch(arrayOfCards[i].getColor()){
				case 'R': redCount++;
				break;
				
				case 'r': redCount++;
				break;
				
				case 'B': blueCount++;
				break;
				
				case 'b': blueCount++;
				break;
				
				case 'G': greenCount++;
				break;
				
				case 'g': greenCount++;
				break;
			}
		}
		return redCount + blueCount + greenCount;
	}
	
	public int getNumNumbers(){
		
		int oneCount = 0;
		int twoCount = 0;
		int threeCount = 0;
		
		Card[] arrayOfCards = {this.card1, this.card2, this.card3};
		for(int i = 0; i < arrayOfCards.length; i++){
			switch(arrayOfCards[i].getNumber()){
				case 1: oneCount++;
				break;
				
				case 2: twoCount++;
				break;
				
				case 3: threeCount++;
				break;
				
			}
		}
		return oneCount + twoCount + threeCount;
	}
	
	public String toString(){
		return this.name + " " + this.card1 + " " + this.card2 + " " + this.card3; 
	}
}
