package bataille_navale.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;


//import random.core.Match;
import bataille_navale.Client;
import bataille_navale.Player;

public class PanelLobby extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6003067736193144131L;
	private Client client;
	private Player p;
	private JButton buttonCreate, buttonjoin;
	//private JComboBox<Match> combomatches;
	private JComboBox<String> PlayersIn;
	
	public PanelLobby (Client cli, Player play, String[] listMatchToJoin)
	{
		setLayout(new GridLayout(1,3));
		//combomatches = new JComboBox<Match>();
		PlayersIn = new JComboBox<String>();
		client = cli;
		p = play;
		buttonCreate = new JButton("Create game");
		buttonCreate.addActionListener(this);
		
		//add(combomatches);
		for(int i = 0; i < listMatchToJoin.length; i++)
		{
			//il faut concaténer la ligne i et i+1 pour avoir le thread et le nom du joueur sur la même ligne
			PlayersIn.addItem("Playeur: "+listMatchToJoin[i]+"| Match: "+listMatchToJoin[i+1]);
			i++;//Il faut avancer de 2 lignes du coup 
		}
		buttonjoin = new JButton("Rejoindre");
		buttonjoin.addActionListener(this);
		add(PlayersIn);
		add(buttonCreate);
		add(buttonjoin, BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == buttonCreate)
		{
			String validation = client.CreateMatch(p);
			System.out.println(validation);
		}
		else if (e.getSource() == buttonjoin)
		{
			String validation = client.JoinMatch(PlayersIn.getSelectedIndex(), p);
			System.out.println(validation);
		}
	}
	
	
}
