package bataille_navale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONException;

import bataille_navale.ui.MaFrame;
import bataille_navale.ui.PanelGame;

public class ClientGame 
{
	private PrintWriter out;
	private BufferedReader in;
	private MaFrameGame frame;

	public ClientGame (int port) 
	{
		try
		{
			Socket socket = new Socket("localhost", port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			frame = new MaFrameGame();
			frame.getContentPane().add(new PanelGame(this));
			frame.getContentPane().setVisible(true);
		}
		catch(Exception e)
		{
			System.err.println("Client : " + e.getMessage());
		}
	}

}
