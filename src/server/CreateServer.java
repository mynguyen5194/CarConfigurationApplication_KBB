package server;

import java.net.*;
import java.io.*;
import java.util.*;

import model.*;
import util.*;

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
            System.out.println("server socket created");
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
			System.out.println("accepted socket");
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
			try {
				Object recievedObject = clientSocket.get();//inputObj.readObject();
				Properties prop = new Properties();
				System.out.println(recievedObject.getClass());
				if(recievedObject.getClass().equals(prop.getClass())){
					Properties pro = (Properties) recievedObject;
					
					auto = modelOptions.createAuto(pro);
					
					fleet = modelOptions.addAutoToLHM(fleet, auto);
					//fleet.printFleet();
					
				}else{
					String choice = null;
					choice = (String) recievedObject;
					if(recievedObject.equals("display")){
						fleet.printFleet();
						clientSocket.send(fleet);
					}else{
						
					}
				}
				
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
		
	
	public void respond(Object commandObj) {
		try {
			OutputStream output = socket.getOutputStream();
			ObjectOutputStream objOutput = new ObjectOutputStream(output);
			objOutput.writeObject(commandObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendRequest(Object output) {		
		try {
			clientSocket.send(output);//outputObj.writeObject(output);
		} catch (IOException e) {
			e.getStackTrace();
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
