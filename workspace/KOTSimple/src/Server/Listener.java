package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener extends Thread {
	EventHandler controller;
	ServerSocket listener;
	ClientConnection c;
	volatile boolean stopThread = false;

	public Listener(EventHandler controller, int port) throws IOException {
		super("Listener:" + port); // name of our thread
		this.controller = controller;
		listener = new ServerSocket(port);
	}

	public void stopListening() {
		if (!this.stopThread) {
			this.stopThread = true;
			try {
				listener.close();
			} catch (IOException e) {
				// Do nothing -
				// we are quitting anyway
			}
		}
	}

	@Override
	public void run() {
		while (!stopThread) {
			Socket socket;
			try {
				socket = listener.accept(); // wait for a request
				ClientConnection newClient = new ClientConnection(controller, socket);
				controller.addClient(newClient); // process the request
				newClient.start();
				//newClient.broadcast();
			} catch (IOException e) {
				// TODO Add error handling
			}
		}
	}
}