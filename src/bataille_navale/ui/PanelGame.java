package bataille_navale.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bataille_navale.Client;

public class PanelGame extends JPanel implements ActionListener
{
	private Client client;
	private JLabel labelnumber;
	private JTextField textnumber;
	private JButton buttontosend;
	
	public PanelGame(Client cli) 
	{
		client = cli;
		setLayout(new GridLayout(1,3));
		// TODO Auto-generated constructor stub
		labelnumber = new JLabel("Entrez un nombre");
		textnumber = new JTextField();
		buttontosend = new JButton("Envoyer");
		buttontosend.addActionListener(this);
		add(labelnumber);
		add(textnumber);
		add(buttontosend);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == buttontosend)
		{
			
		}
	}

}
