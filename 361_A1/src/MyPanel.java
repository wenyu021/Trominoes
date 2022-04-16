import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
/*
 * COMP 361 Assignment 1
 * 
 * @author Wenyu Wang
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel{
	List<Tromino> trominoesToDraw = new ArrayList<Tromino>();
	Location mis;
	Color[] c = {
			Color.red,Color.yellow,Color.green,Color.blue,Color.pink,Color.cyan,
			Color.red,Color.yellow,Color.green,Color.blue,Color.pink,Color.cyan,
			Color.red,Color.yellow,Color.green,Color.blue,Color.pink,Color.cyan,
			Color.red,Color.yellow,Color.green,Color.blue,Color.pink,Color.cyan,
			Color.red,Color.yellow,Color.green,Color.blue,Color.pink,Color.cyan,
			};
	
	
	public void add(Tromino t) {
		trominoesToDraw.add(t);
	}
	
	public void setMis(Location mis) {
		this.mis = mis;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(mis.x, mis.y-100, 100, 100);
		for(int i=0; i<trominoesToDraw.size(); i++) {
			g.setColor(c[i]);
			g.fillPolygon(trominoesToDraw.get(i).xPoints(), trominoesToDraw.get(i).yPoints(), trominoesToDraw.get(i).nPoints());
		}		
	}
	


}
