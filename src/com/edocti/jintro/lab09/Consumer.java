package com.edocti.jintro.lab09;

public class Consumer extends Thread {
	private BankAccount account;
	private int amount;
	
	public Consumer(BankAccount a, int amount) {
		account = a;
		this.amount = amount;
	}
	
	@Override
	public void run() {
		while(true) {
			account.withdraw(amount);
			System.out.println("Consumer: " + account.getBalance());
		}
	}
}
