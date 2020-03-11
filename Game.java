import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, ActionListener {

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

	private int[] foodXposition = new int[30];
	private int[] foodYposition = new int[19];

	private int score = 0;

	private ImageIcon foodimage;
	private ImageIcon foodimage2;

	private ImageIcon wallimage;

	private Random random = new Random();

	private int moves = 0;

	private int positionX = (random.nextInt(34) + 1) * 25;
	private int positionX2 = (random.nextInt(34) + 1) * 25;
	private int positionY = (random.nextInt(23) + 6) * 25;
	private int positionY2 = (random.nextInt(23) + 6) * 25;
	private int positionX3 = (random.nextInt(34) + 1) * 25;
	private int positionY3 = (random.nextInt(23) + 6) * 25;

	public Game() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (moves == 0) {
			snakeXlenght[2] = 50;
			snakeXlenght[1] = 75;
			snakeXlenght[0] = 100;

			snakeYlenght[2] = 200;
			snakeYlenght[1] = 200;
			snakeYlenght[0] = 200;
		}

		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString("«ÏˇÚ‡", 10, 50);

		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString("—ÃŒ Œ", 50, 100);

		g.setColor(Color.white);
		g.drawRect(24, 150, 852, 577);

		g.setColor(Color.black);
		g.fillRect(25, 150, 850, 575);

		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 20));
		g.drawString("Score is:" + score, 720, 30);

		g.setFont(new Font("arial", Font.PLAIN, 20));
		g.drawString("Snake length is:" + lenghtofsnake, 720, 50);

		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawString("Press any arrow key to start", 700, 70);

		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawString("Press R to restart", 700, 90);

		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawString("Press SPACEBAR to pause", 700, 110);

		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawString("Press any arrow key to resume", 700, 130);

		rightPosition = new ImageIcon("rightposition.png");
		rightPosition.paintIcon(this, g, snakeXlenght[0], snakeYlenght[0]);
		for (int i = 0; i < lenghtofsnake; i++) {
			if (i == 0 && right) {
				rightPosition = new ImageIcon("rightposition.png");
				rightPosition.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if (i == 0 && left) {
				leftPosition = new ImageIcon("leftposition.png");
				leftPosition.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if (i == 0 && up) {
				upPosition = new ImageIcon("upposition.png");
				upPosition.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if (i == 0 && down) {
				downPosition = new ImageIcon("downposition.png");
				downPosition.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
			if (i != 0) {
				snakeImage = new ImageIcon("body.png");
				snakeImage.paintIcon(this, g, snakeXlenght[i], snakeYlenght[i]);
			}
		}

		leftPosition = new ImageIcon("leftposition.png");
		upPosition = new ImageIcon("upposition.png");
		downPosition = new ImageIcon("downposition.png");

		foodimage = new ImageIcon("food.png");
		if ((positionX == snakeXlenght[0]) && positionY == snakeYlenght[0]) {
			score = score + 10;
			lenghtofsnake++;
			positionX = (random.nextInt(34) + 1) * 25;
			positionY = (random.nextInt(23) + 6) * 25;

		}
		foodimage.paintIcon(this, g, positionX, positionY);

		foodimage2 = new ImageIcon("food2.png");
		if ((positionX2 == snakeXlenght[0]) && positionY2 == snakeYlenght[0]) {
			score = score + 15;
			lenghtofsnake++;
			positionX2 = (random.nextInt(34) + 1) * 25;
			positionY2 = (random.nextInt(23) + 6) * 25;
		}
		foodimage2.paintIcon(this, g, positionX2, positionY2);

		wallimage = new ImageIcon("wall.png");
		if ((positionX3 == snakeXlenght[0]) && (positionY3 == snakeYlenght[0])) {
			right = false;
			left = false;
			up = false;
			down = false;

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Game Over", 300, 300);

			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Press" + " R " + "to restart the game", 150, 350);
		} else if ((positionX3 + 25 == snakeXlenght[0]) && (positionY3 == snakeYlenght[0])) {
			right = false;
			left = false;
			up = false;
			down = false;

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Game Over", 300, 300);

			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Press" + " R " + "to restart the game", 150, 350);
		} else if ((positionX3 == snakeXlenght[0]) && (positionY3 + 25 == snakeYlenght[0])) {
			right = false;
			left = false;
			up = false;
			down = false;

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Game Over", 300, 300);

			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Press" + " R " + "to restart the game", 150, 350);
		} else if ((positionX3 + 25 == snakeXlenght[0]) && (positionY3 + 25 == snakeYlenght[0])) {
			right = false;
			left = false;
			up = false;
			down = false;

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Game Over", 300, 300);

			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Press" + " R " + "to restart the game", 150, 350);
		}

		if ((positionX3 + 25 > 850) && (positionY3 + 25 > 700) && (positionX3 + 50 > 850) && (positionY3 + 50 > 700)) {
			positionX3 = 25;
			positionY3 = 150;
		}
		wallimage.paintIcon(this, g, positionX3, positionY3);
		wallimage = new ImageIcon("wall.png");
		wallimage.paintIcon(this, g, positionX3 + 25, positionY3);
		wallimage = new ImageIcon("wall.png");
		wallimage.paintIcon(this, g, positionX3, positionY3 + 25);
		wallimage = new ImageIcon("wall.png");
		wallimage.paintIcon(this, g, positionX3 + 25, positionY3 + 25);

		for (int b = 1; b < lenghtofsnake; b++) {
			if (snakeXlenght[b] == snakeXlenght[0] && snakeYlenght[b] == snakeYlenght[0]) {

				right = false;
				left = false;
				up = false;
				down = false;

				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Game Over", 300, 300);

				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Press" + " R " + "to restart the game", 150, 350);
			}
		}

		if (lenghtofsnake == 778) {

			right = false;
			left = false;
			up = false;
			down = false;

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Game Over", 320, 300);

			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("You WIN", 330, 350);
		}

		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (right) {
			for (int r = lenghtofsnake - 1; r >= 0; r--) {
				snakeYlenght[r + 1] = snakeYlenght[r];
			}
			for (int r = lenghtofsnake; r >= 0; r--) {
				if (r == 0) {
					snakeXlenght[r] = snakeXlenght[r] + 25;
				} else {
					snakeXlenght[r] = snakeXlenght[r - 1];
				}
				if (snakeXlenght[r] > 850) {
					snakeXlenght[r] = 25;
				}
			}
			repaint();
		}
		if (left) {
			for (int r = lenghtofsnake - 1; r >= 0; r--) {
				snakeYlenght[r + 1] = snakeYlenght[r];
			}
			for (int r = lenghtofsnake; r >= 0; r--) {
				if (r == 0) {
					snakeXlenght[r] = snakeXlenght[r] - 25;
				} else {
					snakeXlenght[r] = snakeXlenght[r - 1];
				}
				if (snakeXlenght[r] < 25) {
					snakeXlenght[r] = 850;
				}
			}
			repaint();
		}
		if (up) {
			for (int r = lenghtofsnake - 1; r >= 0; r--) {
				snakeXlenght[r + 1] = snakeXlenght[r];
			}
			for (int r = lenghtofsnake; r >= 0; r--) {
				if (r == 0) {
					snakeYlenght[r] = snakeYlenght[r] - 25;
				} else {
					snakeYlenght[r] = snakeYlenght[r - 1];
				}
				if (snakeYlenght[r] < 150) {
					snakeYlenght[r] = 700;
				}
			}
			repaint();
		}
		if (down) {
			for (int r = lenghtofsnake - 1; r >= 0; r--) {
				snakeXlenght[r + 1] = snakeXlenght[r];
			}
			for (int r = lenghtofsnake; r >= 0; r--) {
				if (r == 0) {
					snakeYlenght[r] = snakeYlenght[r] + 25;
				} else {
					snakeYlenght[r] = snakeYlenght[r - 1];
				}
				if (snakeYlenght[r] > 700) {
					snakeYlenght[r] = 150;
				}
			}
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			timer.stop();
		}

		if (e.getKeyCode() == KeyEvent.VK_R) {
			score = 0;
			lenghtofsnake = 3;
			moves = 0;
			repaint();
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			timer.start();
			moves++;
			right = true;
			if (!left) {
				right = true;
			} else {
				right = false;
				left = true;
			}
			up = false;
			down = false;
			repaint();
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			timer.start();
			moves++;
			left = true;
			if (!right) {
				left = true;
			} else {
				left = false;
				right = true;
			}
			up = false;
			down = false;
			repaint();
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			timer.start();
			moves++;
			up = true;
			if (!down) {
				up = true;
			} else {
				up = false;
				down = true;
			}
			left = false;
			right = false;
			repaint();
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			timer.start();
			moves++;
			down = true;
			if (!up) {
				down = true;
			} else {
				down = false;
				up = true;
			}
			left = false;
			right = false;
			repaint();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
