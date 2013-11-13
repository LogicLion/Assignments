/*
 * BridgeHandDriver class
 * Author: Thomas Hocking
 * CS 251
 * Assignment #7.
 * 
 * BridgeHandDriver class allows testing of BridgeHand, Card, and CardDeck classes.
 * Tests deck with 4 hands, calculates total bidding points, and prints out the sorted hands.
 */


public class BridgeHandDriver {
	public static void main(String[] args){
		System.out.println("Welcome to Bridge Dealer Program.");
		System.out.println("Here are 4 hands.\n");
		CardDeck deckOfCards = new CardDeck();
		BridgeHand h1 = new BridgeHand();
		BridgeHand h2 = new BridgeHand();
		BridgeHand h3 = new BridgeHand();
		BridgeHand h4 = new BridgeHand();
		
		BridgeHand[] bridgeHands = {h1,h2,h3,h4};
		
		for(int i = 0; i < 4; i++){
			for(int j = 1; j < 14; j++){
				bridgeHands[i].addCard(deckOfCards.nextCard());
			}
		}
		
		for(int i = 0; i < 4; i++){
			System.out.println("Hand " + (i+1) +" "+ "(Total Points: " + bridgeHands[i].getBiddingPoints() + ") " + bridgeHands[i]);
		}
	}
}
