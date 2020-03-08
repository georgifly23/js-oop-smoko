import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener , ActionListener{
	
	private int[] snakeXlenght = new int[750];
	private int[] snakeYlenght = new int[750];
	
	private boolean right = false;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;

	private ImageIcon rightPosition;
	private ImageIcon leftPosition;
	private ImageIcon upPosition;
	private ImageIcon downPosition;
	
	private int lenghtofsnake = 3;
	
	private Timer timer;
	private int delay = 100;
	
	private ImageIcon snakeImage;
	
	private int [] foodXposition = {};
	private int [] foodYposition = {};  
	
	private ImageIcon foodimage;
	
	private Random random = new Random();
	
	private int moves = 0;
	
	private ImageIcon titleImage;
	
	public Game() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		foodposition();
		timer = new Timer(delay,this);
		timer.start();
		
	}
	private void foodposition() {
		
		for (int x=25;x<875;x=x+25) {
			int position = 0;
			foodXposition[position]=x;
			position+=1;
		}
		for (int y=75;y<650;y=y+25) {
			int position = 0;
			foodYposition[position]=y;
			position+=1;
		}
		
	}
	
	
	public void paint(Graphics g) {
		
		if(moves == 0) {
			snakeXlenght [2] = 50;
			snakeXlenght [1] = 75;
			snakeXlenght [0] = 100;
			
			snakeYlenght [2] = 200;
			snakeYlenght [1] = 200;
			snakeYlenght [0] = 200;
		}
		
		// draw Title Image color 
		g.setColor(Color.white);
		g.drawRect(24, 150, 851, 55);
		
		// draw Title Image
		titleImage = new ImageIcon("logo.png");
		titleImage.paintIcon(this, g, 850, 575);
		
		// draw the border for the gamepalay
		g.setColor(Color.white);
		g.drawRect(24, 160, 851, 576);
		
		// draw background for the gameplay
		g.setColor(Color.black);
		g.fillRect(25, 160, 850, 575);
		
		rightPosition = new ImageIcon("rightposition.png");
		rightPosition.paintIcon(this, g, snakeXlenght[0], snakeYlenght[0]);
		for(int i = 0; i<lenghtofsnake; i++) {
			if (i==0 && right) {
				rightPosition = new ImageIcon("rightposition.png");
				rightPosition.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if (i==0 && left) {
				leftPosition = new ImageIcon("leftposition.png");
				leftPosition.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if (i==0 && up) {
				upPosition = new ImageIcon("upposition.png");
				upPosition.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if (i==0 && down) {
				downPosition = new ImageIcon("downposition.png");
				downPosition.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if(i!=0 ) {
				snakeImage = new ImageIcon("body.png");
				snakeImage.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
		}
		
		leftPosition = new ImageIcon("leftposition.png");
		upPosition = new ImageIcon("upposition.png");
		downPosition = new ImageIcon("downposition.png");
		
		
		/*
		 * foodimage = new ImageIcon("food.png") if((foodXposition[]==snakeXlenght[0])&&
		 * foodYposition[]==snakeYlenght) {
		 * 
		 * }
		 */
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(right) {
			for(int r = lenghtofsnake-1; r>=0 ; r--) {
				snakeYlenght[r+1]  = snakeYlenght[r]; 
			}
			for(int r = lenghtofsnake ; r>=0 ; r--) {
				if(r==0) {
					snakeXlenght[r] = snakeXlenght[r] + 25;
				}
				else {
					snakeXlenght[r] = snakeXlenght[r-1];
				}
				if(snakeXlenght[r] > 850) {
					snakeXlenght[r] = 25 ;
				}
			}
			repaint();
		}
		if(left) {
			for(int r = lenghtofsnake-1; r>=0 ; r--) {
				snakeYlenght[r+1]  = snakeYlenght[r]; 
			}
			for(int r = lenghtofsnake ; r>=0 ; r--) {
				if(r==0) {
					snakeXlenght[r] = snakeXlenght[r] - 25;
				}
				else {
					snakeXlenght[r] = snakeXlenght[r-1];
				}
				if(snakeXlenght[r] < 25) {
					snakeXlenght[r] = 850 ;
				}
			}
			repaint();
		}
		if(up) {
			for(int r = lenghtofsnake-1; r>=0 ; r--) {
				snakeXlenght[r+1]  = snakeXlenght[r]; 
			}
			for(int r = lenghtofsnake ; r>=0 ; r--) {
				if(r==0) {
					snakeYlenght[r] = snakeYlenght[r] - 25;
				}
				else {
					snakeYlenght[r] = snakeYlenght[r-1];
				}
				if(snakeYlenght[r] < 75 ) {
					snakeYlenght[r] = 625 ;
				}
			}
			repaint();
		}
		if(down) {
			for(int r = lenghtofsnake-1; r>=0 ; r--) {
				snakeXlenght[r+1]  = snakeXlenght[r]; 
			}
			for(int r = lenghtofsnake ; r>=0 ; r--) {
				if(r==0) {
					snakeYlenght[r] = snakeYlenght[r] + 25;
				}
				else {
					snakeYlenght[r] = snakeYlenght[r-1];
				}
				if(snakeYlenght[r] > 625) {
					snakeYlenght[r] = 75 ;
				}
			}
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			moves ++;
			right = true;
			if(!left) {
				right = true;
			}
			else {
				right = false;
				left = true;
			}
			up = false;
			down = false;
		}
		
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			moves ++;
			left = true;
			if(!right) {
				left = true;
			}
			else {
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}
		
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			moves ++;
			up = true;
			if(!down) {
				up = true;
			}
			else {
				up = false;
				down = true;
			}
			left = false;
			right = false;
		}
		
		if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			moves ++;
			down = true;
			if(!up) {
				down = true;
			}
			else {
				down = false;
				up = true;
			}
			left = false;
			right = false;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
