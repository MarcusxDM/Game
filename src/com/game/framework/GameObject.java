package com.game.framework;

import java.awt.Graphics;

import com.game.main.Handler;

public abstract class GameObject {
	protected double x, y;
	protected double velX = 0, velY = 0;
	protected int width, height;
	ObjectId id;
	protected Handler handler;
	protected boolean solid;
	
	public GameObject(int x, int y, int width, int height, boolean solid, ObjectId id, Handler handler){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.handler = handler;
		this.solid = solid;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public double getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	public double getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	public double getVelX(){
		return velX;
	}
	public void setVelX(int x){
		this.velX = x;
	}
	public double getVelY(){
		return velY;
	}
	public void setVelY(int y){
		this.velY = y;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public ObjectId getId(){
		return id;
	}
	public boolean isSolid() {
		return solid;
	}
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	
}
