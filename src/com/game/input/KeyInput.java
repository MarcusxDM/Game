package com.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import com.game.entity.Player;
import com.game.framework.GameObject;
import com.game.framework.ObjectId;
import com.game.main.Game;
import com.game.main.Handler;

public class KeyInput implements KeyListener {
	Handler handler;
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0;i < handler.objList.size();i++){

			GameObject obj = handler.objList.get(i);
			if(obj.getId() == ObjectId.Player){
				Player pl = (Player) obj;
				switch(key){
				case KeyEvent.VK_D:
					pl.moveRight(Player.EVENT.START);
					break;
				case KeyEvent.VK_A:
					pl.moveLeft(Player.EVENT.START);
					break;
				case KeyEvent.VK_SPACE:
					pl.jump(Player.EVENT.START);
					break;
				case KeyEvent.VK_S:
					pl.crouch(Player.EVENT.START);
					break;
				case KeyEvent.VK_ESCAPE:
					Game.pause();
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0;i < handler.objList.size();i++){
			GameObject obj = handler.objList.get(i);
			if(obj.getId() == ObjectId.Player){
				Player pl = (Player) obj;
				switch(key){
				case KeyEvent.VK_D:
					pl.moveRight(Player.EVENT.STOP);
					break;
				case KeyEvent.VK_A:
					pl.moveLeft(Player.EVENT.STOP);
					break;
				case KeyEvent.VK_SPACE:
					pl.jump(Player.EVENT.STOP);
					break;
				case KeyEvent.VK_S:
					pl.crouch(Player.EVENT.STOP);
					break;
				}
			}
		}
	}
	public void keyTyped(KeyEvent e){
		
	}
}
