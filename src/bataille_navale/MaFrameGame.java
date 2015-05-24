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
		client = cli;
		//Lancement du panel
		panelgame = new PanelGame(client);
		System.out.println("coucou la frame game");
		setLayout(new GridLayout(1, 1));
		setTitle("serveur de game");
		setSize(1500, 2000);
		getContentPane().add(panelgame);
		getContentPane().setVisible(true);
		setVisible(true);
	}
}
