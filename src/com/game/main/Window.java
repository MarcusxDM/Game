package com.game.main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	public Window(int width, int height, int scale, String title, Game game){
		game.setPreferredSize(new Dimension(width*scale,height*scale));
		game.setMinimumSize(new Dimension(width*scale,height*scale));
		game.setMaximumSize(new Dimension(width*scale,height*scale));
		
		JFrame frame = new JFrame(title);
		frame.add(game);
		//frame.setUndecorated(true);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
		game.start();
	}
}
