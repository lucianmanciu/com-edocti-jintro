package com.edocti.jintro.lab09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedAccount implements BankAccount {
	
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
	
	private int balance;
	private int max;
	private int min;
	
	public BoundedAccount(int min, int max) {
		this.balance = 0;
		this.min = min;
		this.max = max;
	}
	@Override
	public void deposit(int amount) {
		lock.lock();
		try {
			while(balance >= max) {
				try { notFull.await(); }
				catch(InterruptedException e) {}
			}
			balance += amount;
		} finally {
			notEmpty.signalAll();
			lock.unlock();
		}
	}
	
	@Override
	public void withdraw(int amount) {
		lock.lock();
		try {
			while(balance <= min) {
				try { notEmpty.await(); }
				catch(InterruptedException e) {}
			}
			balance -= amount;
		} finally {
			notFull.signalAll();
			lock.unlock();
		}
	}
	
	@Override
	public synchronized int getBalance() {
		return balance;
	}
	
	public static void main(String[] args) throws InterruptedException {
		final BoundedAccount ion = new BoundedAccount(10, 1_000_000);
		
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
