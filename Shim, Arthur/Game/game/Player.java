package game;

import java.applet.Applet;

/**
 * Represents a player in the game. It can draw players
 * and move the player.
 * @author 165094
 */
public class Player {
	private Hitbox h;
	private final int DISTANCE = 5;
	private char orientation = 'r';
	private int score, direction;
	private boolean hasSpeed, hasShotgun, hasShield, canShoot;
	private int shotgunBulletsLeft;
	 
	
	/**
	 * Creates a player at the given x, y coordinates 
	 * @param x x-coordinate of player
	 * @param y y-coordinate of player
	 * @param p The PApplet
	 */
	public Player(int x, int y, PApplet p){
		int[] xPoints = {x, x + 50, x + 50, x};
		int[] yPoints = {y, y, y + 100, y + 100};
		h = new Hitbox(xPoints, yPoints, 4);
	}
	
	/**
	 * Respawns the players in specified x and y coordinates
	 * Clears all power ups from player
	 * @param x x-coordinate of respawn
	 * @param y y-coordinate of respawn
	 */
	public void respawn(int x, int y){
		
	}
	
	/**
	 * Draws the player
	 */
	public void drawPlayer(){
		
	}
	/**
	 * Draws the weapon that the player is holding
	 */
	public void drawWeapon(){
		
	}
	
	/**
	 * Returns the hitbox of the player
	 * @return hitbox of the player
	 */
	public Hitbox getHitBox(){
		return null;
	}
	
	/**
	 * Given a char that represents a player's command, it performs the action of said
	 * command.
	 * Where:
	 * w = move up
	 * a = move left
	 * s = move down
	 * d = move right
	 * g = shoot a bullet
	 * 
	 * @param com A command represented by a single char
	 */
	public void command(char com){
		if (com =='w'){
			if (orientation == 'w') move(0 , DISTANCE);
			else orientation = 'w';
		}
		else if (com == 'a'){
			if (orientation == 'a') move(-DISTANCE , 0);
			else orientation = 'a';
		}
		else if (com == 's'){
			if (orientation == 's') move(0 , -DISTANCE);
			else orientation = 's';
		}
		else if (com == 'd'){
			if (orientation == 'd') move(DISTANCE , 0);
			else orientation = 'd';
		}
		else if (com == 'g'){
			
		}

	}
	
	/**
	 * Moves the player in x and y directions by specified amounts
	 */
	public void move(int x, int y){
		
	}
	
	/**
	 * Creates and returns a new Bullet
	 * @return a Bullet
	 */
	public Bullet shoot(){
		return null;
	}
	
	/**
	 * Returns the score of this player
	 * @return score of this player
	 */
	public int getScore(){
		return 0;
	}
	/**
	 * Increases the score by one
	 */
	public void incrementScore(){
		
	}
	/**
	 * Given a power up, it changes the state of the specified power-up possession
	 * of the player
	 * @param p The power-up
	 */
	public void consumePowerUp(PowerUp p){
		
	}
}
