package bataille_navale;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import core.Match;

public class Serveur 
{
	private ArrayList<Player> listePlayer;
	private ArrayList<Match> matches;
	
	public Serveur() 
	{
		try 
		{
			listePlayer = new ArrayList<Player>();
			matches = new ArrayList<Match>();
			// écoute du serveur
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("Serveur en écoute...");
			while(true) {
				// un client se connecte
				Socket socket=ss.accept();
				System.out.println("Un client est connecté !");
				new Thread(new ThreadServeur(socket, this)).start();
			}

		} catch (Exception e) {
			System.err.println("Serveur : "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		new Serveur();
	}
	
	public void AddPlayer (Player play)
	{
		listePlayer.add(play);
	}
	
	public void AddMatches (Match match)
	{
		matches.add(match);
	}

}
