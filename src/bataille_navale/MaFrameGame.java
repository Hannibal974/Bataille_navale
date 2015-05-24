package bataille_navale;

import javax.swing.JFrame;
import bataille_navale.ui.PanelGame;

@SuppressWarnings("serial")
public class MaFrameGame extends JFrame
{
	private PanelGame panelgame;
	private ClientGame client;
	
	public MaFrameGame (ClientGame cli)
	{
		setTitle("serveur de game");
		setSize(900, 600);
		client = cli;
		//Lancement du panel
		panelgame = new PanelGame(client);
		panelgame.setVisible(true);
		System.out.println("coucou la frame game");
		add(panelgame);
		System.out.println("Affiche frame Game");
		setVisible(true);
	}
}
