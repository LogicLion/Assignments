import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;


public class EightQueens extends JFrame {
	private Square[][] board = new Square[8][8];
	private int queenCount;
	private int nWins;
	private int nLosses;
	
	
	public EightQueens(){
		setTitle("Eight Queens");
		setSize(600,400);
		setLayout(new GridLayout(8,8));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setVisible(true);
	}
	
	private void createContents(){
		//create board.
		for(int i = 0; i < board.length; i++){
			board[i] = new Square[board.length];
			for(int j = 0; j < board.length; j++){
				add(board[i][j] = new Square());
			}
		}
		
	}
	
	public void markSquares(){
		
	}
	
	public void markSquaresForOneQueen(int qRow, int qCol){
		
	}
	
	public static void main(String[] args) {
		try {
		//Set cross-platform Java L&F (also called "Metal") 
		UIManager.setLookAndFeel(
		UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e) {
		// handle exception new EightQueens();
		}
		new EightQueens();
	}
}
