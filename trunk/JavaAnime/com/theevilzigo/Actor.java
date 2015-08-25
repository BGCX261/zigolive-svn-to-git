package com.theevilzigo;

public abstract class Actor {

	ImageGenerator imageGen;
	public Actor(ImageGenerator ig) {
		imageGen = ig;
	}
	
	public abstract void draw();
}
