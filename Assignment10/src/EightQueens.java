import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class EightQueens extends JFrame {
	private Square[][] board = new Square[8][8];
	private JPanel boardOfSquares = new JPanel(new GridLayout(8,8));
	private JPanel ctrlAndInfoPanel = new JPanel(new GridLayout(10,2));
	private int queenCount;
	private int nWins;
	private int nLosses;
	
	
	public EightQueens(){
		setTitle("Eight Queens");
		setSize(800,600);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setVisible(true);

	}
	
	private class Listener implements ActionListener {
		ActionListener pre;
		
		Listener( ActionListener al ) {
			pre = al;
		}	
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			pre.actionPerformed(arg0);
			markSquares();
		}
	}
	
	private void createContents(){
		//create board.
		for(int i = 0; i < board.length; i++){
			board[i] = new Square[board.length];
			for(int j = 0; j < board.length; j++){
				board[i][j] = new Square();
				ActionListener pre = board[i][j].getActionListeners()[0];
				board[i][j].removeActionListener(pre);
				board[i][j].addActionListener(new Listener(pre));
				boardOfSquares.add(board[i][j]);	
			}
		}
		ctrlAndInfoPanel.setPreferredSize(new Dimension(200, 600));
		ctrlAndInfoPanel.add(new JLabel("Controls", JLabel.CENTER));
		ctrlAndInfoPanel.add(new JLabel("Show unsafe spaces?", JLabel.CENTER));
		add(ctrlAndInfoPanel,BorderLayout.EAST);
		add(boardOfSquares,BorderLayout.CENTER);

	}
	
	public void markSquares(){
		System.out.println("Marking squares");
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				if(board[i][j].getState() == Square.QUEEN){
					//System.out.println("Found a queen at: " + (i+1) + "," +  (j+1) );
					markSquaresForOneQueen(i,j);
				}
			}
		}
	}
	
	public void markSquaresForOneQueen(int qRow, int qCol){
	
		int x = qRow;
		int y = qCol;
		
		if ( x < y ) {
			y -= x;
			x = 0;
		} else {
			x -= y;
			y = 0;
		}
		while ( x < board.length && y < board.length) {
			System.out.println ( "X: " + x + ", Y: " + y);
			board[x][y].markUnsafe();
			x++;
			y++;
		}
		
		
		y = qCol;
		for(int i = 0; i < board.length; i++){
			board[i][y].markUnsafe();
		}
		
		x = qRow;
		for(int i = 0; i < board.length; i++){
			board[x][i].markUnsafe();
		}
		
		x = qRow;
		y = qCol;
		
		if ( x < board.length - y ) {
			System.out.println ("X < Y" + "X:" + x + ",Y:" + y);
			x += y;
			y = 0;
		} else {
			System.out.println("Y <= X" + "X:" + x + ",Y:" + y);
			y -= board.length - 1 - x;
			x = board.length - 1;
		}
		
		System.out.println("Starting /");
		
		while( 0 <= x && y < board.length ) {
			System.out.println( "X: " + x + ", Y: " + y);
			board[x][y].markUnsafe();
			y++;
			x--;
		}
		
		
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
