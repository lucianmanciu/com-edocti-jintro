package com.edocti.jintro.lab09;

public class Producer extends Thread {
	private BankAccount account;
	private int amount;
	
	public Producer(BankAccount a, int amount) {
		account = a;
		this.amount = amount;
	}
	
	@Override
	public void run() {
		while(true) {
			account.deposit(amount);
			System.out.println("Producer: " + account.getBalance());
		}
	}
}
