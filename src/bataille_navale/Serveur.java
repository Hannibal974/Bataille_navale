package bataille_navale;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import core.Match;
import bataille_navale.Player;

public class Serveur 
{
	private ArrayList<Player> listePlayer;
	private ArrayList<Match> matches;
	
	public Serveur() 
	{
		try 
		{
			System.out.println("creation des listes");
			listePlayer = new ArrayList<Player>();
			matches = new ArrayList<Match>();
			// ecoute du serveur
			
			System.out.println("creation du socket");
			@SuppressWarnings("resource")
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("Serveur en ecoute...");
			while(true) {
				// un client se connecte
				Socket socket=ss.accept();
				System.out.println("Un client est connecte !");
				new Thread(new ThreadServeur(socket, this)).start();
				System.out.println("Thread cree...");
			}

		} catch (Exception e) {
			System.err.println("Serveur : "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		System.out.println("creation serveur");
		new Serveur();
	}
	
	public void AddPlayer (Player play)
	{
		System.out.println("Ajout d'un joueur :" + play.getUsername());
		listePlayer.add(play);
	}
	
	public void AddMatches (Match match)
	{
		System.out.println("Enregistrement d'une partie avec " + (match.getP1()).getUsername()+ "et" + (match.getP2()).getUsername());
		matches.add(match);
	}

}
