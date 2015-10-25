package Server;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Server for the SimpleChat example.
 */
public class ServerGUI extends JFrame {
	// Create GUI controls
	JLabel lblPort = new JLabel("Port");
	JTextField txtPort = new JTextField(6);
	JButton btnStart = new JButton("Start");
	JTextArea txtClients = new JTextArea(20, 50);

	/**
	 * Purpose of the main method: Create the main program instance (singleton!)
	 */
	public static void main(String[] args) throws Exception{
		ServerGUI view = new ServerGUI();
		EventHandler controller = new EventHandler(view);
	}

	/**
	 * Create the GUI
	 */
	private ServerGUI() {
		super("SimpleChat Server");
		this.setLayout(new BorderLayout());

		// Top box contains Port info, plus start-button
		Box topBox = Box.createHorizontalBox();
		topBox.add(lblPort);
		topBox.add(txtPort);
		topBox.add(Box.createHorizontalStrut(50));
		topBox.add(btnStart);
		this.add(topBox, BorderLayout.NORTH);

		// put txtClients in a ScrollPane, give it a reasonable size
		JScrollPane scrollPane = new JScrollPane(txtClients);
		txtClients.setEditable(false);
		this.add(scrollPane, BorderLayout.CENTER);

		this.pack();
		this.setVisible(true);
	}
	
	public void updateClientDisplay(ArrayList<ClientConnection> clients) {
		StringBuffer buf = new StringBuffer();
		for (ClientConnection client : clients) {
		buf.append(client.toString());
		}
		txtClients.setText(buf.toString());
		}

	/**
	 * Accumulate client descriptions in a StringBuffer, then overwrite the contents of txtClients
	 */
	/*StringBuffer buf = new StringBuffer();
		for (ClientConnection client : clients) {
			buf.append(client.toString());
		}
		txtClients.setText(buf.toString());*/
	
}
