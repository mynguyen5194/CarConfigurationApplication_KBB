package server;

import java.net.*;
import java.io.*;
import java.util.*;

import util.*;
import model.*;

public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants {
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Socket socket;
	private String strHost;
	private int iPort;
	
	
	public DefaultSocketClient() {}
	public DefaultSocketClient(Socket Socket) {
		socket = Socket;
	}
	public DefaultSocketClient(String StrHost, int IPort) {
		strHost = StrHost;
		iPort = IPort;
	}
	
	public void send(Object x) throws IOException {
		writer.writeObject(x);
	}
	public Object get() throws IOException, ClassNotFoundException{
		return reader.readObject();
	}
	public Socket getSocket() {
		return socket;
	}
	public String getStrHost() {
		return strHost;
	}
	public int getiPort() {
		return iPort;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public void setStrHost(String strHost) {
		this.strHost = strHost;
	}
	public void setiPort(int iPort) {
		this.iPort = iPort;
	}
	
	
	public void run() {
		if(openConnection()) {
			this.handleSession();
			this.closeSession();
		}
	}
	
	public boolean openConnection() {
		boolean opened = true;
		try {
			System.out.println("creating sockets");
			writer = new ObjectOutputStream(socket.getOutputStream());
			reader = new ObjectInputStream(socket.getInputStream());			
		} catch(IOException e) {
			if(DEBUG) {
				e.printStackTrace();
				System.err.printf("Unable to obtain stream to/from " + strHost + "\n");
			}
			opened = false;
		}
		
		return opened;
	}
	
	public void handleSession() {
		String strInput = "";
		System.out.println("Running handle Session");
		
		if(DEBUG) {
			System.out.printf("Handling session with " + strHost + ": " + iPort);	
		}
		try {
			while((strInput = reader.readLine()) != null) {
				handleInput(strInput);
			}
		} catch(IOException e) {
			if(DEBUG) {
				System.out.printf("Handling session with " + strHost + ": " + iPort);
			}
		}
	}

	public void sendOutput(String strOutput) {
		try {
			writer.writeObject(strOutput);
		} catch(IOException e) {
			if(DEBUG) {
				System.out.printf("Error writing to " + strHost + "\n");
			}
		}
	}
	
	public void handleInput(String strInput) {
		System.out.printf(" " + strInput + " \n");
	}
	
	public void sendPropertiesObj(Properties pro) {
		try {
			OutputStream output = socket.getOutputStream();
			ObjectOutputStream objOutput = new ObjectOutputStream(output);
			objOutput.writeObject(pro);
			
			FileIO fileIO = new FileIO();
			Automobile auto = fileIO.parsePropertiesFile(pro);
			
			auto.printOptionSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendCommand(String command) {
		try {
			OutputStream output = socket.getOutputStream();
			ObjectOutputStream objOutput = new ObjectOutputStream(output);
			this.sendOutput(command);
//			objOutput.writeObject(command);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String receiveCommand() {
		String command = "";
		try {
			command = (String) reader.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return command;
	}
	
	public void closeSession() {
		try {
			writer = null;
			reader = null;
			socket.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
}
