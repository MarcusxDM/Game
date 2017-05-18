package com.game.stage;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.game.entity.Player;
import com.game.framework.ObjectId;
import com.game.main.Handler;
import com.game.tile.VoidTile;


public abstract class Stage {
	Handler handler;
	public Stage(Handler handler){
		this.handler = handler;
	}
	public void createLevel(String path){
		BufferedImage level = null;
		try {
			level = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int levelScale = 16;
		/*Generates a level from a image.png */
		int width = level.getWidth();
		int height = level.getHeight();
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				int pixel = level.getRGB(x, y);
				
				int red   = (pixel >> 16) & 0xff;
				int green = (pixel >> 8)  & 0xff;
				int blue  = (pixel)       & 0xff;
				
				
				///Building ground
				if(red==0 && green ==0 && blue==0) handler.addObject(new VoidTile(x*levelScale, y*levelScale, levelScale, levelScale, 1, true, ObjectId.Tile, handler));
				
				///Player
				if(red==0 && green ==0 && blue==255) handler.addObject(new Player(x*levelScale,y*levelScale,8,16,1,true,ObjectId.Player,handler));
			}
		}
	}
}
