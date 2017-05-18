package com.game.projectile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.game.entity.Entity;
import com.game.framework.GameObject;
import com.game.framework.ObjectId;
import com.game.main.Game;
import com.game.main.Handler;

public class Projectile extends GameObject {
	private int lifeTime = 1000;
	Entity source;
	public Projectile(int x, int y, int width, int height, boolean solid, ObjectId id, Entity source, Point dir, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		this.source = source;
		if(dir.x > Game.getScreenWidth()/2){
			setX((int)getX() + 10);
			velX = 30;
			velY = 0;			
		}else{
			setX((int)getX() - 30);
			velX = -30;
			velY = 0;
		}
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
		g.fillRect((int)x, (int)y, width, height);
	}

}
