package com.edocti.jintro.lab09;

public class BankAccountClassic {
	
	private int balance;
	private int cucu;
	
	public /*synchronized*/ void deposit(int amount) {
		synchronized(this) {
			balance += amount;
		}
		cucu += amount;
	}
	
	public /*synchronized*/ void withdraw(int amount) {
		deposit(-amount);
	}
	
	public synchronized int getBalance() {
		return balance;
	}
	
	public int getCucu() {
		return cucu;
	}
	
	public static void main(String[] args) throws InterruptedException {
		final BankAccountClassic ion = new BankAccountClassic();
		
		Thread[] producers = new Thread[10];
		Thread[] consumers = new Thread[10];
		
		for (int i = 0; i < 10; i++) {
			producers[i] = new Thread(new Runnable() {
				@Override public void run() {
					while(true) { 
						ion.deposit(10); 
						int b = ion.getBalance();
						int c = ion.getCucu();
						if (b != c) {
							System.out.printf("%d - %d\n", b, c);
						}
					}
				}
			});
			producers[i].start();
			
			consumers[i] = new Thread(new Runnable() {
				@Override public void run() {
					while(true) {
						ion.withdraw(5);
						int b = ion.getBalance();
						int c = ion.getCucu();
						if (b != c) {
							System.out.printf("%d - %d\n", b, c);
						}
					}
				}
			});
			consumers[i].start();
		}
		
		for(int i = 0; i < 10; i++) {
			producers[i].join();
			consumers[i].join();
		}
	}
}
