package Client;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class ClientLogic extends Thread  {
private ClientGUI view;
Socket socket;
private volatile boolean stopThread = false;
public ClientLogic(ClientGUI view) {
this.view = view;
}
public void connect() {
try {
int port = 55555;
socket = new Socket("localhost", port);
view.btnConnect.setEnabled(false);
//socket.close();
//Message msgRegister = new Message(Message.MessageType.Register );
//msgRegister.setName(view.txtName.getText());
//msgRegister.send(socket);
// Start receiving messages
this.start(); // TODO verify that we receive a "confirm" message
} catch (Exception e) {
// Do nothing - we are closing anyway
}
}
public void disconnect() {
try {
socket.close();
stopThread = true;
this.interrupt();
} catch (IOException e) {
// Do nothing - we are closing anyway
}
}
public Socket getSocket(){
	return socket;
}



}
