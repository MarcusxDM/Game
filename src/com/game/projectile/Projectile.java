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
	private int lifeTime = 100;
	private int speed;
	Entity source;
	public Projectile(int x, int y, int width, int height, boolean solid, ObjectId id, Entity source, Point dir, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		this.source = source;
		speed = 4;
		double angle = Math.atan2(dir.getY() - Game.getScreenHeight()/2, dir.getX() - Game.getScreenWidth()/2);
		//xx *= 180 / Math.PI;
		System.out.println(angle);
		velX += speed * Math.cos(angle);
		velY += speed * Math.sin(angle);
	}

	@Override
	public void tick() {
		if(lifeTime <= 0){
			handler.removeObject(this);
		}
		x += velX;
		y += velY;
		if(velX >= velY){
			lifeTime -= velX;
		}else{
			lifeTime -= velY;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, width, height);
	}

}
