package com.edocti.jintro.lab09;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class DummyBox extends Canvas {

	private static final long serialVersionUID = -2513998631126571454L;

	ColorChanger changer;
	
	private static Color[] colors = {
			Color.BLACK, Color.BLUE, Color.RED, Color.GREEN,
			Color.GRAY, Color.YELLOW
	};
	
	public DummyBox(int pause) {
		this.changer = new ColorChanger(this, pause);
	}
	
	public void startBlinking() {
		this.changer.start();
	}
	
	private static final Color getRandomColor() {
		return colors[ThreadLocalRandom.current().nextInt(colors.length)];
	}
	
	Color bgColor = getRandomColor();
	
	public void changeColor() {
		bgColor = getRandomColor();
		super.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(bgColor);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}

class ColorChanger extends Thread {
	DummyBox box;
	int pause;
	
	public ColorChanger(DummyBox box, int pause) {
		this.box = box;
		this.pause = pause;
	}
	
	public void run() {
		while(true) {
			box.changeColor();
			try {
				Thread.sleep(pause);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
