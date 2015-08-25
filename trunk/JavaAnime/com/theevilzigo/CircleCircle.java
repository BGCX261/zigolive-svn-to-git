package com.theevilzigo;

public class CircleCircle extends Actor{
	int period;
	int centerc;
	int centerr;
	int radius;
	int sradius;
	int direction;
	public CircleCircle(ImageGenerator im, int period, int centerc, int centerr, int radius, int sradius, int direction) {
		super(im);
		this.period = period;
		this.centerc = centerc;
		this.centerr = centerr;
		this.radius = radius;
		this.sradius = sradius;
		this.direction = direction;
	}
	@Override
	public void draw() {
		imageGen.drawRect(imageGen.getLastFrame(),10*10,10*10,20,20);
		double segment = (imageGen.getFrameCounter()+1)*(2*Math.PI/period);
		int x = centerc + ((int)(Math.cos(segment)*radius)*direction);
		int y = centerr + ((int)(Math.sin(segment)*radius)*direction);
		imageGen.drawCircle(imageGen.getLastFrame(),x,y,sradius);
	}
}
