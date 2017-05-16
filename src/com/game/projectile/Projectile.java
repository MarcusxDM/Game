package com.game.projectile;

import java.awt.Color;
import java.awt.Graphics;

import com.game.entity.Entity;
import com.game.framework.GameObject;
import com.game.framework.ObjectId;
import com.game.main.Handler;

public class Projectile extends GameObject {
	private int lifeTime = 1000;
	Entity source;
	public Projectile(int x, int y, int width, int height, ObjectId id, Entity source, Handler handler) {
		super(x, y, width, height, id, handler);
		this.source = source;
		velX = 30;
		velY = 5;
	}

	@Override
	public void tick() {
		if(lifeTime <= 0){
			handler.removeObject(this);
		}
		x += velX;
		y += velY;
		lifeTime -= velX + velY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

}
