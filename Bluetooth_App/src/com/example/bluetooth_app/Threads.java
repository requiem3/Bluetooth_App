package com.example.bluetooth_app;

import com.example.bluetooth_app.Constants;

public class Threads extends Thread {
	private Constants constants;
	private acceptNewThread anThread;
	private newConnectionThread ncThread;
	private alreadyConnectedThread acThread;
	
	public void startThreads() {
		anThread = new acceptNewThread();
		ncThread = new newConnectionThread();
		acThread = new alreadyConnectedThread();
		
	}
	
	private class acceptNewThread { //Thread for accepting new connections, basically runs until it accepts a connections
		public acceptNewThread() {
			
		}
	}
	
	private class newConnectionThread { //Thread for attempting to make a connection
		public newConnectionThread() {
			
		}
	}
	
	private class alreadyConnectedThread { //Thread that runs when already connected to a device
		public alreadyConnectedThread() {
			
		}
	}
}
