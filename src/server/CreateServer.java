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
	
	public CreateServer(ServerSocket ServerSocket) {
		serverSocket = ServerSocket;
	}
	public CreateServer() {
		serverSocket = null;
		socket = new Socket();
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
		try {
			inputObj = new ObjectInputStream(clientSocket.getSocket().getInputStream());
		} catch(IOException e) {
			e.getStackTrace();
		}
		
		try {
			Properties pro = (Properties) inputObj.readObject();
			
			BuildCarModelOptions modelOptions = new BuildCarModelOptions();
			Automobile auto = modelOptions.createAuto(pro);
			
			auto.printOptionSet();
			
			System.out.printf("SADFKJSAKDJFLS");
			
		} catch(IOException e) {
			e.getStackTrace();
		} catch (ClassNotFoundException err) {
			err.printStackTrace();
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
