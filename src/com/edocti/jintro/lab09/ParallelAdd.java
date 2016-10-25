package com.edocti.jintro.lab09;

import java.util.Random;

public class ParallelAdd {
	
	public static final Random RANDOM = new Random();
	
	public static void main(String[] args) throws InterruptedException {
		int[] a = new int[1000];
		int[] b = new int[1000];
		int[] c = new int[1000];
		
		for (int i = 0; i < 1000; i++) {
			a[i] = RANDOM.nextInt(500000);
			b[i] = RANDOM.nextInt(500000);
		}
		
		Thread[] adders = new Thread[4];
		
		for(int i = 0; i < 4; i++) {
			int start = i * 1000 / 4;
			int end = start + 1000 / 4;
			adders[i] = new Thread(new Adder(a, b, c, start, end));
			adders[i].start();
		}
		
		for (Thread t : adders) {
			t.join();
		}
		for(int i = 0; i < 50; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.printf("%6d ", c[(20 * i) + j]);
			}
			System.out.println();
		}
	}
}

class Adder implements Runnable {
	int[] a, b, c;
	int start, end;
	
	Adder(int[] a, int[] b, int[] c, int start, int end) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			c[i] = a[i] + b[i];
		}
	}
}
