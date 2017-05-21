package com.game.hud;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.entity.Player;
import com.game.main.Game;
import com.game.main.Handler;

public class Stage1HUD extends HUD {
	public Stage1HUD(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	Player player = handler.getPlayer();
	int HPBarsDiff = 5;
	private Rectangle HPBarBg = new Rectangle(Game.getScreenWidth()/2 - 175, Game.getScreenHeight() - 60,350,30);
	private int maxBarSize = (int) HPBarBg.getWidth() - (HPBarsDiff * 2);
	private Rectangle HPBar = new Rectangle((int) HPBarBg.getX() + HPBarsDiff, (int)HPBarBg.getY() + HPBarsDiff, (int) maxBarSize, (int)HPBarBg.getHeight() - (HPBarsDiff * 2));
	private Rectangle xpBar = new Rectangle((int) HPBarBg.getX(), (int) HPBarBg.getY() - 15, (int) HPBarBg.getWidth(),10);
	
	//private Rectangle levelRec = new Rectangle;
	
	@Override
	public void render(Graphics g) {
		//Draw HP Bar Background
		g.setColor(Color.BLACK);
		g.fillRect((int)HPBarBg.getX(),(int)HPBarBg.getY(),(int)HPBarBg.getWidth(),(int)HPBarBg.getHeight());
		
		//Draw Level Rectangle
		
		//Draw HP Bar
		g.setColor(Color.GREEN);
		HPBar.setBounds((int) HPBar.getX(), (int)HPBar.getY(), maxBarSize * ((player.getHP() * 100)/player.getMaxHP())/100,(int) HPBar.getHeight());
		g.fillRect((int)HPBar.getX(),(int)HPBar.getY(),(int)HPBar.getWidth(),(int)HPBar.getHeight());
		//Draw HP Bar Text
		g.setColor(Color.WHITE);
		String str = player.getHP() + "/" + player.getMaxHP();
		Font font = new Font(null,Font.BOLD,13);
		drawCenteredString(g, str, HPBarBg, font);
		
		g.fillRect((int) xpBar.getX(), (int) xpBar.getY(), (int) xpBar.getWidth(), (int) xpBar.getHeight());
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
