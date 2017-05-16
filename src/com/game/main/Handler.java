package com.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

import com.game.framework.Camera;
import com.game.framework.GameObject;
import com.game.framework.ObjectId;


/*
 * In this class we store every Game Object in our game
 * 
 */
public class Handler {
	Camera cam;
	public LinkedList<GameObject> objList = new LinkedList<GameObject>();
	
	public void tick(){
		GameObject obj;
		for(int i = 0;i < objList.size();i++){
			obj = objList.get(i);
			obj.tick();
		}
	}
	public void render(Graphics g){
		GameObject obj;
		for(int i = 0;i < objList.size();i++){
			obj = objList.get(i);
			obj.render(g);
		}
	}
	public void addObject(GameObject obj){
		if(obj.getId() == ObjectId.Player){
			cam.setPlayer(obj);
		}
		objList.add(obj);
	}
	public void removeObject(GameObject obj){
		objList.remove(obj);
	}
	
	public Camera getCam() {
		return cam;
	}
	public void setCam(Camera cam) {
		this.cam = cam;
	}
}
