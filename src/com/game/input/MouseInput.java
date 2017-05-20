package com.game.input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.game.entity.Player;
import com.game.framework.GameObject;
import com.game.framework.ObjectId;
import com.game.main.Handler;


public class MouseInput implements MouseListener {
	private Handler handler;

	public MouseInput(Handler handler){
		this.handler = handler;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		for(int i = 0;i < handler.objList.size();i++){
			GameObject obj = handler.objList.get(i);
			if(obj.getId() == ObjectId.Player){
				Player pl = (Player) obj;
				pl.skill1(p);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
