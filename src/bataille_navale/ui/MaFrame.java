package bataille_navale.ui;

import java.awt.Frame;

import bataille_navale.Client;

public class MaFrame extends Frame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelConnect panelconnect;
	private Client client;
	
	public MaFrame (Client cli)
	{
		setTitle("Bataille_navale");
		setSize(900, 600);
		client = cli;
		panelconnect = new PanelConnect(client);
		add(panelconnect);
	}
}
