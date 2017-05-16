package com.game.framework;

import java.awt.Graphics;

import com.game.main.Handler;

public abstract class GameObject {
	protected int x, y;
	protected int velX = 0, velY = 0;
	protected int width, height;
	ObjectId id;
	protected Handler handler;
	
	public GameObject(int x, int y, int width, int height, ObjectId id, Handler handler){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getVelX(){
		return velX;
	}
	public void setVelX(int x){
		this.velX = x;
	}
	public int getVelY(){
		return velY;
	}
	public void setVelY(int y){
		this.velY = y;
	}
	public ObjectId getId(){
		return id;
	}
}
