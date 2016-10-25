package com.edocti.jintro.lab09;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class BoxParty {

	public static void main(String[] args) {

		int size = 40;
		int pause = 5;
		
		List<DummyBox> boxes = new ArrayList<DummyBox>();
		
		JFrame frame = new JFrame("Box party");
		frame.setLayout(new GridLayout(size, size));
		
		for(int i = 0; i < size * size; i++) {
			final DummyBox box = new DummyBox(pause);
			frame.add(box);
			boxes.add(box);
		}
		
		frame.setSize(500,  400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(DummyBox b : boxes) {
			b.startBlinking();
		}
		
	}
}
