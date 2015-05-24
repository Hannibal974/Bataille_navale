package bataille_navale;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bataille_navale.ui.PanelGame;

public class MaFrameGame extends JFrame
{
	private JLabel label;
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
		getContentPane().setVisible(true);
		setVisible(true);
	}
}
