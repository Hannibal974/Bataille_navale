package bataille_navale;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONObject;

import random.core.Match;

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
			// flux d'écriture et de lecture
			PrintWriter out=new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// boucle infinie
			while(true)
			{
				JSONObject demande=new JSONObject(in.readLine());
				
				if(demande.get("commande").equals("add"))
				{
					Player play = new Player(demande.get("param").toString());
					srv.AddPlayer(play);
					out.println("ajoute");
				}
				else if(demande.get("commande").equals("create"))
				{
					srv.AddMatches(new Match(this, new Player(demande.get("username").toString()), null, null));
					out.println("match cree");
				}
				else if(demande.get("commande").equals("join"))
				{
					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
