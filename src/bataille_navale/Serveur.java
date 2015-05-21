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
			// Ã©coute du serveur
			@SuppressWarnings("resource")
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("Serveur en ecoute...");
			while(true) {
				// un client se connecte
				Socket socket=ss.accept();
				System.out.println("Un client est connecte!");
				new Thread(new ThreadServeur(socket, this)).start();
				System.out.println("Thread ouvert");
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
		System.out.println("Joueur in");
		listePlayer.add(play);
		System.out.println("joueur ajouté à la liste");
	}
	
	public void AddMatches (Match match)
	{
		matches.add(match);
		System.out.println("match créé");
	}

}
