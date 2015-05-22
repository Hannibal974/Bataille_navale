package bataille_navale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import bataille_navale.ui.MaFrame;

public class Client 
{
	private PrintWriter out;
	private BufferedReader in;

	public Client() 
	{
		try 
		{
			@SuppressWarnings("resource")
			Socket socket=new Socket("localhost", 1234);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} 
		catch (Exception e) 
		{
			System.err.println("Client : "+e.getMessage());;
		}
	}
	
	public String AddPlayerToServeur (Player play)
	{
		try
		{
			System.out.println("creation de la demande");
			JSONObject demande = new JSONObject();
			System.out.println("ajout de la commande dans la demande");
			demande.put("commande", "add");
			System.out.println("ajout du nom de l'utilisateur");
			demande.put("param", play.getUsername());
			System.out.println("envoie de la demande");
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
	
	public void close() throws IOException {
        if ( out!=null ) {
             out.close();
        }
        if ( in!=null ) {
             in.close();}
   }
	
	public static void main(String[] args) throws JSONException, IOException 
	{
		System.out.println("creation du client");
		Client client  = new Client ();
		System.out.println("creation de la frame");
		MaFrame frame = new MaFrame(client);
		System.out.println("Affichage à l'utilisateur");
		frame.setVisible(true);
	}
}
