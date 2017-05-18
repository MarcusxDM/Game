package com.game.framework;

import com.game.main.Game;

public class Camera {
	public int x, y;
	GameObject pl;
	
	public void tick(){
		
		if(pl != null){
			setX((int)-pl.getX() + Game.getScreenWidth()/2);	
			setY((int)-pl.getY() + Game.getScreenHeight()/2);
		}
	}
	
	//GETTERS AND SETTERS
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setPlayer(GameObject pl){
		this.pl = pl;
	}
}
