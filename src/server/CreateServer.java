package server;

import java.net.*;
import java.io.*;
import java.util.*;

import model.*;
import util.*;

public class CreateServer {
	private ServerSocket serverSocket;
	private ObjectInputStream inputObj;
	private ObjectOutputStream outputObj;
	private DefaultSocketClient clientSocket;
	private Socket socket;
	private static Fleet fleet;
	
	public CreateServer(ServerSocket ServerSocket) {
		serverSocket = ServerSocket;
	}
	public CreateServer() {
		serverSocket = null;
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
	public ObjectInputStream getInputObj() {
		return inputObj;
	}
	public ObjectOutputStream getOutputObj() {
		return outputObj;
	}
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	public void setInputObj(ObjectInputStream inputObj) {
		this.inputObj = inputObj;
	}
	public void setOutputObj(ObjectOutputStream outputObj) {
		this.outputObj = outputObj;
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
	       
	    try {    	
	    	PrintWriter out = new PrintWriter(clientSocket.getSocket().getOutputStream(), true);
	        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getSocket().getInputStream()));
	    } catch(IOException e) {
	    	e.getStackTrace();
	    }
	}
	
	public void handleConnection() {
		Automobile auto = new Automobile();
		BuildCarModelOptions modelOptions = new BuildCarModelOptions();
		
		try {
			inputObj = new ObjectInputStream(clientSocket.getSocket().getInputStream());
		} catch(IOException e) {
			e.getStackTrace();
		}
		
//		while(true) {
			try {
//				Properties pro = (Properties) inputObj.readObject();
//				
//				auto = modelOptions.createAuto(pro);
//				
//				fleet = modelOptions.addAutoToLHM(fleet, auto);
//				fleet.printFleet();
				
				
				System.out.println("command received");
				String command = (String) inputObj.readObject();
				
				switch(command) {
				case "update":
					Properties pro = (Properties) inputObj.readObject();
					
					auto = modelOptions.createAuto(pro);
					
					fleet = modelOptions.addAutoToLHM(fleet, auto);
					fleet.printFleet();
					this.respond("received");
//					outputObj.flush();
					break;
//					
//				case "display":
//					System.out.println("Fleet is printed out here");
//					this.sendRequest(fleet);
//					break;
				}
				
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
//		}
	}
	
//	public void process() {
		
	
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
//		try {
//			outputObj = new ObjectOutputStream(clientSocket.getSocket().getOutputStream());
//		} catch(IOException e) {
//			e.getStackTrace();
//		}
		
		try {
			outputObj.writeObject(output);
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	public void stopServer() {
		try {
			serverSocket.close();
			clientSocket.closeSession();
			inputObj.close();
			outputObj.close();
			
			System.out.printf("Server stopped!\n");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
}
