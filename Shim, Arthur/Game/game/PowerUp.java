package game;

/**
 * contains the properties necessary of a power-up which include:
 * 		hit boxes
 * 		draw design
 * 
 * @author 165094
 *
 */
public abstract class PowerUp {
	private Hitbox h;
	private final int LENGTH = 50;
	
	/**
	 * Creates a power-up with a hitbox at x, y of size 50
	 * @param x x-coordinate of power-up
	 * @param y y-coordinate of power-up
	 * @param p The PApplet
	 */
	public PowerUp(int x, int y, PApplet p){
		int[] xPoints = {x, x + LENGTH, x + LENGTH, x};
		int[] yPoints = {y, y, y + LENGTH, y + LENGTH};
		h = new Hitbox(xPoints, yPoints, 4);
	}
	/**
	 * Returns the hitbox of the power-up
	 * @return hitbox of the power-up
	 */
	public Hitbox getHitbox(){
		return h;
	}
	
	/**
	 * Draws the power-up
	 */
	public abstract void draw();
	
}
