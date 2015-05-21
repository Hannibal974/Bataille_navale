package bataille_navale.ui;

import java.awt.Frame;

import bataille_navale.Client;

@SuppressWarnings("serial")
public class MaFrame extends Frame 
{
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
