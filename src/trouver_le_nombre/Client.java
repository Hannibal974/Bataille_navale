package trouver_le_nombre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


import java.util.ArrayList;


//import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import trouver_le_nombre.ui.MaFrame;

public class Client 
{
	private PrintWriter out;
	private BufferedReader in;
	private String Username;
	private int Port;
	private ClientGame CliG;

	public Client() 
	{
		try 
		{
			@SuppressWarnings("resource")
			Socket socket = new Socket("localhost", 1234);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} 
		catch (Exception e) 
		{
			System.err.println("Client : "+e.getMessage());
		}
	}
	
	public int getPort() {
		return Port;
	}

	public void setPort(int port) {
		Port = port;
	}

	public String AddPlayerToServeur (Player play)
	{
		try
		{
			System.out.println("Envoi de la demande");
			JSONObject demande = new JSONObject();
			demande.put("commande", "add");
			demande.put("param", play.getUsername());
			out.println(demande);
			
			if(in.readLine().equals("ajoute"))
				return "ok";
			else return "rate";
		}
		catch(Exception e)
		{
			System.out.println("error adding Player" + e.getMessage());
		}
		return "other";
	}
	
	public int CreateServeur (Player play)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "create");
			demande.put("username", play.getUsername());
			Username = play.getUsername();
			out.println(demande);
			JSONArray reponse = new JSONArray(in.readLine());
			System.out.println(reponse);
			return reponse.getInt(0);

		}
		catch(Exception e)
		{
			System.out.println("error create Match" + e.getMessage());
		}
		return 1235;
	}
	
	public String JoinServeur (Player play)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "join");
			demande.put("Username", play.getUsername());
			demande.put("Port", play.getGamePort());
			Username = play.getUsername();
			out.println(demande);
			if(in.readLine().equals("player added"))
				return "ok";
			else return "rate";
		}
		catch(Exception e)
		{
			
		}
		return "other";
	}
	
	public ArrayList<Integer> GetPortFromServer () throws NullPointerException
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "getports");
			out.println(demande);
			JSONArray reponse = new JSONArray(in.readLine());
			ArrayList<Integer> tblmatches = new ArrayList<Integer>();
			for(int i = 0; i<reponse.length(); i++)
			{
				tblmatches.add(reponse.getInt(i));
			}
			return tblmatches;
		}
		catch (Exception e)
		{
 
		}
		return null;
	}
	
	public void Disconnect (Client Cli)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "destroy");
			demande.put("port", Port);
			out.println(demande);
		}
		catch(Exception e)
		{
			System.out.println("error create Match" + e.getMessage());
		}
	}
	public void PlayerInGame (Player p)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "PlayerInGame");
			demande.put("Port", p.getGamePort());
			demande.put("Username", p.getUsername());
			out.println(demande);
		}
		catch(Exception e)
		{
			System.out.println("Player Not add to serveur list" + e.getMessage());
		}
	}


	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}
	
	public static void main(String[] args) throws JSONException, IOException 
	{
		Client client  = new Client ();
		MaFrame frame = new MaFrame(client);
		frame.setVisible(true);
	}

	public ClientGame getCliG() {
		return CliG;
	}

	public void setCli(ClientGame cliG) {
		CliG = cliG;
	}

}
