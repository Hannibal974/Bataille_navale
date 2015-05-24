package bataille_navale.ui;
/**
*
* @author Jennifer & Romain
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JPanel;






import org.json.JSONException;


//import random.core.Match;
import bataille_navale.Client;
import bataille_navale.Player;
import bataille_navale.ClientGame;
//import bataille_navale.ui.DialogueBox;

public class PanelLobby extends JPanel implements ActionListener
{
	 // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_join;
    private javax.swing.JButton b_create;
    private javax.swing.JButton b_deconnect;
	private javax.swing.JComboBox<String> PlayersIn;
    private javax.swing.JLabel l_EnterName;
    private javax.swing.JLabel l_JoinServ;
    private javax.swing.JLabel l_createParty1;
	private static final long serialVersionUID = -6003067736193144131L;
	private Client client;
	private Player p;
	@SuppressWarnings("unused")
	private MaFrame frame;
    // End of variables declaration//GEN-END:variables
	
	public PanelLobby (Client cli, Player play, Integer[] listPortsToJoin, MaFrame framish)
	{
		client = cli;
		p = play;
		frame = framish;
		initComponents();
		if(listPortsToJoin != null)
		{
			for(int i = 0; i < listPortsToJoin.length; i++)
			{
				//il faut concaténer la ligne i et i+1 pour avoir le thread et le nom du joueur sur la même ligne
				PlayersIn.addItem("Serveur : "+listPortsToJoin[i]);
				i++;//Il faut avancer de 2 lignes du coup 
			}
		}
		
		setVisible(true);
	}

	 private void initComponents() {

	        l_JoinServ = new javax.swing.JLabel();
	        l_EnterName = new javax.swing.JLabel();
	        b_join = new javax.swing.JButton();
	        b_join.addActionListener(this);
	        PlayersIn = new JComboBox<String>();
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
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == b_create)
		{
			System.out.println("player asked to create game");
			client.CreateServeur(p);
			// Attente que match reçoit sont 2nd joueur pour lancer GamePanel.
			lancheGame();
		}
		else if (e.getSource() == b_join)
		{
				lancheGame();	
		}
		
		if(e.getSource() == b_deconnect)
		{
			//Deconnection du client	
		}
	}
	
	@SuppressWarnings("static-access")
	public void lancheGame()
	{
		//if p1 :
		//DialogueBox dialogue = new DialogueBox("Lancement du jeu","Attente d'un joueur","Retour Lobby");
		//Connexion au serveurGame
		//Changement de panel ici.
		//if p1 and p2:
		//frame.getContentPane().setVisible(false);
		//frame.getContentPane().remove(this);
		//Afficher l'attente d'un second joueur
		//dialogue.setVisible(true);
		//Affiche le panel du joueur
		//ServeurGame ServG = new ServeurGame();
		System.out.println("Création du clientGame");
		ClientGame cliG = new ClientGame();
		try {System.out.println("cligMain launch");
			cliG.main(null);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cliG.AddPlayerToServeur(1235);
	}
}
