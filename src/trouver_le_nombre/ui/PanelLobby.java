package trouver_le_nombre.ui;
/**
*
* @author Jennifer & Romain
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.json.JSONException;

//import random.core.Match;
import trouver_le_nombre.Client;
import trouver_le_nombre.ClientGame;
import trouver_le_nombre.Player;
import trouver_le_nombre.ServeurGame;

public class PanelLobby extends JPanel implements ActionListener
{
	 // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_join;
    private javax.swing.JButton b_create;
    private javax.swing.JButton b_deconnect;
	private javax.swing.JComboBox<Integer> PlayersIn;
    private javax.swing.JLabel l_EnterName;
    private javax.swing.JLabel l_JoinServ;
    private javax.swing.JLabel l_createParty1;
	private static final long serialVersionUID = -6003067736193144131L;
	private Client client;
	private Player p;
	private ArrayList<Integer> PortToUse = new ArrayList<Integer>();

	private MaFrame frame;
    // End of variables declaration//GEN-END:variables
	
	public PanelLobby (Client cli, Player play, ArrayList<Integer> listPortsToJoin, MaFrame framish)
	{
		client = cli;
		p = play;
		frame = framish;
		PortToUse=listPortsToJoin;
		initComponents();
		if(listPortsToJoin != null)
		{
			for(int i = 0; i < listPortsToJoin.size(); i++)
			{
				//Ajoute la liste des matches Disponnible
				PlayersIn.addItem(listPortsToJoin.get(i));
				i++;
			}
			System.out.println("Liste game to Join Added");
		}
		setVisible(true);
	}

	 private void initComponents() {

	        l_JoinServ = new javax.swing.JLabel();
	        l_EnterName = new javax.swing.JLabel();
	        b_join = new javax.swing.JButton();
	        b_join.addActionListener(this);
	        PlayersIn = new JComboBox<Integer>();
	        b_create = new javax.swing.JButton();
	        b_create.addActionListener(this);
	        l_createParty1 = new javax.swing.JLabel();
	        b_deconnect = new javax.swing.JButton();
	        b_deconnect.addActionListener(this);
	        l_JoinServ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
	        l_JoinServ.setText("Rejoindre une partie");

	        l_EnterName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	        l_EnterName.setText("Selectionner votre adversaire");

	        b_join.setText("Rejoindre");

	        PlayersIn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

	        b_create.setText("Creer une partie");

	        l_createParty1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	        l_createParty1.setText("Ou creer une partie:");

	        b_deconnect.setText("Se deconnecter");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(130, 130, 130)
	                                .addComponent(l_JoinServ))
	                            .addGroup(layout.createSequentialGroup()
	                                .addContainerGap()
	                                .addComponent(l_EnterName))
	                            .addGroup(layout.createSequentialGroup()
	                                .addContainerGap()
	                                .addComponent( PlayersIn, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(b_join, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addContainerGap()
	                                .addComponent(l_createParty1)))
	                        .addGap(0, 4, Short.MAX_VALUE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(b_create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(b_deconnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(l_JoinServ)
	                .addGap(25, 25, 25)
	                .addComponent(l_EnterName)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent( PlayersIn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(b_join, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(33, 33, 33)
	                .addComponent(l_createParty1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(b_create, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
	                .addComponent(b_deconnect)
	                .addContainerGap())
	        );
	    }
		public ArrayList<Integer> getPortToUse() {
			return PortToUse;
		}

		public void setPortToUse(ArrayList<Integer> portToUse) {
			PortToUse = portToUse;
		}
		
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == b_create)
		{
			ArrayList<Integer> portToUse = new ArrayList<Integer>();
			System.out.println("player asked to create game");
			int port = client.CreateServeur(p);
			//set port
			client.setPort(port);
			p.setGamePort(port);
			//Ajout du player sur le serveur
			client.PlayerInGame(p);
			portToUse.add(port);
			PlayersIn.addItem(port);
			// Attente que match reçoit sont 2nd joueur pour lancer GamePanel.
			ServeurGame sg = null;
			lancheGame(port, "create", sg);
			PortToUse.add(port);
			SwingUtilities.updateComponentTreeUI(frame);
		}
		else if (e.getSource() == b_join)
		{
			int port = Integer.parseInt(PlayersIn.getSelectedItem().toString());
			ClientGame cliG = new ClientGame(port, "join");
			try{
				p.setGamePort(port);
				client.JoinServeur(p);
				ServeurGame sg2 = new ServeurGame(cliG,port);
				lancheGame(port, "join", sg2 );
				System.out.println("Player " + p + "is connected on : "+ port);
				
			}
			catch (Exception e1) {
				System.err.println("Port selected : " +e1.getMessage());
			}
			SwingUtilities.updateComponentTreeUI(frame);
			//lancheGame(port, name, null);	
		}
		
		if(e.getSource() == b_deconnect)
		{
			PlayersIn.removeItem(client.getPort());
			SwingUtilities.updateComponentTreeUI(frame);
	        client.Disconnect(client);
		}
	}
	
	@SuppressWarnings("static-access")
	public void lancheGame(int Port, String j, ServeurGame sg)
	{
		//list port
		System.out.println("Création du clientGame");
		ClientGame cliG = new ClientGame(Port, "j", sg);
		try { 
			ServeurGame sg1 = new ServeurGame(cliG,Port);
			System.out.println("cligMain launch");
			cliG.main(null,Port, sg1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JSONExeption");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOExeption");
		}
	}
}
