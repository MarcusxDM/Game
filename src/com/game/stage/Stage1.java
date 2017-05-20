package com.game.stage;

import java.awt.Graphics;

import com.game.hud.Stage1HUD;
import com.game.main.Handler;

public class Stage1 extends Stage {

	public Stage1(Handler handler) {
		super(handler);
		createLevel("/stages/1-1.png");
		hud = new Stage1HUD(handler);
	}
	public void render(Graphics g){
		 hud.render(g);
	}
	public void tick(){
		hud.tick();
	}
}
