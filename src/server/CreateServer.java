package server;

import java.net.*;
import java.io.*;

public class CreateServer {
	private ServerSocket serverSocket;
	private DefaultSocketClient clientSocket;
	private PrintWriter writer;
	private BufferedReader reader;
	
	public CreateServer() {}
	public CreateServer(ServerSocket ServerSocket, DefaultSocketClient ClientSocket) {
		serverSocket = ServerSocket;
		clientSocket = ClientSocket;
	}
	
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	public DefaultSocketClient getClientSocket() {
		return clientSocket;
	}
	public PrintWriter getWriter() {
		return writer;
	}
	public BufferedReader getReader() {
		return reader;
	}
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	public void setClientSocket(DefaultSocketClient clientSocket) {
		this.clientSocket = clientSocket;
	}
	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}
	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}
	
	public void createServer() {
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
	}
	
	public void startServer() {
		while(true) {
	        try {
	            clientSocket = serverSocket.accept();
	        } catch (IOException e) {
	            System.err.println("Accept failed.");
	            System.exit(1);
	        }
		}
		
		writer = new PrintWriter(clientSocket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	public void handleConnection() {
		
	}
	
	public void stopServer() {
		try {
			serverSocket.close();
			clientSocket.closeSession();
			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
