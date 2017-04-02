package com.deadlock;

public class Y {
	
	synchronized void monitorY(X x) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x.synchronizedMethod();
	}
	
	synchronized void synchronizedMethod() {
		
	}
}
