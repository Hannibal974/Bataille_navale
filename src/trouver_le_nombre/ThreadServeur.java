package trouver_le_nombre;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;




//import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ThreadServeur implements Runnable
{
	private Socket socket;
	private Serveur srv;
	private ArrayList<Player> listePlayer= new ArrayList<Player>();
	private ArrayList<Integer> portInUse = new ArrayList<Integer>();
	public ThreadServeur (Socket ss, Serveur serv)
	
	{
		setListePlayer(new ArrayList<Player>());
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
					System.out.println("Reception de la demande");
					Player play = new Player(demande.get("param").toString());
					srv.AddPlayer(play);
					listePlayer.add(play);
					System.out.println(" Ajoutn d'un player. Envoi de la Réponse");
					out.println("ajoute");
				}
				else if(demande.get("commande").equals("create"))
				{
					System.out.println("Create request");
					
					ArrayList<Player> ListePlayer = new ArrayList<Player>();
					ListePlayer.addAll(listePlayer);
					System.out.println(ListePlayer);
					int port = srv.getPortToUse().get(listePlayer.size() + 1 );
					JSONArray reponse = new JSONArray();
					System.out.println("Game open in port :" + port);
					reponse.put(port);
					out.println(reponse);
				}
				
				else if(demande.get("commande").equals("getports"))
				{
					System.out.println("Get ports asked");
					ArrayList<Integer> listport = srv.getPortToUse();
					JSONArray tblports = new JSONArray();
					System.out.println("Player in : " + listePlayer);
					for (int port : listport) {
						for (int i=0; i< listePlayer.size();i++)
						{
							Player p = listePlayer.get(i);
						if ( port == p.getGamePort())
						{
							tblports.put(p.getGamePort());
						}
						}
					}
					tblports.put(1235);
					out.println(tblports);
					System.out.println("Matches Retunrs : " + tblports);
				}
				
				else if (demande.get("commande").equals("PlayerInGame")){
					System.out.println("Add player in game");
					ArrayList<Player> ListePlayer = new ArrayList<Player>();
					Player p = new Player("username");
					ListePlayer.addAll(listePlayer);
					System.out.println(ListePlayer);
					p.setUsername(demande.getString("Username"));
					p.setGamePort(demande.getInt("Port"));
					System.out.println("Player addes: " + p);
					out.println("player added");
				}
				
				else if(demande.get("commande").equals("join"))
				{
					System.out.println("2nd player request");
					Player p = new Player(demande.getString("Username"));
					p.setGamePort(demande.getInt("Port"));
					srv.SetSecondPlayer( p.getGamePort(), p);
					out.println("Player : "+ p.getUsername() + "joinThe game");
				}
				else if(demande.get("commande").equals("destroy"))
				{
					ArrayList<Integer> listport = srv.getPortToUse();
					listport.remove(Integer.parseInt(demande.get("port").toString()));
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
	public ArrayList<Player> getListePlayer() {
		return listePlayer;
	}
	public void setListePlayer(ArrayList<Player> listePlayer) {
		this.listePlayer = listePlayer;
	}
	public ArrayList<Integer> getPortInUse() {
		return portInUse;
	}
	public void setPortInUse(ArrayList<Integer> portInUse) {
		this.portInUse = portInUse;
	}
}
