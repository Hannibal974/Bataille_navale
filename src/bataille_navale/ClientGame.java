package bataille_navale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import bataille_navale.ui.MaFrame;
import bataille_navale.ui.PanelGame;

public class ClientGame 
{
	private PrintWriter out;
	private BufferedReader in;

	public ClientGame () 
	{
		try
		{
			System.out.println("Party rejoint sur le port : ");
			Socket socket = new Socket("localhost", 1235);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Pr�paration de la frame");
		}
		catch(Exception e)
		{
			System.err.println("Client : " + e.getMessage());
		}
	}
	public String AddPlayerToServeur (int Port)
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "add");
			demande.put("param", Port);
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
	
	public static void main(String[] args) throws JSONException, IOException 
	{
		ClientGame client = new ClientGame();
		if(client instanceof ClientGame)
			System.out.println("client cree");
		else System.out.println("failed");
		System.out.println("d�but cr�ation MaFrameGame");
		System.out.println(client);
		MaFrameGame frame = new MaFrameGame(client);
		System.out.println("fin create MaFrameGame");
		frame.setVisible(true);
		System.out.println("visibilite");
		System.out.println("Game is started");
	}
}
