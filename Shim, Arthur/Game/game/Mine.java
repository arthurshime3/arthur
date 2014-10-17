package game;

import java.awt.Color;

/**
 * A hexagon shaped mine that is rendered over the game display.
 *
 */
public class Mine {
	private final int LENGTH = 100;
	private Hitbox h;
	private Color c;
	
	/**
	 * Creates a regular hexagon shaped mine with side length 100
	 * and the top left corner at x,y 
	 * @param x x coordinate of top left
	 * @param y y coordinate of top left
	 * @param p The PApplet
	 */
	public Mine(int x, int y, PApplet p){
		double sin = Math.sin(30), cos = Math.cos(30);
		
		int[] xPoints = {x, (int)(x + cos*LENGTH), (int)(x + 2*cos*LENGTH),
				(int)(x + 2*cos*LENGTH), (int)(x + cos*LENGTH), x};
		int[] yPoints = {y, (int)(y + sin*LENGTH), y,
				(int)(y - 2*sin*LENGTH), (int)(y - 3*sin*LENGTH), (int)(y - 2*sin*LENGTH)};
		h = new Hitbox(xPoints, yPoints, 6);
		c = Color.BLUE;
	}
	
	/**
	 * Changes the color of the mine to the specified color
	 * @param c The color
	 */
	public void changeColor(Color c){
		this.c = c;
	}
	
	/**
	 * Draws the Mine
	 */
	public void draw(){
		
	}
	
	/**
	 * Returns the hitbox of this mine
	 * @return hitbox of this mine
	 */
	public Hitbox getHitbox(){
		return h;
	}
}
