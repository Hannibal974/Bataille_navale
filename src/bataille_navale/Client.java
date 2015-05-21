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
			Socket socket=new Socket("localhost", 1234);
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
		System.out.println("Préparation de la connexion");
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "add");
			demande.put("param", play.getUsername());
			out.println(demande);
			System.out.println("Demande envoyée");
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
		Client client  = new Client ();
		MaFrame frame = new MaFrame(client);
		System.out.println("Frame créée");
		frame.setVisible(true);
	}
}
