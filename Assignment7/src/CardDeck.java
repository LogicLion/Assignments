import java.util.ArrayList;
import java.util.Random;

/*
 * CardDeck class
 * Author: Thomas Hocking
 * CS 251
 * Assignment #7.
 * 
 * CardDeck class for representing a standard deck of 52 cards.
 * Has a method to deal random card, and remove it from its deck.
 */

public class CardDeck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	Random rand = new Random();
	
	public CardDeck(){
		for(int i = 1; i < 14; i++){
			deck.add(new Card(i, 1));
			deck.add(new Card(i, 2));
			deck.add(new Card(i, 3));
			deck.add(new Card(i, 4));
		}
	}
	
	public Card nextCard(){
		if (deck.isEmpty()) 
			return null;
		else {
			int index = rand.nextInt(deck.size());
			return deck.remove(index);
		}
	}
}
