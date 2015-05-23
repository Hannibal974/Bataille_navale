package bataille_navale;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import random.core.Match;

public class ServeurGame 
{
	private int numberToFound;
	
	public ServeurGame (int port)
	{
		try
		{
			ServerSocket ss=new ServerSocket(port);
			System.out.println("Serveur game en ecoute...");
			while(true)
			{
				Socket socket=ss.accept(); 
				System.out.println("Un client est connecte !");
				new Thread(new ThreadServeurGame(socket, this)).start();
			}
		}
		catch(Exception e)
		{
			System.err.println("Serveur game : " + e.getStackTrace());
		}
	}
}
