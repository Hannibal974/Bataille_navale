package bataille_navale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import random.core.Match;
import bataille_navale.ui.MaFrame;
//import random.core.Match;

public class Client 
{
	private PrintWriter out;
	private BufferedReader in;

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
	
	public String AddPlayerToServeur (Player play)
	{
		try
		{
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
	
	public void CreateServeur (Player play)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "create");
			demande.put("username", play.getUsername());
			out.println(demande);
			JSONArray reponse = new JSONArray(in.readLine());
			if(reponse.get(0).equals("match cree"))
			{
				new ServeurGame(reponse.getInt(1));
				new ClientGame(reponse.getInt(1));
			}
		}
		catch(Exception e)
		{
			System.out.println("error create Match" + e.getMessage());
		}
	}
	
	public String JoinMatch (int index, Player play)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "join");
			demande.put("index", index);
			demande.put("username", play.getUsername());
			out.println(demande);
			if(in.readLine().equals("joinDone"))
				return "JoinMatch";
			else return "JoinFailed";
		}
		catch(Exception e)
		{
			
		}
		return "other";
	}
	
	public Integer[] GetPortFromServer () throws NullPointerException
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "getports");
			out.println(demande);
			JSONArray reponse = new JSONArray(in.readLine());
			Integer[] tblmatches = new Integer[reponse.length()];
			for(int i = 0; i<reponse.length(); i++)
			{
				tblmatches[i] = reponse.getInt(i);
			}
			return tblmatches;
		}
		catch (Exception e)
		{
 
		}
		return null;
	}
	
	public void Disconnect (Player play)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "destroy");
			//demande.put("Player", play);
			out.println(demande);
		}
		catch(Exception e)
		{
			System.out.println("error create Match" + e.getMessage());
		}
	}
	
	public static void main(String[] args) throws JSONException, IOException 
	{
		Client client  = new Client ();
		MaFrame frame = new MaFrame(client);
		frame.setVisible(true);
	}
}
