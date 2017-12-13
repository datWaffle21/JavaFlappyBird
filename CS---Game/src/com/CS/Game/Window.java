package com.CS.Game;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window {
	
	private Game game;
	
	String[] list = {
			"U:\\Desktop\\background.png"
	};

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
	//	pic = new JLabel();
	//	ImageIcon icon = new ImageIcon("FlappyBird.png");
		
		frame.setPreferredSize(new Dimension(width , height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
		ImageIcon icon = new ImageIcon(list[0]);
		Image img = icon.getImage();
//		Image newImg = img.setScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH )
	}
	
}
