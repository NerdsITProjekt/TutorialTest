package Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Message {
	public static Message receive(Socket socket) throws IOException, ClassNotFoundException  {
		 ObjectInputStream clientInputStream = new 
		            ObjectInputStream(socket.getInputStream());
		
		Message msg = (Message) clientInputStream.readObject();

		return msg;
	}
}
