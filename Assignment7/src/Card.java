
/*
 * Card class
 * Author: Thomas Hocking
 * CS 251
 * Assignment #7.
 * 
 * Card class represents a card inside of a standard deck of cards.
 * Contains a number and a suit, also has a toString method that prints face of card, and suit associated with it.
 */

public class Card {
	private int number;
	private int suit;
	
	public Card(int number, int suit){
		this.number = number;
		this.suit = suit;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public int getSuit(){
		return this.suit;
	}
	
	public int compareForSort(Card c1, Card c2){
		if(c1.suit == c2.suit){
			if(c1.number > c2.number)
				return 1;
			else if(c1.number == c2.number)
				return 0;
			else
				return -1;
		}else if(c1.suit > c2.suit)
			return 1;
		else{
			return -1;
		}
	}
	
	public String toString(){
		String[] lettersOfSuits = {"c", "d", "h", "s"};
		String letterOfSuit = "";
		for(int i = 0; i < lettersOfSuits.length; i++){
			if(i+1 == this.suit){
				letterOfSuit = lettersOfSuits[i];
				if(this.number == 1)
					return "A" + "" + letterOfSuit;
				else if(this.number == 13)
					return "K" + "" + letterOfSuit;
				else if(this.number == 12)
					return "Q" + "" + letterOfSuit;
				else if(this.number == 11)
					return "J" + "" + letterOfSuit;
				}
		}
		return this.number + "" + letterOfSuit;
	}
}
