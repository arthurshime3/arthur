package game;

import java.awt.Polygon;
import java.awt.geom.Area;

/**
 * Hitbox is an invisible polygon used to 
 * determine if some object intersects another object with a hitbox.
 *
 */
public class Hitbox {
	private Polygon p;
	
	
	/**
	 * Constructs a hit box given an array of x and y points
	 * provided that both arrays have the same size
	 * @param xPoints an array of x points
	 * @param yPoints an array of y points
	 * @param points the number of points in the polygon
	 */
	public Hitbox(int[] xPoints, int[] yPoints, int points){
		p = new Polygon(xPoints, yPoints, points);
	}
	
	/**
	 * Returns a copy of the x coordinates
	 * @return  a copy of the x coordinates
	 */
	public int[] getXPoints(){
		return p.xpoints;
	}
	
	/**
	 * Returns a copy of the y coordinates
	 * @return  a copy of the y coordinates
	 */
	public int[] getYPoints(){
		return p.ypoints;
	}
	
	
	/**
	 * Moves the hit box in the x and y directions by the specified
	 * amounts
	 * @param xDirection amount to be moved in the x direction
	 * @param yDirection amount to be moved in the y direction
	 */
	public void move(int xDirection, int yDirection){
		for (int i = 0; i < p.npoints; i++){
			p.xpoints[i] += xDirection;
			p.ypoints[i] += yDirection;
		}
	}
	
	/**
	 * Determines if this hitbox intersects another hitbox
	 * @param other The other hitbox
	 * @return True if the hitboxes intersect, false otherwise
	 */
	public boolean intersects(Hitbox other){
		//how to implement
		//http://stackoverflow.com/questions/20952960/how-to-check-if-a-polygon-intersects-a-polygon-java
		Area a = new Area(p);
		Area b = new Area(other.p);
		a.intersect(b);
		return !a.isEmpty(); //if empty, they do not intersect
	}
}
