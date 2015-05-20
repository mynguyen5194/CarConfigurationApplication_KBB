package scale;

import adapter.*;

public abstract class EditOptions extends ProxyAutomobile implements ScaleThread, Runnable {
	private Thread thread;
	private int operation;
	private static ProxyAutomobile proxyAuto;
	
	public EditOptions() {}
	
	public EditOptions(int Operation) {
		operation = Operation;
	}
	
	public EditOptions(int Operation, Object [] args) {
		operation = Operation;
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
	
	public void run(String Model, String oldName, String newName, double newPrice) {
		switch(operation) {
		case 0:
			this.updateOptionName(Model, oldName, newName);
			break;
			
		case 1:
			this.updateOptionPrice(Model, oldName, newPrice);
			break;
		}
	}
	
	public void start() {
		System.out.printf("It's running\n");
		thread.start();
	}
	
	public void stop() 	{
		System.out.printf("Stop\n");
		thread.stop();
	}
	
	public synchronized void updateModelName(String oldModelName, String newModelName) {
		proxyAuto.updateModelName(oldModelName, newModelName);
	}
	
	public synchronized void updateOptionName(String Model, String oldName, String newName) {
		proxyAuto.updateOptionName(Model, oldName, newName);
	}
	
	public synchronized void updateOptionPrice(String Model, String Name, double newPrice) {
		proxyAuto.updateOptionPrice(Model, Name, newPrice);
	}
	
}
