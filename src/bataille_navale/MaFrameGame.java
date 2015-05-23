package bataille_navale;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MaFrameGame extends JFrame
{
	private JLabel label;
	
	public MaFrameGame ()
	{
		
		setLayout(new GridLayout(1, 1));
		label = new JLabel("change");
		add(label);
		setTitle("serveur de game");
		setSize(150, 200);
		setVisible(true);
	}
}
