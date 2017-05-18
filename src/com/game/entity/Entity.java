package com.game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.entity.Player.EVENT;
import com.game.framework.GameObject;
import com.game.framework.ObjectId;
import com.game.main.Handler;

public abstract class Entity extends GameObject {
	boolean solid;
	protected double gravity = 0.01f;
	protected boolean falling = true;
	protected boolean jumping = false;
	public Entity(int x, int y, int width, int height, boolean solid, ObjectId id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
	}

	@Override
	public abstract void tick();
	@Override
	public abstract void render(Graphics g);
	
	public abstract void moveRight(EVENT e);
	public abstract void moveLeft(EVENT e);
	public abstract void jump(EVENT e);
	public abstract void crouch(EVENT e);
	
	public Rectangle getBounds(){
		return new Rectangle((int)getX(),(int)getY(),width,height);
	}
	public Rectangle getBoundsTop(){
		return new Rectangle((int)(x+width*0.2),(int)y-2, (int)(width - width * 0.2),4);
	}
	public Rectangle getBoundsBottom(){
		return new Rectangle((int)(x+width*0.2),(int)(y+height-2), (int)(width - width * 0.2), 4);
	}
	public Rectangle getBoundsLeft(){
		return new Rectangle((int)x-2,(int)(y + height * 0.2),4, (int)(height - height*0.2));
	}
	public Rectangle getBoundsRight(){
		return new Rectangle((int)x + width - 2,(int)(y + height*0.2),4,(int) (height - height * 0.2));
	}
	public boolean isSolid() {
		return solid;
	}
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	public double getGravity() {
		return gravity;
	}
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	public boolean isFalling() {
		return falling;
	}
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}
