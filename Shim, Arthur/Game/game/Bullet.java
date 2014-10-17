package game;

/**
 * Represents a bullet on the screen.
 * It has a hitbox that moves with the bullet.
 * 
 * @author 165094
 *
 */
public class Bullet {
	private final int STEPS = 20;
	private double angle;
	private Hitbox h;	
	
	/**
	 * Creates a new Bullet with the given x, y coordinate and angle of movement
	 * @param x x-coordinate 
	 * @param y y-coordinate
	 * @param a angle
	 * @param p The PApplet
	 */
	public Bullet(int x, int y, int a, PApplet p){
		int[] xPoints = {x, x + 10, x + 10, x};
		int[] yPoints = {y, y, y + 10, y + 10};
		h = new Hitbox(xPoints, yPoints, 4);
		angle = a;
	}
	
	/**
	 * Draws the bullet on the screen
	 */
	public void draw(){
		
	}
	
	/**
	 * Changes the bullets location by 20 pixels in the direction it is facing
	 */
	public void move(){
		h.move((int)(Math.cos(angle)*STEPS) , (int)(Math.sin(angle)*STEPS));
	}
	
	/**
	 * Returns the Hitbox
	 * @return the Hitbox
	 */
	public Hitbox getHitbox(){
		return h;
	}
	
}
