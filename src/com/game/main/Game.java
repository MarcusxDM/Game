package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.game.framework.Camera;
import com.game.input.KeyInput;
import com.game.input.MouseInput;
import com.game.stage.Stage;
import com.game.stage.Stage1;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1481513214977724008L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = 176;
	public static final int SCALE = 4;
	public static final String TITLE = "Game";
	
	private Handler handler;
	private Thread thread;
	private boolean running = false;
	private Camera cam = new Camera();
	private Stage stage;
	private static boolean paused = false;
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	private void init(){
		handler = new Handler();
		
		handler.setCam(cam);
		addKeyListener(new KeyInput(handler));
		addMouseListener(new MouseInput(handler));
		stage = new Stage1(handler);
		
	}
	private void stop(){
		
	}
	public void run(){
		init();
		requestFocusInWindow();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0;
		double ticks_per_sec = 60.0;
		double ns = 1000000000.0/ticks_per_sec;
		int frames = 0;
		int ticks = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				ticks++;
				delta--;
			}				
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000){
				timer+= 1000;
				System.out.println(frames + " frames per second " + ticks + " Updates per second");
				frames = 0;
				ticks = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		if(paused){
			
		}else{
			cam.tick();
			handler.tick();
			stage.tick();
		}
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		if(paused){
			
		}else{
			g.setColor(Color.RED);
			g.fillRect(0, 0, getScreenWidth(), getScreenHeight());
			g.translate(cam.getX(), cam.getY());
			handler.render(g);
			g.translate(-cam.getX(), -cam.getY());
			stage.render(g);
		}
		g.dispose();
		bs.show();
	}
	
	public static int getScreenWidth(){
		return WIDTH*SCALE;
	}
	public static int getScreenHeight(){
		return HEIGHT*SCALE;
	}
	public static void pause(){
		paused = !paused;
	}
	public static void main(String args[]){
		new Window(WIDTH,HEIGHT,SCALE,TITLE, new Game());
	}
}
