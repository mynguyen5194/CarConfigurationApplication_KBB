package scale;

import adapter.*;

public class EditOptions extends ProxyAutomobile implements ScaleThread, Runnable {
	private Thread thread;
	private int operation;
	
	// String [0] Model/oldModelName, String [1] newModelName, String [2] Name/oldName,
	// String [3] newName, String [4] newPrice = double
	private String [] name;	
	
	public EditOptions() {
		thread = new Thread(this);
		name = new String[5];
//		start();
	}
	
	public EditOptions(String [] Name) {
		thread = new Thread(this);
		name = Name;
		run();
	}
	
	public EditOptions(int Operation, String [] Name) {
		thread = new Thread(this);
		operation = Operation;
		name = Name;
		run();
		
//		stop();
	}
	
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	
	// String [0] Model/oldModelName, String [1] newModelName, String [2] Name/oldName,
	// String [3] newName, String [4] newPrice = double
	public void run() {
		switch(operation) {
		case 0:
			this.updateModelName(name[0], name[1]);
			System.out.printf("Finished updating model name\n");
//			this.stop();
			break;
			
		case 1:
			this.updateOptionName(name[0], name[2], name[3]);
			System.out.printf("Finished updating option name\n");
//			this.stop();
			break;
			
		case 2:
			double newPrice = Double.parseDouble(name[4]);
			this.updateOptionPrice(name[0], name[2], newPrice);
			System.out.printf("Finished updating option price\n");
//			this.stop();
			break;
			
		default:
			break;
		}
	}
	
	public void start() {
		try {
			System.out.printf("It's\n");
			Thread.sleep(2000);
			thread.start();
		} catch(InterruptedException e) {
			e.getMessage();
		}	
	}
	
	public void stop() 	{
		thread = null;
//		thread.stop();
		System.out.printf("Stop\n");
	}
	
	public synchronized void updateModelName(String oldModelName, String newModelName) {
		try {
			Thread.sleep(2000);
			this.updateModelName(oldModelName, newModelName);
//			this.stop();
//			System.out.printf("It's running\n");
		} catch(InterruptedException e) {
			
		}
		notifyAll();
	}
	
	public synchronized void updateOptionName(String Model, String oldName, String newName) {
		try {
			Thread.sleep(2000);
			System.out.printf("Running\n");
			this.updateOptionName(Model, oldName, newName);
			this.printFleet();
//			this.stop();
			
//			this.stop();
//			System.out.printf("It's running\n");
		} catch(InterruptedException e) {
		
		}
		notifyAll();
	}
	
	public synchronized void updateOptionPrice(String Model, String Name, double newPrice) {
		try {
			Thread.sleep(2000);
			this.updateOptionPrice(Model, Name, newPrice);
//			this.stop();
//			System.out.printf("It's running\n");
		} catch(InterruptedException e) {
		
		}
		notifyAll();
	}
	
}
