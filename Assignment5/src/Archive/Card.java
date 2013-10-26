/*
 * Card class.
 * Author: Thomas Hocking
 * CS 251
 * Assignment #5.
 * 
 * Class provides basic idea of what a Card represents.
 */

public class Card {
	
	private int number;
	private char color;
	
	public Card(int number, char color){
		this.number = number;
		this.color = color;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public char getColor(){
		return this.color;
	}
	
	public String toString(){
		return this.color + "" + this.number;
	}
}
