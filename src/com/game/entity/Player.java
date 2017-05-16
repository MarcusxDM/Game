package com.game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.game.framework.ObjectId;
import com.game.main.Handler;
import com.game.projectile.Projectile;

public class Player extends Entity {
	public Player(int x, int y, int width, int height,int scale, ObjectId id, Handler handler) {
		super(x, y, width*scale, height*scale, id, handler);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
	public enum EVENT{
		START(),
		STOP();
	}
	public void moveRight(EVENT e){
		if(e == EVENT.START){			
			setVelX(5);
		}else if(e == EVENT.STOP){
			setVelX(0);
		}
	}
	public void moveLeft(EVENT e){
		if(e == EVENT.START){			
			setVelX(-5);
		}else if(e == EVENT.STOP){
			setVelX(0);
		}
	}
	public void jump(EVENT e){
		if(e == EVENT.START){			
			setVelY(-5);
		}else if(e == EVENT.STOP){
			setVelY(0);
		}
	}
	public void crouch(EVENT e){
		if(e == EVENT.START){			
			setVelY(+5);
		}else if(e == EVENT.STOP){
			setVelY(0);
		}
	}
	public void skill1(Point dir){
		handler.addObject(new Projectile(x+width/2, y + (height/2), 20, 10, ObjectId.Projectile, this, dir, handler));
	}
}
