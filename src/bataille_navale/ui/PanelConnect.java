package bataille_navale.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bataille_navale.Client;
import bataille_navale.Player;

@SuppressWarnings("serial")
public class PanelConnect extends JPanel implements ActionListener
{
	private JLabel labelname;
	private JButton buttonconnect;
	private JTextField textname;
	private Client client;
	
	public PanelConnect (Client cli)
	{
		client  = cli;
		setLayout(new GridLayout(1, 3));
		labelname = new JLabel("Entrez votre username");
		buttonconnect = new JButton("Connect");
		textname = new JTextField();
		buttonconnect.addActionListener(this);
		add(labelname);
		add(textname);
		add(buttonconnect);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == buttonconnect)
		{
			System.out.println("Creation du Player");
			Player play = new Player(textname.getText());
			System.out.println("Player prêt à jouer");
			@SuppressWarnings("unused")
			String validation = client.AddPlayerToServeur(play);
			System.out.println("Lancement du client!");
		}
	}
}
