package trouver_le_nombre;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur
{
	
	private ArrayList<Integer> portToUse = new ArrayList<Integer>();
	private Integer[] numPorts;
	private Integer port = 1234;
	ArrayList<Player> listePlayer = new ArrayList<Player>();
	public Serveur() 
	{
		@SuppressWarnings("unused")
		ArrayList<Integer> portToUse = new ArrayList<Integer>();
		
		System.out.println("Lancement de la creation des ports");
		generatePort();
		try 
		{
			// ecoute du serveur
			@SuppressWarnings("resource")
			ServerSocket ss=new ServerSocket(port);
			System.out.println("Serveur en ecoute...");
			while(true) {
				// un client se connecte
				Socket socket=ss.accept();
				System.out.println("Un client est connecte !");
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
			System.out.println("Added the first player to Server");
			listePlayer.add(play);
			System.out.println(listePlayer);
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
	public ArrayList<Integer> getPortToUse() {
		return portToUse;
	}
	public void setPortToUse(ArrayList<Integer> portToUse) {
		this.portToUse = portToUse;
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
	
	public void generatePort(){
		ArrayList<Integer> PortToUse = new ArrayList<Integer>();
		int temp = 1235;
		System.out.println("Génération des Ports");
		for (int i = 0 ; i <25; i++){
			PortToUse.add(i, temp);
			temp = temp + 1;
		}
		portToUse.addAll(PortToUse);
		System.out.println("Port Définit!" + portToUse);
	}
	public void SetSecondPlayer(int port, Player player) {
		listePlayer.add(player);
		portToUse.add(port);
	}
}
