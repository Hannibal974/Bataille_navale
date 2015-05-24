package bataille_navale;

import java.awt.GridLayout;

import javax.swing.JFrame;

import bataille_navale.ui.PanelGame;

@SuppressWarnings("serial")
public class MaFrameGame extends JFrame
{
	private PanelGame panelgame;
	private ClientGame client;
	
	public MaFrameGame (ClientGame cli)
	{
		setTitle("Trouver le nom");
		setSize(900, 600);
		setLayout(new GridLayout(1, 1));
		client = cli;
		//Lancement du panel1
		panelgame = new PanelGame(client);
		panelgame.setVisible(true);
		System.out.println("Ajout de la frame game");
		add(panelgame);
		System.out.println("Affiche frame Game");
	}
}
