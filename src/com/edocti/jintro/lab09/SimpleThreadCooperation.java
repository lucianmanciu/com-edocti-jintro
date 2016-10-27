package com.edocti.jintro.lab09;

public class SimpleThreadCooperation {

	public static void main(String[] args) throws InterruptedException {
		final Object obj = new Object();
		T1 t1 = new T1(obj);
		T2 t2 = new T2(obj, t1);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}

class T1 extends Thread {
	
	private Object lock;
	private volatile boolean ok = false;
	
	T1(Object o) { 
		lock = o; 
	}
	
	@Override 
	public void run() {
		while(true) {
			synchronized(lock) {
				while(!ok) {
					System.out.println("I am not ok");
					try {
						lock.wait();
					} catch (InterruptedException e) {}
				}
				System.out.println("I am ok");
			}
		}
	}
	
	public synchronized void setOk(boolean ok) {
		this.ok = ok;
	}
	
	public boolean getOk() {
		return ok;
	}
}

class T2 extends Thread {
	
	private Object lock;
	private T1 t;
	
	T2(Object o, T1 t) { 
		lock = o; 
		this.t = t;
	}
	
	@Override 
	public void run() {
		while(true) {
			synchronized(lock) {
				try {
					Thread.sleep(100); }
				catch(InterruptedException e) {}
				t.setOk(!t.getOk());
				lock.notify();
			}
		}
	}
}