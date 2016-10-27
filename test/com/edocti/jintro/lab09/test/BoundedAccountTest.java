package com.edocti.jintro.lab09.test;

import com.edocti.jintro.lab09.BoundedAccount;
import com.edocti.jintro.lab09.Consumer;
import com.edocti.jintro.lab09.Producer;

public class BoundedAccountTest {

	public static void main(String[] args) throws InterruptedException {
		
		BoundedAccount b = new BoundedAccount(0, 10_000);
		Producer p = new Producer(b, 10);
		Consumer c = new Consumer(b, 10);
		p.start();
		c.start();
		p.join();
		c.join();

	}

}
