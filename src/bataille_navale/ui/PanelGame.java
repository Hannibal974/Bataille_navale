package bataille_navale.ui;
/**
 * @author Jennifer & Romain
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import bataille_navale.ClientGame;

@SuppressWarnings("serial")
public class PanelGame extends JPanel implements ActionListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton b_send;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea jta_historique;
    private javax.swing.JLabel l_Trouverlenombre;
    private javax.swing.JLabel l_historique;
    private javax.swing.JTextField tf_nombre;
	private ClientGame client;
	private int nomberToFound;
    // End of variables declaration//GEN-END:variables
	
	public PanelGame(ClientGame cli) 
	{
		client = cli;
		System.out.println("clientFrame"+client);
		initComponents();
	}
	
	private void initComponents() {
        jToggleButton1 = new javax.swing.JToggleButton();
        l_Trouverlenombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_historique = new javax.swing.JTextArea();
        l_historique = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        b_send = new javax.swing.JToggleButton();
        b_send.addActionListener(this);

        jToggleButton1.setText("jToggleButton1");

        l_Trouverlenombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        l_Trouverlenombre.setText("Trouver le nombre");
        jta_historique.setColumns(20);
        jta_historique.setRows(5);
        jScrollPane1.setViewportView(jta_historique);

        l_historique.setText("Historique:");
        tf_nombre.setText("Nombre ici");
        b_send.setText("Envoyer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(b_send, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(l_historique))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l_Trouverlenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_Trouverlenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l_historique)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == b_send)
		{
			if (tf_nombre.getText() != "") {
				//TODO Récupère le nombre dans Matches
						//nomberToFound = match.getNumbertofound();
				//TODO Récupère le nombre envoyer par le client
				int n = Integer.parseInt(tf_nombre.getText());
				//TODO je vérifie s'il est plus grand plus petit ou égale
				jta_historique.append("Vous avez envoyé:" + n + ".\n");
				if (n> nomberToFound){
					jta_historique.append("Plus petit.\n");
				}
				else if (n< nomberToFound){
					jta_historique.append("Plus grand.\n");
				}
				else if (n== nomberToFound){
					//TODO affiche le résultat au joueur.
					jta_historique.append("Jeu terminé.\n");
				}
			}
			//TODO Affiche la fin du jeu si l'un des deux jouer à trouver.
		}
	}
}
