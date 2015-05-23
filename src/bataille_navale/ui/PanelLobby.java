package bataille_navale.ui;
/**
*
* @author Jennifer & Romain
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

//import random.core.Match;
import bataille_navale.Client;
import bataille_navale.Player;

public class PanelLobby extends JPanel implements ActionListener
{
	 // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_connect;
    private javax.swing.JButton b_create;
    private javax.swing.JButton b_deconnect;
	private javax.swing.JComboBox<String> PlayersIn;
    private javax.swing.JLabel l_EnterName;
    private javax.swing.JLabel l_JoinServ;
    private javax.swing.JLabel l_createParty1;
	private static final long serialVersionUID = -6003067736193144131L;
	private Client client;
	private Player p;
	private MaFrame frame;
    // End of variables declaration//GEN-END:variables
	
	public PanelLobby (Client cli, Player play, String[] listMatchToJoin, MaFrame framish)
	{
		client = cli;
		p = play;
		frame = framish;
		initComponents();
		
		for(int i = 0; i < listMatchToJoin.length; i++)
		{
			//il faut concaténer la ligne i et i+1 pour avoir le thread et le nom du joueur sur la même ligne
			PlayersIn.addItem("Playeur: "+listMatchToJoin[i]+"| Match: "+listMatchToJoin[i+1]);
			i++;//Il faut avancer de 2 lignes du coup 
		}
		setVisible(true);
	}

	 private void initComponents() {

	        l_JoinServ = new javax.swing.JLabel();
	        l_EnterName = new javax.swing.JLabel();
	        b_connect = new javax.swing.JButton();
	        b_connect.addActionListener(this);
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

	        b_connect.setText("Creer une partie");

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
	                                .addComponent(b_create, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addContainerGap()
	                                .addComponent(l_createParty1)))
	                        .addGap(0, 4, Short.MAX_VALUE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(b_connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
	                    .addComponent(b_create, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(33, 33, 33)
	                .addComponent(l_createParty1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(b_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
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
			String validation = client.CreateMatch(p);
			System.out.println(validation);
		}
		else if (e.getSource() == b_connect)
		{
			String validation = client.JoinMatch(PlayersIn.getSelectedIndex(), p);
			System.out.println(validation);
		}
		
		frame.getContentPane().setVisible(false);
		frame.getContentPane().remove(this);
		//Lancement du panel
		frame.getContentPane().add(new PanelGame(client));
		frame.getContentPane().setVisible(true);
	}
	
	
}
