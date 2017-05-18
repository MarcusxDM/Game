package com.game.game.gfx;

import java.awt.image.BufferedImage;

//A Sprite is SubImage from a SpriteSheet
public class Sprite {
	public SpriteSheet sheet;
	
	public BufferedImage image;
	
	public Sprite(SpriteSheet sheet, int x, int y){
//		if(image == null){
//			image = new BufferedImage(sheet.getW(),sheet.getH(),BufferedImage.TYPE_INT_RGB);
//		}
		image = sheet.getSprite(x, y);
	}
	
	public BufferedImage getBufferedImage(){
		return image;
	}
}
