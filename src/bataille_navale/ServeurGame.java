package bataille_navale;

import java.awt.font.NumericShaper;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServeurGame 
{
	ArrayList<Integer> portToUse = new ArrayList<Integer>();
	private int numberToFound;
	private int numberPlayer = 0;
	
	public ServeurGame ()
	{
		try
		{
			@SuppressWarnings("resource")
			ServerSocket ss=new ServerSocket(1235);
			System.out.println("Serveur game en ecoute...");
			numberToFound = (int)(Math.random()*1000) + 1;
			System.out.println(numberToFound);
			while(true)
			{
				Socket socket=ss.accept(); 
				System.out.println("Un client est connecte !");
				new Thread(new ThreadServeurGame(socket, this, numberToFound)).start();
				numberPlayer++;
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
	
	public int getNumberPlayer() {
		return numberPlayer;
	}

	public void setNumberPlayer(int numberPlayer) {
		this.numberPlayer = numberPlayer;
	}

	public static void main(String[] args) {
		new ServeurGame();
	}
}
