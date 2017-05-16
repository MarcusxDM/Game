package com.game.entity;

import java.awt.Graphics;

import com.game.entity.Player.EVENT;
import com.game.framework.GameObject;
import com.game.framework.ObjectId;
import com.game.main.Handler;

public abstract class Entity extends GameObject {

	public Entity(int x, int y, int width, int height, ObjectId id, Handler handler) {
		super(x, y, width, height, id, handler);
	}

	@Override
	public abstract void tick();
	@Override
	public abstract void render(Graphics g);
	
	public abstract void moveRight(EVENT e);
	public abstract void moveLeft(EVENT e);
	public abstract void jump(EVENT e);
	public abstract void crouch(EVENT e);
}
