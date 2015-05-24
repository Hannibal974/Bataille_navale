package bataille_navale;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//import java.util.ArrayList;
import org.json.JSONArray;
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
				JSONObject demande=new JSONObject(in.readLine());
				
				if(demande.get("commande").equals("add"))
				{
					Player play = new Player(demande.get("param").toString());
					srv.AddPlayer(play);
					out.println("ajoute");
				}
				else if(demande.get("commande").equals("create"))
				{
					System.out.println("Create request");
					int port = srv.getPort();
					srv.AddServeur(port);
					JSONArray reponse = new JSONArray();
					reponse.put("serveur cree");
					reponse.put(port);
					out.println(reponse);
				}
				else if(demande.get("commande").equals("getports"))
				{
					System.out.println("Get ports asked");
					Integer[] listport = srv.getNumPorts();
					JSONArray tblports = new JSONArray();
					for(Integer port : listport)
					{
							tblports.put(port);
					}
					out.println(tblports);
					System.out.println("Matches Retunrs");
				}
				/*else if(demande.get("commande").equals("join"))
				{
					System.out.println("2nd player request");
					srv.SetSecondPlayer(Integer.parseInt(demande.get("index").toString()), this, new Player(demande.get("username").toString()));
					out.println("joinDone");
				}*/
				else if(demande.get("commande").equals("destroy"))
				{
					//Ajouter ici la mise à jour des listes du serveur (retirer le client)
					//Player play = (Player) demande.get("Player");
					//srv.getListePlayer().remove(play);
					//srv.getMatches().contains(play);
					socket.close();
					System.out.println("player desconnected");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
