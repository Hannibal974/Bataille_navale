package random.core;

import bataille_navale.Player;
import bataille_navale.ThreadServeur;

public class Match 
{
	private ThreadServeur ts1;
	private Player p1;
	private ThreadServeur ts2;
	private Player p2;
	
	public Match (ThreadServeur t1, Player play1, ThreadServeur t2, Player play2)
	{
		ts1 = t1;
		p1 = play1;
		ts2 = t2;
		p2 = play2;
	}

	public ThreadServeur getTs1() {
		return ts1;
	}

	public void setTs1(ThreadServeur ts1) {
		this.ts1 = ts1;
	}

	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public ThreadServeur getTs2() {
		return ts2;
	}

	public void setTs2(ThreadServeur ts2) {
		this.ts2 = ts2;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}
	
}
