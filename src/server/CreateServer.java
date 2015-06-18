package server;

import java.net.*;
import java.io.*;
import java.util.*;
import model.*;

public class CreateServer {
	private ServerSocket serverSocket;
	private DefaultSocketClient clientSocket;
	private Socket socket;
	private Fleet fleet;
	
	public CreateServer(ServerSocket ServerSocket) {
		serverSocket = ServerSocket;
	}
	public CreateServer() {
		socket = new Socket();
		fleet = new Fleet();
		
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
	}
	
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	
	public void startServer() {
		socket = null;	
		try {
			socket = serverSocket.accept();
	        clientSocket = new DefaultSocketClient(socket);
	        clientSocket.openConnection();
        } catch (IOException e) {
        	System.err.println("Accept failed.");
        	System.exit(1);
        }   
	}
	
	public void handleConnection() {
		Automobile auto = new Automobile();
		BuildCarModelOptions modelOptions = new BuildCarModelOptions();
		
		while(true) {
			Object receivedObject = clientSocket.getObject();
			Properties pro = new Properties();
			
			// Upload properties file
			if(receivedObject.getClass().equals(pro.getClass())){
				pro = (Properties) receivedObject;
				
				auto = modelOptions.createAuto(pro);
				auto.printOptionSet();
				
				fleet = modelOptions.addAutoToLHM(fleet, auto);
				
				clientSocket.sendObject("success");
			} else {	// display the fleet, config a car, and quit
				if(receivedObject.equals("display")){
					clientSocket.sendObject(fleet);
				} else if(receivedObject.equals("quit")){
					clientSocket.sendObject("terminated");
					this.stopServer();
				} else {	//if(receivedObject.equals("config")) {
					String userChoice = (String) clientSocket.getObject(); 
					
					System.out.printf(" " + userChoice + "\n");
				}
			}
		}
	}

	
	public void stopServer() {
		try {
			serverSocket.close();
			clientSocket.closeSession();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
}
