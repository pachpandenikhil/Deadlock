package com.deadlock;

public class X {

	synchronized void monitorX(Y y) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		y.synchronizedMethod();
	}

	synchronized void synchronizedMethod() {

	}
}
