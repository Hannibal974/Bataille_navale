package bataille_navale.ui;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

import javax.swing.JDialog;
import bataille_navale.Client;

@SuppressWarnings("serial")
public class DialogueBox extends JDialog {
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jd_gameEnd;
    private javax.swing.JLabel ld_resultgame;
    private javax.swing.JLabel ld_Texteafficher;
    private javax.swing.JButton b_retourLobby;
	@SuppressWarnings("unused")
	private Client client;
    // End of variables declaration//GEN-END:variables
	
	
	public DialogueBox(String Titre, String Texte, String Bouton){
	
		if (Titre != "" && Texte != "" && Bouton !=""){
		    ld_resultgame.setText(Titre);
		    ld_Texteafficher.setText(Texte);
		    b_retourLobby.setText(Bouton);	
		}

	    else{
		    ld_resultgame.setText("Attente du jeu");
		    ld_Texteafficher.setText("");
		    b_retourLobby.setText("Retour au Lobby");	
	    }
	    DialogueBoxInit();
	    //jd_gameEnd.setVisible(true);
	}
	
	public void DialogueBoxInit() {
		//Set le JDialogue.
        javax.swing.GroupLayout jd_gameEndLayout = new javax.swing.GroupLayout(jd_gameEnd.getContentPane());
        jd_gameEnd.getContentPane().setLayout(jd_gameEndLayout);
        jd_gameEndLayout.setHorizontalGroup(
            jd_gameEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_gameEndLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jd_gameEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ld_Texteafficher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jd_gameEndLayout.createSequentialGroup()
                        .addComponent(ld_resultgame)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(b_retourLobby, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        jd_gameEndLayout.setVerticalGroup(
            jd_gameEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jd_gameEndLayout.createSequentialGroup()
                .addComponent(ld_resultgame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ld_Texteafficher, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_retourLobby)
                .addContainerGap())
        );
	}

	public DialogueBox(Frame arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Dialog arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Window arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Frame arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Frame arg0, String arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Dialog arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Dialog arg0, String arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Window arg0, ModalityType arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Window arg0, String arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Frame arg0, String arg1, boolean arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Dialog arg0, String arg1, boolean arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Window owner, String title, ModalityType modalityType) {
		super(owner, title, modalityType);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Frame owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Dialog owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
	}

	public DialogueBox(Window owner, String title, ModalityType modalityType,
			GraphicsConfiguration gc) {
		super(owner, title, modalityType, gc);
		// TODO Auto-generated constructor stub
	}

}
