package com.edocti.jintro.lab09;

public class Simple {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
						System.out.println("Hello from Anon");
					}
				}
			}).start();
		}

		for(int i = 0; i < 10; i++) {
			new Thread(new Cucu()).start();
		}
		
		for(int i = 0; i < 10; i++) 
			new Cucu2().start();
	}
	
	public static class Cucu implements Runnable {
		@Override
		public void run() {
			while(true) {
				System.out.println("Hello from Runnable");
			}
		}
	}
	
	public static class Cucu2 extends Thread {
		@Override
		public void run() {
			while(true)
				System.out.println("Hello from Thread");
		}
	}
}
