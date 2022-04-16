/*
 * COMP 361 Assignment 1
 * 
 * @author Wenyu Wang
 */
public class Tromino {
	//x-points and y-points as polygon
	private int[] xPoints = new int[6];
	private int[] yPoints = new int[6];
	enum t {UL,UR,LL,LR};
	private String type;
	private Location loc;
	
	public Tromino(Location loc, String type) {
		this.loc = loc;
		this.type = type;
	}
	
	public int[] xPoints() {
		switch(type){
		case "UL":
			xPoints[0] = loc.x - 100;
			xPoints[1] = loc.x + 100;
			xPoints[2] = loc.x + 100;
			xPoints[3] = loc.x ;
			xPoints[4] = loc.x ;
			xPoints[5] = loc.x - 100;
			break;
		case "UR":
			xPoints[0] = loc.x - 100;
			xPoints[1] = loc.x + 100;
			xPoints[2] = loc.x + 100;
			xPoints[3] = loc.x ;
			xPoints[4] = loc.x ;
			xPoints[5] = loc.x - 100;
			break;
		case "LL":
			xPoints[0] = loc.x - 100;
			xPoints[1] = loc.x ;
			xPoints[2] = loc.x ;
			xPoints[3] = loc.x + 100;
			xPoints[4] = loc.x + 100;
			xPoints[5] = loc.x - 100;
			break;
		case "LR":
			xPoints[0] = loc.x ;
			xPoints[1] = loc.x + 100;
			xPoints[2] = loc.x + 100;
			xPoints[3] = loc.x - 100;
			xPoints[4] = loc.x - 100;
			xPoints[5] = loc.x;
			break;
		}
		
		
		return xPoints;
	}

	public int[] yPoints() {
		switch(type) {
		case "UL":
			yPoints[0] = loc.y - 100;
			yPoints[1] = loc.y - 100;
			yPoints[2] = loc.y ;
			yPoints[3] = loc.y ;
			yPoints[4] = loc.y + 100;
			yPoints[5] = loc.y + 100;
			break;
		case "UR":
			yPoints[0] = loc.y - 100;
			yPoints[1] = loc.y - 100;
			yPoints[2] = loc.y + 100;
			yPoints[3] = loc.y + 100;
			yPoints[4] = loc.y ;
			yPoints[5] = loc.y ;
			break;
		case "LL":
			yPoints[0] = loc.y - 100;
			yPoints[1] = loc.y - 100;
			yPoints[2] = loc.y ;
			yPoints[3] = loc.y ;
			yPoints[4] = loc.y + 100;
			yPoints[5] = loc.y + 100;
			break;
		case "LR":
			yPoints[0] = loc.y - 100;
			yPoints[1] = loc.y - 100;
			yPoints[2] = loc.y + 100;
			yPoints[3] = loc.y + 100;
			yPoints[4] = loc.y ;
			yPoints[5] = loc.y ;
			break;
		}
		return yPoints;
	}
	public int nPoints() {
		return 6;
	}
	public String getType() {
		return type;
	}
	public Location getLoc() {
		return loc;
	}
}
