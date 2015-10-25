package Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class EventHandler {
	ServerGUI view;
	private Listener listener;

	public EventHandler(ServerGUI view) {
		this.view = view;
		view.btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startServer();
			}
		});
		view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				stopServer();
			}
		});
	}
	
	
	private void startServer() {
		int portNumber = Integer.parseInt(view.txtPort.getText());
		try {
		listener = new Listener(this, portNumber);
		listener.start();
		view.btnStart.setEnabled(false);
		} catch (IOException e) {
		// TODO Add error handling
		}
		}

	private void stopServer() {
		if(listener != null){
			listener.stopListening();
			// Important: Do not depend on structure of list,
			// as we will be changing it. Hence, "while not empty"
			while (!clientList.isEmpty()) {
				ClientConnection client = clientList.get(0);
				client.close();
				removeClient(client);
				view.updateClientDisplay(clientList);
			}
		}
		
		System.exit(0);
	}

	private ArrayList<ClientConnection> clientList = new ArrayList<>();

	public void addClient(ClientConnection newClient) {
		synchronized (clientList) {
			clientList.add(newClient);
			view.updateClientDisplay(clientList);
		}
	}
	
	

	public void removeClient(ClientConnection oldClient) {
		synchronized (clientList) {
			for (Iterator<ClientConnection> i = clientList.iterator(); i.hasNext();) {
				ClientConnection client = i.next();
				if (client.equals(oldClient))
					i.remove();
			}
			view.updateClientDisplay(clientList);
		}
	}
	public ArrayList<ClientConnection> getClientlist(){
		return clientList;
		
	}

}