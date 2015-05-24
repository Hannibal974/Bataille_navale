package bataille_navale;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur
{
	private ArrayList<Player> listePlayer;
	private Integer[] numPorts;
	private Integer port;
	
	public Serveur() 
	{
		try 
		{
			listePlayer = new ArrayList<Player>();
			numPorts = new Integer[255];
			port = 1;
			// écoute du serveur
			@SuppressWarnings("resource")
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("Serveur en écoute...");
			while(true) {
				// un client se connecte
				Socket socket=ss.accept();
				System.out.println("Un client est connecté !");
				new Thread(new ThreadServeur(socket, this)).start();
			}

		} catch (Exception e) {
			System.err.println("Serveur : "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		new Serveur();
	}
	
	public void AddPlayer (Player play)
	{
		listePlayer.add(play);
	}
	
	public void AddServeur (Integer p)
	{
		numPorts[port] = p;
		port++;
	}
	public ArrayList<Player> getListePlayer() {
		return listePlayer;
	}
	public void setListePlayer(ArrayList<Player> listePlayer) {
		this.listePlayer = listePlayer;
	}
	public Integer[] getNumPorts() {
		return numPorts;
	}
	public void setNumPorts(Integer[] numPorts) {
		this.numPorts = numPorts;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
}
