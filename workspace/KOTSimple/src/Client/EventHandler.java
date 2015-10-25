package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class EventHandler implements ActionListener, Serializable {
	ClientGUI view;
	ClientLogic logic;
	ArrayList<ImageIcon> picList = new ArrayList<ImageIcon>();
	ArrayList<Integer> diceValues = new ArrayList<Integer>();

	public EventHandler(ClientGUI view, ClientLogic logic) {
		this.view = view;
		this.logic = logic;
		// Connect ActionListener to the relevant controls
		view.btnConnect.addActionListener(this);
		view.btnRandom.addActionListener(this);
		// view.txtMessage.addActionListener(this);

		picList.add(new ImageIcon(getClass().getResource("RollOne.jpg")));
		picList.add(new ImageIcon(getClass().getResource("RollTwo.jpg")));
		picList.add(new ImageIcon(getClass().getResource("RollThree.jpg")));
		picList.add(new ImageIcon(getClass().getResource("RollFour.jpg")));
		picList.add(new ImageIcon(getClass().getResource("RollFive.jpg")));
		view.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (logic.getSocket() != null) {
					EventHandler.this.logic.disconnect();
					System.exit(0);
				} else {
					System.exit(0);
				}
			}
		});
	}

	/**
	 * Determine which control generated the event, and take the appropriate
	 * action
	 */
	int counter = 0;

	@Override

	public void actionPerformed(ActionEvent evt) {
		Object control = evt.getSource();
		if (control == view.btnConnect) {
			logic.connect();

		}
		if (control == view.btnRandom) {
			int rand1;
			int rand2;
			int rand3;
			int rand4;
			int rand5;

			// Schleife verhindert das ein Bilder mehrmals angezeigt werden so
			// wird nach jedem klick ein neues angezeigt
			rand1 = (int) (Math.random() * picList.size());
			rand2 = (int) (Math.random() * picList.size());
			rand3 = (int) (Math.random() * picList.size());
			rand4 = (int) (Math.random() * picList.size());
			rand5 = (int) (Math.random() * picList.size());

			if (counter < 3 && view.checkbox1.isSelected()) {
				view.Label1.setIcon(picList.get(rand1));
			}

			if (counter < 3 && view.checkbox2.isSelected()) {
				view.Label2.setIcon(picList.get(rand2));
			}
			if (counter < 3 && view.checkbox3.isSelected()) {
				view.Label3.setIcon(picList.get(rand3));
			}
			if (counter < 3 && view.checkbox4.isSelected()) {
				view.Label4.setIcon(picList.get(rand4));
			}
			if (counter < 3 && view.checkbox5.isSelected()) {
				view.Label5.setIcon(picList.get(rand5));
			}

			if (counter >= 3) {
				view.btnRandom.setEnabled(false);
			}

			counter++;

			view.checkbox1.setEnabled(true);
			view.checkbox2.setEnabled(true);
			view.checkbox3.setEnabled(true);
			view.checkbox4.setEnabled(true);
			view.checkbox5.setEnabled(true);

			diceValues.add(rand1);
			diceValues.add(rand2);
			diceValues.add(rand3);
			diceValues.add(rand4);
			diceValues.add(rand5);
			
			try {
				ObjectOutputStream out = new ObjectOutputStream(logic.getSocket().getOutputStream());
				out.writeObject(diceValues);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else {
			System.out.println("Send message");
		}

	}

}