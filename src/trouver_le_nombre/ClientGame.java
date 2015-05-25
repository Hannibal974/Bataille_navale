package trouver_le_nombre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JPanel;

import org.json.JSONException;
import org.json.JSONObject;

//import trouver_le_nombre.ui.MaFrame;
//import trouver_le_nombre.ui.PanelGame;

@SuppressWarnings("serial")
public class ClientGame extends JPanel implements ActionListener
{
	private PrintWriter out;
	private BufferedReader in;
	private int numberTries;
	private Socket socket;
	private int port;
	private static ServeurGame server;
	
	public ClientGame (int Port, String j, ServeurGame server) 
	{
		try
		{
			numberTries = 0;
			System.out.println("Party rejoint sur le port : ");
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ServeurGame.main();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Client : " + e.getMessage());
		}
	}
	
	public ClientGame(int port, String j){
		numberTries = 0;
		System.out.println("Party rejoint sur le port : ");
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Client : " + e.getMessage());
		}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public String AddPlayerToServeur (int Port) throws Exception
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "add");
			out.println(demande);
			if(in.readLine().equals("ajoute")){
				System.out.println("Ajout accepter par le TG");
				return "ok";
			}
			else return "rate";
			
		}
		catch(Exception e)
		{
			System.out.println("error adding Player" + e.getMessage());
		}
		finally{
			socket.close();	
		}
		return "other";
	}
	
	public int GetNumberPlayers ()
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "how many");
			out.println(demande);
			return Integer.parseInt(in.readLine());
		}
		catch(Exception e)
		{
			System.err.println("GetNumberPlayers : " + e.getMessage());
		}
		return 0;
	}
	
	public int getNumberToFound ()
	{
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "getnumbertofound");
			out.println(demande);
			return Integer.parseInt(in.readLine());
		}
		catch(Exception e)
		{
			System.err.println("GetNumberToFound : " + e.getMessage());
		}
		return 0;
	}
	
	public PrintWriter getOut() {
		return out;
	}
	public void setOut(PrintWriter out) {
		this.out = out;
	}
	public BufferedReader getIn() {
		return in;
	}
	public void setIn(BufferedReader in) {
		this.in = in;
	}
	public int getNumberTries() {
		return numberTries;
	}
	public void setNumberTries(int numberTries) {
		this.numberTries = numberTries;
	}
	
	public String getWinner() 
	{
		// TODO Auto-generated method stub
		try
		{
			JSONObject demande = new JSONObject();
			demande.put("commande", "end");
			return in.readLine();
		}
		catch(Exception e)
		{
			System.err.println("End : " + e.getMessage());
		}
		
		return null;
	}	
	
	public static void main(String[] args, int port, ServeurGame sg1) throws JSONException, IOException 
	{
		
		ClientGame client = new ClientGame(port, "create", server);
		if(client instanceof ClientGame)
			System.out.println("client cree");
		else System.out.println("failed");
		System.out.println("début création MaFrameGame");
		System.out.println(client);
		MaFrameGame frame = new MaFrameGame(client);
		System.out.println("fin create MaFrameGame");
		frame.setVisible(true);
		
		System.out.println("visibilite");
		System.out.println("Game is started");
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public ServeurGame getServer() {
		return server;
	}
	public void setServer(ServeurGame server) {
		ClientGame.server = server;
	}	
}
