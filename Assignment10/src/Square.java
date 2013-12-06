import java.awt.Graphics;

import javax.swing.JButton;


public class Square extends JButton {
	
	private int state;
	
	
	public Square(){
		super.setContentAreaFilled(false);
	}
	
	public int getState(){
		return this.state;
	}
	
	public void markUnsafe(){	
		
	}
	
	public void clear(){
		
	}
	
	protected void paintComponent(Graphics g){
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
	}
}
	