package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientConnection extends Thread {
	private EventHandler controller;
	private Socket socket;
	private String name;
	ArrayList<Integer> diceValues = new ArrayList<Integer>();
	private ArrayList<ClientConnection> clientList;
	int a;

	public ClientConnection(EventHandler controller, Socket socket) {
		this.controller = controller;
		this.socket = socket;
		this.name = socket.getInetAddress().toString(); // default
	}
	
	
	@Override
	public boolean equals(Object c) {
		boolean isEqual = false;
		if (c instanceof ClientConnection) {
			isEqual = ((ClientConnection) c).name.equals(name);
		}
		return isEqual;
	}

	@Override
	public String toString() {
		return name + " (" + socket.getInetAddress().toString() + ") \n";
	}
	
	

	public void close() {
		try {
		socket.close();
		} catch (IOException e) {
		// We are closing - do nothing
		}
		}
	
	public void run() {
		try {
			while(true){
			ObjectInputStream clientInputStream = new 
			        ObjectInputStream(socket.getInputStream());
			
				diceValues = (ArrayList<Integer>)clientInputStream.readObject();
				for (ClientConnection client : controller.getClientlist()) {
					ObjectOutputStream clientOutputStream = new
				            ObjectOutputStream(socket.getOutputStream());
					clientOutputStream.writeObject(diceValues);
					//for(int a:diceValues){
						//System.out.println(a);
					//}
					client.getSocket();
				}
					
				
			}	
			
			
		} catch (Exception e) {
		// TODO Add error handling
		}
		
		}
	public Socket getSocket() { 
		return socket;
	}
		
	
}
