import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class EightQueens extends JFrame {
	private Square[][] board = new Square[8][8];
	private JPanel boardOfSquares = new JPanel(new GridLayout(8,8));
	private JPanel ctrlAndInfoPanel = new JPanel(new GridLayout(11,1));
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
		
		//create control and info panel.
		ctrlAndInfoPanel.setPreferredSize(new Dimension(200, 600));
		ctrlAndInfoPanel.add(new JLabel("Controls", JLabel.CENTER));
		ctrlAndInfoPanel.add(new JLabel("Show unsafe spaces?", JLabel.CENTER));
		JRadioButton alwaysBtn = new JRadioButton("Always");
		ctrlAndInfoPanel.add(alwaysBtn);
		JRadioButton whenPressedBtn = new JRadioButton("When Mouse Pressed");
		ctrlAndInfoPanel.add(whenPressedBtn);
		ButtonGroup groupOfButtons = new ButtonGroup();
		
		groupOfButtons.add(alwaysBtn);
		groupOfButtons.add(whenPressedBtn);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setSize(50, 50);
		buttonPanel.add(new JButton("Start Over"));
		ctrlAndInfoPanel.add(buttonPanel);
		JPanel statusPanel = new JPanel(new GridLayout(3,3));
		statusPanel.add(new JLabel("Last Result: "));
		statusPanel.add(new JTextField(""));

		statusPanel.add(new JLabel("Wins: "));
		statusPanel.add(new JTextField(""));

		statusPanel.add(new JLabel("Looses: "));
		statusPanel.add(new JTextField(""));

		ctrlAndInfoPanel.add(statusPanel);
		
		add(ctrlAndInfoPanel,BorderLayout.EAST);
		add(boardOfSquares,BorderLayout.CENTER);

	}
	
	public void markSquares(){
		//System.out.println("Marking squares");
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				if(board[i][j].getState() == Square.QUEEN){
					//System.out.println("Found a queen at: " + (i+1) + "," +  (j+1) );
					markSquaresForOneQueen(i,j);
				}
			}
		}
		
		//check to see if last queen.
		int queenCount = 0;
		int openCount = 0;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				if(board[i][j].getState() == Square.QUEEN){
					queenCount++;
				}else if(board[i][j].getState() == Square.OPEN){
					openCount++;
				}
			}
		}
		
		if(queenCount == 8 && openCount == 0){
			System.out.println("You win!");
		}else if(openCount == 0 && queenCount < 8){
			System.out.println("You loose!");
		}
		
	}
	
	public void markSquaresForOneQueen(int qRow, int qCol){
		this.markDiagonal(qRow, qCol);
		this.markTopAndBottom(qCol);
		this.markLeftAndRight(qRow);
	}
	
	private void markDiagonal(int qRow, int qCol){
		//NW and SE diag marking.
		int rowOfPlacedQueen = qRow;
		int colOfPlacedQueen = qCol;
		
		if (rowOfPlacedQueen < colOfPlacedQueen) {
			colOfPlacedQueen -= rowOfPlacedQueen;
			rowOfPlacedQueen = 0;
		} else {
			rowOfPlacedQueen -= colOfPlacedQueen;
			colOfPlacedQueen = 0;
		}
		for(int i = rowOfPlacedQueen, j = colOfPlacedQueen; (i < board.length && j < board.length); i++, j++){
			board[i][j].markUnsafe();
		}
		
		//Mark NE and SW
		rowOfPlacedQueen = qRow;
		colOfPlacedQueen = qCol;
		
		if(rowOfPlacedQueen < board.length - colOfPlacedQueen) {
			rowOfPlacedQueen += colOfPlacedQueen;
			colOfPlacedQueen = 0;
		}else{
			colOfPlacedQueen -= board.length - 1 - rowOfPlacedQueen;
			rowOfPlacedQueen = board.length - 1;
		}
				
		for(int i = rowOfPlacedQueen, j = colOfPlacedQueen; (i >= 0 && j < board.length); i--, j++){
			board[i][j].markUnsafe();
		}
	}
	
	private void markTopAndBottom(int qCol){
		//Mark top and down.
		for(int i = 0; i < board.length; i++){
			board[i][qCol].markUnsafe();
		}
	}
	
	private void markLeftAndRight(int qRow){
		//Mark left and right.
		for(int i = 0; i < board.length; i++){
			board[qRow][i].markUnsafe();
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
