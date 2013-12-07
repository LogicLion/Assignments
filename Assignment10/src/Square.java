import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;


public class Square extends JButton {
	
	private int state;
	public final static int QUEEN = 1;
	public final static int DANGER = 2;
	public final static int OPEN = 3;
	
	private static Image queen;
	
	public Square(){
		super.setContentAreaFilled(false);
		state = OPEN;
		addActionListener(new Listener());
	}

	private static Image getQueen() {
		if ( queen == null ) {
			//load queen
			BufferedImage ibuf;
			try {
				ibuf = ImageIO.read(new File("queen-icon.jpeg"));
				queen = ibuf;
			} catch (IOException e) {
				System.out.println("Cannot find image.");
			}
		}
		return queen;
	}
	
	private class Listener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			if(state == OPEN) state = QUEEN;
			
		}
		
	}
	
	public int getState(){
		return this.state;
	}
	
	public void markUnsafe(){	
		if ( state != QUEEN ) {
			setBackground(Color.red);
			this.state = DANGER;
		}
	}
	
	public void clear(){
		setBackground(Color.white);
		this.state = OPEN;
	}
	
	protected void paintComponent(Graphics g){
		if ( state == QUEEN) {
			g.drawImage(getQueen(), 0, 0, getWidth(), getHeight(), null);			
		} else {
			g.setColor(getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		super.paintComponent(g);
	}
	
}
	