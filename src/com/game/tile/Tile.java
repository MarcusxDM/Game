package com.game.tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.framework.GameObject;
import com.game.framework.ObjectId;
import com.game.main.Handler;

public abstract class Tile extends GameObject {
	boolean solid;
	public Tile(int x, int y, int width, int height,boolean solid, ObjectId id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		this.solid = solid;
	}

	@Override
	public abstract void tick();
	@Override
	public abstract void render(Graphics g);
	public boolean isSolid() {
		return solid;
	}
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	public Rectangle getBounds(){
		return new Rectangle((int)getX(),(int)getY(),width,height);
	}
}
