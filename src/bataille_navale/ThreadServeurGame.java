package bataille_navale;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONObject;

public class ThreadServeurGame implements Runnable
{
	private Socket socket;
	@SuppressWarnings("unused")
	private ServeurGame srv;
	
	public ThreadServeurGame (Socket ss, ServeurGame serv)
	{
		socket = ss;
		srv = serv;
	}

	@Override
	public void run() 
	{
		try
		{
			PrintWriter out=new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// boucle infinie
			while(true)
			{
				System.out.println("TG: Attente de la demande");
				JSONObject demande=new JSONObject(in.readLine());
				
				if(demande.get("commande").equals("add"))
				{
					System.out.println("R�ponse � la demande add");
					out.println("ajoute");
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Thread Game : " + e.getStackTrace());
		}
		// TODO Auto-generated method stub
	}
}
