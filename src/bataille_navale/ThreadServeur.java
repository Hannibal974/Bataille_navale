package bataille_navale;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import bataille_navale.Player;

import org.json.JSONObject;

public class ThreadServeur implements Runnable
{
	private Socket socket;
	private Serveur srv;
	
	public ThreadServeur (Socket ss, Serveur serv)
	{
		socket = ss;
		srv = serv;
	}
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		try 
		{
			// flux d'Ã©criture et de lecture
			PrintWriter out=new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// boucle infinie
			while(true)
			{
				System.out.println("Récupération de la demande");
				JSONObject demande=new JSONObject(in.readLine());
				
				if(demande.get("commande").equals("add"))
				{
					System.out.println("enregistrement du nom du joueur");
					Player play = new Player(demande.get("param").toString());
					System.out.println("Ajout du client au serveur :" + play.getUsername());
					srv.AddPlayer(play);
					out.println("ajoute");
					System.out.println("envoie de la réponse");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
