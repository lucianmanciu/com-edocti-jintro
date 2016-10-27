package com.edocti.jintro.lab09;

public class BankAccountClassic2 implements BankAccount {
	
	private int balance;
	private int cucu;
	
	@Override
	public /*synchronized*/ void deposit(int amount) {
		synchronized(this) {
			balance += amount;
		}
		cucu += amount;
	}
	
	@Override
	public /*synchronized*/ void withdraw(int amount) {
		deposit(-amount);
	}
	
	@Override
	public synchronized int getBalance() {
		return balance;
	}
	
	public int getCucu() {
		return cucu;
	}
	
	public static void main(String[] args) throws InterruptedException {
		final BankAccountClassic2 ion = new BankAccountClassic2();
		
		Thread[] producers = new Thread[10];
		Thread[] consumers = new Thread[10];
		
		for (int i = 0; i < 10; i++) {
			producers[i] = new Producer(ion, 10);
			producers[i].start();
			consumers[i] = new Consumer(ion, 5);
			consumers[i].start();
		}
		
		for(int i = 0; i < 10; i++) {
			producers[i].join();
			consumers[i].join();
		}
	}
}
