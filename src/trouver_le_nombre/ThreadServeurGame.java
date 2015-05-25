package trouver_le_nombre;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONObject;

public class ThreadServeurGame implements Runnable
{
	private Socket socket;
	private ServeurGame srv;
	private int numberToFound;
	
	public ThreadServeurGame (Socket ss, ServeurGame serv, int num)
	{
		socket = ss;
		srv = serv;
		numberToFound = num;
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
			{JSONObject demande=new JSONObject(in.readLine());
			
			if(demande.get("commande").equals("add"))
			{
				srv.setNumberPlayer(srv.getNumberPlayer() + 1);
			}
			else if(demande.get("commande").equals("how many"))
			{
				out.println(srv.getNumberPlayer());
			}
			else if (demande.get("commande").equals("getnumbertofound"))
			{
				out.println(numberToFound);
			}
			else if (demande.get("commande").equals("finish"))
			{
				srv.setEnd(srv.getEnd() + 1);
				if(srv.getTriesClient1() == 0)
					srv.setTriesClient1(Integer.parseInt(demande.get("tries").toString()));
				else srv.setTriesClient2(Integer.parseInt(demande.get("tries").toString()));
				out.println(srv.getEnd());
			}
			else if (demande.get("commande").equals("ending"))
			{
				out.println(srv.getEnd());
			}
			else if (demande.get("commande").equals("winner"))
			{
				if(demande.get("pos").equals(1))
				{
					if(srv.getTriesClient1() < srv.getTriesClient2())
						out.println("You Win !!!");
					else if (srv.getTriesClient1() == srv.getTriesClient2())
					{
						out.println("Egality !!!");
					}
					else out.println("You Loose !!!");
				}
				else 
				{
					if(srv.getTriesClient2() < srv.getTriesClient1())
						out.println("You Win !!!");
					else if (srv.getTriesClient1() == srv.getTriesClient2())
					{
						out.println("Egality !!!");
					}
					else out.println("You Loose !!!");
				}
			}
		}
	}
		catch(Exception e)
		{
			System.err.println("Thread Game : " + e.getMessage());
		}
	}
}
