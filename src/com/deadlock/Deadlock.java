package com.deadlock;

public class Deadlock implements Runnable{
	
	X x;
	Y y;
	
	public Deadlock(X x, Y y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		if(name.equalsIgnoreCase("Thread_1"))
			x.monitorX(y);
		else
			y.monitorY(x);
	}
	
	public static void main(String[] args) {
		X x = new X();
		Y y = new Y();
		
		Thread t1 = new Thread(new Deadlock(x, y));
		t1.setName("Thread_1");
		
		Thread t2 = new Thread(new Deadlock(x, y));
		t2.setName("Thread_2");
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("This will not be executed!");
	}

	

}
