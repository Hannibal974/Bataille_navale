package bataille_navale.ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import bataille_navale.Client;

public class PanelLobby extends JPanel
{
	private Client client;
	private JButton buttonConnect;
	
	public PanelLobby (Client cli)
	{
		setLayout(new GridLayout(1,1));
		client = cli;
		buttonConnect = new JButton("Create game");
		add(buttonConnect);
		setVisible(true);
	}
	
	
}
