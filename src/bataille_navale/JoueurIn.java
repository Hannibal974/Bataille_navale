package bataille_navale;

import java.util.ArrayList;
import java.util.Collection;
import bataille_navale.Player;

import javax.swing.JComboBox;

public class JoueurIn extends ArrayList<Player> {
	
	public JoueurIn(){
		//ArrayList<Player> jin = new ArrayList<Player>();
	}

	public JoueurIn(Collection<? extends Player> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JoueurIn(int arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	//M�thodes pour transformer la ArrayListPlayer en 
	public JComboBox<String> PlayeurToCombo( ArrayList<Player> AP){
		JComboBox<String> PlayersIn = new JComboBox<String>();
		
		 for (Player p : AP) {
			PlayersIn.addItem(p.getUsername());
		    }
		 
		 return PlayersIn;
	}
}


