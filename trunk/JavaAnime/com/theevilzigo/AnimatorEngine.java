package com.theevilzigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Timer;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class AnimatorEngine extends JFrame{

	public AnimatorEngine(int period) {
		super("Fireworks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,480);
		Timer t = new Timer();
		AnimatorComponent fc = new AnimatorComponent(this);
		getContentPane().add(fc);
		ImageGenerator ig = new ImageGenerator(fc);
		Vector<Actor> cast = new Vector<Actor>();
		for(int i=0;i<40;i++){
			CircleCircle circle = new CircleCircle(ig,10+i, 240,320,10+(5*i),4,i%2==0?1:-1);
			cast.add(circle);
		}
		ig.setCast(cast);
		BufferFrameTimerTask frameTimer = new BufferFrameTimerTask(ig);
		t.scheduleAtFixedRate(ig, 100, period);
		t.scheduleAtFixedRate(frameTimer,0, (int)(period*0.8));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		test1();
	}
	public static void test1() {
		AnimatorEngine fw = new AnimatorEngine(1000/7);
	}
	public static void test2() {
		AnimatorEngine fw = new AnimatorEngine(1000/7);
	}
	
	public class AnimatorComponent extends JComponent{
		
		private WritableRaster wr;
		private BufferedImage bi;
		private JFrame parent;
		
		public AnimatorComponent(JFrame parent) {
			bi= new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
			wr = bi.getRaster();
			this.parent = parent;
		}
		
		public void drawImage(Color[][] pixelMap){
			for(int i =0; i < pixelMap.length; i++){
				for(int j = 0; j < pixelMap[i].length; j++){
					wr.setPixel(i, j, new int[]{pixelMap[i][j].getRed(),pixelMap[i][j].getGreen(),pixelMap[i][j].getBlue()} );
				}
			}
			parent.repaint();
		}
		
		public void paint(Graphics g){
			g.drawImage(bi, 0, 0, null);
		}
		
	}
}
