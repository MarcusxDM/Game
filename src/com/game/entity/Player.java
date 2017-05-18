package com.game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.game.debug.Debug;
import com.game.framework.GameObject;
import com.game.framework.ObjectId;
import com.game.main.Handler;
import com.game.projectile.Projectile;
import com.game.tile.Tile;

public class Player extends Entity {
	private  final float MAX_SPEED = 10;
	public Player(int x, int y, int width, int height,int scale, boolean solid, ObjectId id, Handler handler) {
		super(x, y, width*scale, height*scale, solid, id, handler);
	}
	private void move(){
		/*
		 * 0 = top
		 * 1 = bottom
		 * 2 = left
		 * 3 = right
		 */
		Tile collisions[] = new Tile[4];
		for(int i = 0;i < handler.objList.size();i++){
			GameObject obj = handler.objList.get(i);
			if(obj.getId() == ObjectId.Tile){
				Tile ti = (Tile) obj;
				System.out.println(ti.getBounds());
				System.out.println(getBoundsTop());
				if(ti.getBounds().intersects(getBoundsTop())){
					collisions[0] = ti;
				}
				if(ti.getBounds().intersects(getBoundsBottom())){
					collisions[1] = ti;
				}
				if(ti.getBounds().intersects(getBoundsLeft())){
					collisions[2] = ti;
				}
				if(ti.getBounds().intersects(getBoundsRight())){
					collisions[3] = ti;
				}
			}
		}
		if(velY < 0){
			if(collisions[0] != null){
				if(y + velY <= collisions[0].getY() + collisions[0].getHeight()){
					y = collisions[0].getY() + collisions[0].getHeight();
				}else{
					y += velY;
				}
			}else{
				y += velY;
			}
		}else{
			if(collisions[1] != null){
				if(y + height + velY >= collisions[1].getY()){
					y = collisions[1].getY() - height;
				}else{
					y += velY;
				}
			}else{
				y += velY;
			}
			
		}
		if(velX < 0){
			if(collisions[2] != null){
				if(x + velX <= collisions[2].getX() + collisions[2].getWidth()){
					x = collisions[2].getX() + collisions[2].getHeight();
				}else{
					x += velX;
				}
			}else{
				x += velX;
			}
		}else{
			if(collisions[3] != null){
				if(x + width + velX >= collisions[3].getX()){
					x = collisions[3].getX() - width;
				}else{
					x += velX;
				}
			}else{
				x += velX;
			}
		}
	}
	@Override
	public void tick() {
		move();
		if(falling || jumping){
			velY += gravity;
			if(velY >= MAX_SPEED) velY = MAX_SPEED;
		}
	}

	private void collision(){
		boolean hasGround = false;
		for(int i = 0;i < handler.objList.size();i++){
			GameObject obj = handler.objList.get(i);
			if(obj.getId() == ObjectId.Tile){
				Tile ti = (Tile) obj;
				if(ti.getBounds().intersects(getBoundsBottom())){
					if(ti.isSolid()){
						hasGround = true;
						falling = false;
					}
				}
			}
		}
		if(!hasGround) falling = true;
	}
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x,(int)y, width, height);
		
		//DEBUG
		if(Debug.PLAYER_BOUNDS){
			g.setColor(Color.ORANGE);
			g.fillRect(getBoundsTop().x, getBoundsTop().y, getBoundsTop().width, getBoundsTop().height);
			g.fillRect(getBoundsBottom().x, getBoundsBottom().y, getBoundsBottom().width, getBoundsBottom().height);
			g.fillRect(getBoundsLeft().x, getBoundsLeft().y, getBoundsLeft().width, getBoundsLeft().height);
			g.fillRect(getBoundsRight().x, getBoundsRight().y, getBoundsRight().width, getBoundsRight().height);
			

		}
		collision();
	}
	public enum EVENT{
		START(),
		STOP();
	}
	public void moveRight(EVENT e){
		if(e == EVENT.START){			
			setVelX(2);
		}else if(e == EVENT.STOP){
			setVelX(0);
		}
	}
	public void moveLeft(EVENT e){
		if(e == EVENT.START){			
			setVelX(-2);
		}else if(e == EVENT.STOP){
			setVelX(0);
		}
	}
	public void jump(EVENT e){
		if(e == EVENT.START){	
			jumping = true;
			//setVelY(-2);
		}else if(e == EVENT.STOP){
			setVelY(0);
		}
	}
	public void crouch(EVENT e){
		if(e == EVENT.START){			
			setVelY(2);
		}else if(e == EVENT.STOP){
			setVelY(0);
		}
	}
	public void skill1(Point dir){
		handler.addObject(new Projectile((int) x+width/2,(int) y + (height/2), 20, 10, false, ObjectId.Projectile, this, dir, handler));
	}
}
