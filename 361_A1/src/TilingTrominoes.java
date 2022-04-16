import java.awt.*;
import java.util.Scanner;

import javax.swing.*;
/*
 * COMP 361 Assignment 1
 * 
 * @author Wenyu Wang
 */
@SuppressWarnings("serial")
public class TilingTrominoes extends JFrame{
	static MyPanel mp;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TilingTrominoes tt = new TilingTrominoes();
		mp = new MyPanel();
		
		//ask for n and location of missing point
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()*100;
		if((n/100)%2!=0) {
			throw new Exception("must be a power of 2");
		}
		int x = sc.nextInt()*100;
		int y = n-(sc.nextInt()*100);
		if(x<0||y<0||x>n||y>n) {
			throw new Exception("x and y must within "+n/100);
		}
		Location mis = new Location(x,y);
		
		//set missiong point to draw in black
		mp.setMis(mis);
		Location center = new Location(n/2,n/2);
		
		
		Tile(n,mis,center);
		
		tt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tt.setSize(n+100,n+100);
		tt.add(mp);
		tt.setVisible(true);
		System.out.print("test");

	}
	
	/**
	 * main tiling process
	 *
	 * @param n : board size
	 * @param mis : missiog point location
	 * @param center : center point of current board
	 */
	public static void Tile(int n, Location mis, Location center) {
		String type = null;		
		if(n == 2 *100) {
			type = checkLoc(mis,center);
			Tromino t = new Tromino(center, type);
			mp.add(t);
			System.out.println("tile "+type+" at "+t.getLoc().toString());
			return;
		}
		type = checkLoc(mis,center);
		Tromino t = new Tromino(center, type);
		mp.add(t);
		System.out.println(type+" at "+t.getLoc().toString());
		
		switch(type) {
		case "LR":
			Tile(n/2,mis,new Location(center.x-n/4,center.y-n/4));
			Tile(n/2,center,new Location(center.x+n/4,center.y-n/4));
			Tile(n/2,new Location(center.x-100,center.y+100), new Location(center.x-n/4,center.y+n/4));
			Tile(n/2,new Location(center.x,center.y+100),new Location(center.x+n/4,center.y+n/4));
			break;
		case "LL":
			Tile(n/2,new Location(center.x-100,center.y),new Location(center.x-n/4,center.y-n/4));
			Tile(n/2,mis,new Location(center.x+n/4,center.y-n/4));
			Tile(n/2,new Location(center.x-100,center.y+100),new Location(center.x-n/4,center.y+n/4));
			Tile(n/2,new Location(center.x,center.y+100),new Location(center.x+n/4,center.y+n/4));
			break;
		case "UR":
			Tile(n/2,new Location(center.x-100,center.y),new Location(center.x-n/4,center.y-n/4));
			Tile(n/2,center,new Location(center.x+n/4,center.y-n/4));
			Tile(n/2,mis, new Location(center.x-n/4,center.y+n/4));
			Tile(n/2,new Location(center.x,center.y+100),new Location(center.x+n/4,center.y+n/4));
			break;
		case "UL":
			Tile(n/2,new Location(center.x-100,center.y),new Location(center.x-n/4,center.y-n/4));
			Tile(n/2,center,new Location(center.x+n/4,center.y-n/4));
			Tile(n/2,new Location(center.x-100,center.y+100),new Location(center.x-n/4,center.y+n/4));
			Tile(n/2,mis,new Location(center.x+n/4,center.y+n/4));
			break;
		}	
		
	}
	/**
	 * check relate position between center point and missig point
	 *
	 * @param mis
	 * @param center
	 */
	public static String checkLoc(Location mis, Location center) {
		if(mis.x < center.x && mis.y <=center.y) return "LR";
		if(mis.x >= center.x && mis.y <=center.y) return "LL";
		if(mis.x < center.x && mis.y > center.y) return "UR";
		if(mis.x >= center.x && mis.y > center.y) return "UL";
		return null;
	}

}
