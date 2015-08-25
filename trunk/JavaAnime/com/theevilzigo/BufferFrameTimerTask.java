package com.theevilzigo;

import java.awt.Color;
import java.util.TimerTask;

public class BufferFrameTimerTask extends TimerTask {

	private ImageGenerator imageGen;
	
	public BufferFrameTimerTask(ImageGenerator ig) {
		imageGen = ig;
	}
	@Override
	public void run() {
		imageGen.addFrame();
	}

}
