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
	private MaFrameGame frame;

	public ClientGame (int port) 
	{
		try
		{
			System.out.println("Party rejoint sur le port : " + port);
			Socket socket = new Socket("localhost", port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Préparation de la frame");
		}
		catch(Exception e)
		{
			System.err.println("Client : " + e.getMessage());
		}
		
		frame = new MaFrameGame();
		System.out.println("Game is started");
		//Lancement du panel
		frame.getContentPane().add(new PanelGame(this));
		frame.getContentPane().setVisible(true);
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
}
