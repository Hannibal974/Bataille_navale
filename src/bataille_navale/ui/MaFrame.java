package bataille_navale.ui;


import javax.swing.JFrame;
import bataille_navale.Client;

public class MaFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 367283965898819135L;
	private PanelConnect panelconnect;
	//private PanelLobby lobbypanel;
	private Client client;
	
	public MaFrame (Client cli)
	{
		setTitle("Bataille_navale");
		setSize(900, 600);
		client = cli;
		panelconnect = new PanelConnect(client, this);
		add(panelconnect);
	}
}
