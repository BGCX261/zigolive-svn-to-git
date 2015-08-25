package com.theevilzigo;

import java.awt.Color;
import java.util.TimerTask;
import java.util.Vector;

import com.theevilzigo.AnimatorEngine.AnimatorComponent;

public class ImageGenerator extends TimerTask{

	private static int frameCounter = 0;
	private AnimatorComponent fireworkComponent;
	private Vector<Color[][]> filmReel = new Vector<Color[][]>();
	private static int totalFrames= 40;
	private Vector<Actor> actors = new Vector<Actor>();
	
	public void setCast(Vector<Actor> cast){
		actors = cast;
	}
	
	public int getFrameCounter(){ return frameCounter; }
	
	public Color[][] getFrame(int frame){
		return filmReel.get(frame);
	}
	
	public Color[][] getLastFrame(){
		return filmReel.lastElement();
	}
	
	public ImageGenerator(AnimatorComponent fc) {
		this.fireworkComponent = fc;
	}
	
	public void addFrame(){
		if(filmReel.size()>30)return;
		Color[][] frameMap = new Color[640][480];
		for(int row = 0; row < 480; row++){
			for(int col = 0; col < 640; col++){
				frameMap[col][row] = Color.white;
			}
		}

		filmReel.add(frameMap);
		frameCounter++;
		for(Actor actor:actors){
			actor.draw();
		}
	}
	@Override
	public void run() {
		System.out.println("Frame >" + frameCounter%totalFrames);
		fireworkComponent.drawImage(filmReel.remove(0));
	}
	
	public final void drawRect(Color[][] frame, int r, int c, int rsize, int csize){
		for(int i = c; i < c+csize; i++){
			for(int j = r; j < r+rsize; j++){
				frame[i][j] = Color.black;
			}
		}
	}
	
	public final void drawCircle(Color[][] frame, int r, int c, int radius){
		for(int i = c-radius; i < c+radius+1; i++){
			for(int j = r-radius; j < r+radius+1; j++){
				int x2 = (int)Math.pow((i-c),2);
				int y2 = (int)Math.pow((j-r),2);
				int r2 = (int)Math.pow(radius,2);
				if(x2+y2<=r2){
					if(i>=0&&j>=0 && i<640 && j<480) frame[i][j] = Color.BLACK;
				}
			}
		}
	}
	
	public final void drawLine(Color[][] frame, int r1, int c1,int r2, int c2){
		
	}
	
}
