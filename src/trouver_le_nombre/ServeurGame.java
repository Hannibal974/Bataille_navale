package trouver_le_nombre;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServeurGame
{
	private ArrayList<Integer> portToUse;
	private ArrayList<Integer> portInUse;
	private int numberToFound;
	private int numberPlayer = 0;
	private int end = 0;
	private int triesClient1 = 0;
	private int triesClient2 = 0;
	
	public ServeurGame (ClientGame cg1, int Port)
	{
		portInUse.add(Port);
		try
		{
			@SuppressWarnings("resource")
			ServerSocket ss=new ServerSocket(Port);
			System.out.println("Serveur game en ecoute...");
			numberToFound = (int)(Math.random()*1000) + 1;
			System.out.println("Le numbre est : " + numberToFound);
			cg1.setServer(this);
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

	public static void main(String[] args) {
		//new ServeurGame();
	}

	public ArrayList<Integer> getPortToUse() {
		return portToUse;
	}

	public void setPortToUse(ArrayList<Integer> portToUse) {
		this.portToUse = portToUse;
	}

	public ArrayList<Integer> getPortInUse() {
		return portInUse;
	}


	public void setPortInUse(ArrayList<Integer> portInUse) {
		this.portInUse = portInUse;
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

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getTriesClient1() {
		return triesClient1;
	}

	public void setTriesClient1(int triesClient1) {
		this.triesClient1 = triesClient1;
	}

	public int getTriesClient2() {
		return triesClient2;
	}

	public void setTriesClient2(int triesClient2) {
		this.triesClient2 = triesClient2;
	}
	public void RemovePort(int Port){
		portInUse.remove(Port);
	}

	public static void main() {
	}
}
