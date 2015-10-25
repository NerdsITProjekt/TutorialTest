package Client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;



public class ClientGUI extends JFrame implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton btnRandom =  new JButton("W�rfeln");
JLabel Label1 = new JLabel();
JLabel Label2 = new JLabel();
JLabel Label3 = new JLabel();
 JLabel Label4 = new JLabel();
 JLabel Label5= new JLabel();
 ArrayList<ImageIcon> picList= new ArrayList<ImageIcon>();
JButton btnConnect =  new JButton("Verbinden");
JFrame frame = new JFrame(" random image app");
 JCheckBox checkbox1 = new JCheckBox("W�rfel 1");
JCheckBox checkbox2 = new JCheckBox("W�rfel 2");
JCheckBox checkbox3 = new JCheckBox("W�rfel 3");
JCheckBox checkbox4 = new JCheckBox("W�rfel 4");
JCheckBox checkbox5 = new JCheckBox("W�rfel 5");


 

	public static void main(String[] args) {
		
		ClientGUI view = new ClientGUI();
		ClientLogic logic = new ClientLogic(view);
		 EventHandler controller = new EventHandler( view,logic);
		
	}

	public ClientGUI() {
		
		
		
		ArrayList<ImageIcon> picList;

		picList = new ArrayList<ImageIcon>();
		picList.add(new ImageIcon(getClass().getResource("RollOne.jpg")));
		picList.add(new ImageIcon(getClass().getResource("RollTwo.jpg")));
		picList.add(new ImageIcon(getClass().getResource("RollThree.jpg")));
		picList.add(new ImageIcon(getClass().getResource("RollFour.jpg")));
		picList.add(new ImageIcon(getClass().getResource("RollFive.jpg")));

		
		
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());

		Label1 = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				if (getIcon() != null) {
					Graphics2D g2d = (Graphics2D) g;
					// g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
					// RenderingHints.VALUE_RENDER_QUALITY);
					g2d.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, getWidth(), getHeight(), this);
				}

			}
		};
		Label2 = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				if (getIcon() != null) {
					Graphics2D g2d = (Graphics2D) g;
					// g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
					// RenderingHints.VALUE_RENDER_QUALITY);
					g2d.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, getWidth(), getHeight(), this);
				}

			}
		};
		Label3 = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				if (getIcon() != null) {
					Graphics2D g2d = (Graphics2D) g;
					// g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
					// RenderingHints.VALUE_RENDER_QUALITY);
					g2d.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, getWidth(), getHeight(), this);
				}

			}
		};
		Label4 = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				if (getIcon() != null) {
					Graphics2D g2d = (Graphics2D) g;
					// g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
					// RenderingHints.VALUE_RENDER_QUALITY);
					g2d.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, getWidth(), getHeight(), this);
				}

			}
		};
		Label5 = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				if (getIcon() != null) {
					Graphics2D g2d = (Graphics2D) g;
					// g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
					// RenderingHints.VALUE_RENDER_QUALITY);
					g2d.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, getWidth(), getHeight(), this);
				}

			}
		};

		
		
		
			int counter = 0;
		

		Label1.setPreferredSize(new Dimension(50, 50));
		Label2.setPreferredSize(new Dimension(50, 50));
		Label3.setPreferredSize(new Dimension(50, 50));
		Label4.setPreferredSize(new Dimension(50, 50));
		Label5.setPreferredSize(new Dimension(50, 50));
		frame.add(Label1);
		frame.add(Label2);
		frame.add(Label3);
		frame.add(Label4);
		frame.add(Label5);
		frame.add(BorderLayout.SOUTH, btnRandom);
		frame.add(BorderLayout.SOUTH, btnConnect);
		frame.add(BorderLayout.NORTH, checkbox1);
		frame.add(BorderLayout.NORTH, checkbox2);
		frame.add(BorderLayout.NORTH, checkbox3);
		frame.add(BorderLayout.NORTH, checkbox4);
		frame.add(BorderLayout.NORTH, checkbox5);
		checkbox1.setEnabled(false);
		checkbox2.setEnabled(false);
		checkbox3.setEnabled(false);
		checkbox4.setEnabled(false);
		checkbox5.setEnabled(false);
		checkbox1.setSelected(true);
		checkbox2.setSelected(true);
		checkbox3.setSelected(true);
		checkbox4.setSelected(true);
		checkbox5.setSelected(true);

		frame.setVisible(true);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
}
