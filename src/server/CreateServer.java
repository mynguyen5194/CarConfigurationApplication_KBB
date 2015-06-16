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
			Object recievedObject = clientSocket.getObject();
			Properties pro = new Properties();
			
			if(recievedObject.getClass().equals(pro.getClass())){
				pro = (Properties) recievedObject;
				
				auto = modelOptions.createAuto(pro);
				
				fleet = modelOptions.addAutoToLHM(fleet, auto);
				
				clientSocket.sendObject("success");
			} else {
				if(recievedObject.equals("display")){
					fleet.printFleet();
					clientSocket.sendObject(fleet);
				} else {
					
				}
			}
		}
	}

	
	public void stopServer() {
		try {
			serverSocket.close();
			clientSocket.closeSession();
			System.out.printf("Server stopped!\n");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
}
