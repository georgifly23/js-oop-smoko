import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		Game game = new Game();
		window.setBounds(500, 150, 905, 780);
		game.setBackground(Color.DARK_GRAY);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(game);
		  
		
	}

}
