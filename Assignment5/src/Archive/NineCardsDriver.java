import java.util.Scanner;



public class NineCardsDriver {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		CardDeck deckOfCards = new CardDeck();
		NineCardsDriver gameDriver = new NineCardsDriver();
		
		System.out.println("Welcome to the Nine Cards Program");
		System.out.println();
		System.out.print("Enter name of Player 1: ");
		Player player1 = new Player(input.nextLine(), deckOfCards.nextCard(), deckOfCards.nextCard(), deckOfCards.nextCard());
		System.out.print("\nEnter name of Player 2: ");
		Player player2 = new Player(input.nextLine(), deckOfCards.nextCard(), deckOfCards.nextCard(), deckOfCards.nextCard());
		System.out.print("\nEnter name of Player 3: ");
		Player player3 = new Player(input.nextLine(), deckOfCards.nextCard(), deckOfCards.nextCard(), deckOfCards.nextCard());
		gameDriver.printStats(player1, player2, player3);
		Player[] listOfPlayers = {player1, player2, player3};
		
		while(! gameDriver.isPuzzleSolved(player1, player2, player3)){
			int firstPlayerNum = 0;
			int firstCardToSwap = 0;
			do{
			System.out.println("\nEnter number of first player and card to swap (space separated): ");
				firstPlayerNum = input.nextInt();
				firstCardToSwap = input.nextInt();
			}while((firstPlayerNum > 3 || firstPlayerNum < 1) && (firstCardToSwap > 3 || firstCardToSwap < 1));
			
			int secondPlayerNum = 0;
			int secondCardToSwap = 0;
			
			do{
				System.out.println("Enter number of second player and card to swap (space separated): ");
					secondPlayerNum = input.nextInt();
					secondCardToSwap = input.nextInt();
				}while((secondPlayerNum > 3 && secondPlayerNum < 1) && (secondCardToSwap > 3 && secondCardToSwap < 1) && secondPlayerNum == firstPlayerNum);
			
			firstPlayerNum--;
			secondPlayerNum--;
			gameDriver.swap(listOfPlayers[firstPlayerNum], listOfPlayers[secondPlayerNum], firstCardToSwap, secondCardToSwap);		
			gameDriver.printStats(player1, player2, player3);
		}
		
		System.out.println("This is how the cards were at the end: \n");
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		System.out.println("\nGoodbye!");
	}
	
	private boolean puzzleSolved(Player p1, Player p2, Player p3){
		
		Player[] listOfPlayers = {p1,p2,p3};
		
		for(int i = 0; i < listOfPlayers.length; i++){
			if(listOfPlayers[i].getCard(1).getColor() == listOfPlayers[i].getCard(2).getColor() && listOfPlayers[i].getCard(2).getColor() == listOfPlayers[i].getCard(3).getColor()){
				return true;
			}else if(listOfPlayers[i].getCard(1).getNumber() == listOfPlayers[i].getCard(2).getNumber() && listOfPlayers[i].getCard(2).getNumber() == listOfPlayers[i].getCard(3).getNumber()){
				return true;
			}
		}
		return false;
	}
	
	private void printGameStatus(Player p1, Player p2, Player p3){
		System.out.println("\n Game Status");
		System.out.println("=_=_=_=_=_=_=_=_=");
		System.out.println("Player 1 " + "(" + p1.getName() + "): " + p1.getNumOfColors() + " colors, " + p1.getNumNumbers() + " numbers");
		System.out.println("Player 2 " + "(" + p2.getName() + "): " + p2.getNumOfColors() + " colors, " + p2.getNumNumbers() + " numbers");
		System.out.println("Player 3 " + "(" + p3.getName() + "): " + p3.getNumOfColors() + " colors, " + p3.getNumNumbers() + " numbers");
	}
	
	public void swap(Player p1, Player p2, int p1CardNum, int p2CardNum){
		Card tempCard = p1.getCard(p1CardNum);
		p1.setCard(p1CardNum, p2.getCard(p2CardNum));
		p2.setCard(p2CardNum, tempCard);
	}
	
	public boolean isPuzzleSolved(Player p1, Player p2, Player p3){
		boolean gameState = this.puzzleSolved(p1, p2, p3);
		return gameState;
	}
	
	public void printStats(Player p1, Player p2, Player p3){
		this.printGameStatus(p1, p2, p3);
	}
}
