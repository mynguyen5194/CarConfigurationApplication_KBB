package server;

import java.net.*;
import java.io.*;

public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants {
	private BufferedReader reader;
	private BufferedWriter writer;
	private Socket socket;
	private String strHost;
	private int iPort;
	
	public DefaultSocketClient() {}
	public DefaultSocketClient(String StrHost, int IPort) {
		strHost = StrHost;
		iPort = IPort;
	}
	
	public BufferedReader getReader() {
		return reader;
	}
	public BufferedWriter getWriter() {
		return writer;
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
	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}
	public void setWriter(BufferedWriter writer) {
		this.writer = writer;
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
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch(Exception e) {
			if(DEBUG) {
				System.out.printf("\nUnable to obtain stream to/from " + strHost + "\n");
			}
			opened = false;
		}
		
		return opened;
	}
	
	public void handleSession() {
		String strInput = "";
		
		if(DEBUG) {
			System.out.printf("Handling session with " + strHost + ": " + iPort);
		}
		
		try {
			while((strInput  = reader.readLine()) != null) {
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
			writer.write(strOutput, 0, strOutput.length());
		} catch(IOException e) {
			if(DEBUG) {
				System.out.printf("Error writing to " + strHost + "\n");
			}
		}
	}
	
	public void handleInput(String strInput) {
		System.out.printf(" " + strInput + " \n");
	}
	
	public void closeSession() {
		try {
			writer = null;
			reader = null;
			socket.close();
		} catch (IOException e) {
			if(DEBUG) {
				System.out.printf("\nError closing socket to " + strHost + "\n");
			}
		}
	}
}
