package com.game.tile;

import java.awt.Color;
import java.awt.Graphics;

import com.game.framework.ObjectId;
import com.game.main.Handler;

public class VoidTile extends Tile{

	public VoidTile(int x, int y, int width, int height,int scale, ObjectId id, Handler handler) {
		super(x, y, width*scale, height*scale, id, handler);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
}
