package bataille_navale;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import random.core.Match;

public class ServeurGame 
{
	ArrayList<Integer> portToUse = new ArrayList<Integer>();
	private int numberToFound;
	
	public ServeurGame ()
	{
		try
		{
			ServerSocket ss=new ServerSocket(1235);
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
			System.err.println("Serveur game : " + e.getMessage());
		}
	}

	public ArrayList<Integer> getPortToUse() {
		return portToUse;
	}

	public void setPortToUse(ArrayList<Integer> portToUse) {
		this.portToUse = portToUse;
	}

	public int getNumberToFound() {
		return numberToFound;
	}

	public void setNumberToFound(int numberToFound) {
		this.numberToFound = numberToFound;
	}
	
	public static void main(String[] args) {
		new ServeurGame();
	}
}
