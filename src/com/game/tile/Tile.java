package com.game.tile;

import java.awt.Graphics;

import com.game.framework.GameObject;
import com.game.framework.ObjectId;
import com.game.main.Handler;

public abstract class Tile extends GameObject {
	boolean solid;
	public Tile(int x, int y, int width, int height,boolean solid, ObjectId id, Handler handler) {
		super(x, y, width, height, id, handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void tick();

	@Override
	public abstract void render(Graphics g);

}
