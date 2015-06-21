package server;

import java.net.*;
import java.io.*;
import java.util.*;
import model.*;

public class CreateServer {
	private ServerSocket serverSocket;
	private DefaultSocketClient clientSocket;
	private Socket socket;
	private static Fleet fleet;
	
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
//		while(true) {
			try {
				socket = serverSocket.accept();
	        	clientSocket = new DefaultSocketClient(socket);
//	        	Thread thread = new Thread(clientSocket);
//	        	thread.start();
	        	clientSocket.openConnection();
        	} catch (IOException e) {
        		System.err.println("Accept failed.");
        		System.exit(1);
        	}   
//		}
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
				fleet = modelOptions.addAutoToLHM(fleet, auto);
				
				clientSocket.sendObject("success");
				System.out.printf("*** Properties file uploaded from client ***\n");
			} else {
				if(receivedObject.equals("display")){
					clientSocket.sendObject(fleet);
					System.out.printf("*** Fleet is sent to client to diplay ***\n");
				} else if(receivedObject.equals("quit")){
					clientSocket.closeSession();
					System.out.printf("*** Client quit ***\n");
					break;
				} else if(receivedObject.equals("config")) {
					clientSocket.sendObject("start configuring");
					
					System.out.printf("*** Client is requesting fleet ***\n");
					clientSocket.sendObject(fleet);
				} else {
					String model = (String) receivedObject;
				
					if(fleet.containsKey(model)) {
						clientSocket.sendObject(fleet.getAuto(model));
					} else {
						clientSocket.sendObject("fail");
					}
				}
			}
		}
	}

	
	public void stopServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
}
