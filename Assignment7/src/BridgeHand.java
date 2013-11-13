import java.util.ArrayList;

/*
 * BridgeHand class
 * Author: Thomas Hocking
 * CS 251
 * Assignment #7.
 * 
 * BridgeHand class is a class that represents a hand of Bridge Cards.
 * It uses an ArrayList data structure to hold cards. It then uses insertion sort, and a compares method inside of Card to sort.
 * Also can calulate points inside of hand.
 */

public class BridgeHand {
	private ArrayList<Card> hand;
	
	public BridgeHand(){
		hand = new ArrayList<Card>();
	}
	
	public void addCard(Card c){
		Card tempCard;
		this.hand.add(c);	
		
		for(int i = 1; i < this.hand.size(); i++){
			for(int j = i; j > 0; j--){
				
				if(this.hand.get(j).compareForSort(this.hand.get(j), this.hand.get(j-1)) > 0){
					tempCard = this.hand.get(j);
					this.hand.set(j, this.hand.get(j-1));
					this.hand.set(j-1, tempCard);
				}
			}
		}
	}
	
	public int getBiddingPoints(){
		int biddingPoints = 0;
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).getNumber()==1)
				biddingPoints+=4;
			else if(hand.get(i).getNumber()==13)
				biddingPoints+=3;
			else if(hand.get(i).getNumber()==12)
				biddingPoints+=2;
			else if(hand.get(i).getNumber()==11)
				biddingPoints++;
		}
		return biddingPoints;
	}
	
	public String toString(){
		String listOfCardsInHand = "";
		listOfCardsInHand += "["+hand.get(0);
		for(int i = 1; i < hand.size()-1; i++){
			listOfCardsInHand += (", " + hand.get(i));
		}
		listOfCardsInHand += (", " +hand.get(hand.size()-1) +"]");
		return listOfCardsInHand;
	}
}
