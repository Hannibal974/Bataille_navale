package bataille_navale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bataille_navale.ui.MaFrame;
import random.core.Match;

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
	
	public String CreateMatch (Player play)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "create");
			demande.put("username", play.getUsername());
			out.println(demande);
			
			if(in.readLine().equals("match cree"))
				return "ok";
			else return "rate";
		}
		catch(Exception e)
		{
			System.out.println("error create Match" + e.getMessage());
		}
		return "other";
	}
	
	public String JoinMatch (int index)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "join");
			demande.put("index", index);
			out.println(demande);
			
		}
		catch(Exception e)
		{
			
		}
		return "other";
	}
	
	public String[] GetMatchFromServer () throws NullPointerException
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "getmatches");
			out.println(demande);
			JSONArray reponse = new JSONArray(in.readLine());
			String [] tblmatches = new String[reponse.length()];
			for(int i = 0; i<reponse.length(); i++)
			{
				tblmatches[i] = reponse.getString(i);
			}
			return tblmatches;
		}
		catch (Exception e)
		{
 
		}
		return null;
	}
	
	public static void main(String[] args) throws JSONException, IOException 
	{
		Client client  = new Client ();
		MaFrame frame = new MaFrame(client);
		frame.setVisible(true);
	}
}
