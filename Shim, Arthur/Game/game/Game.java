package game;

/**
 * This class runs, draws, and updates the 2D Shooter Game on the screen.
 * This class handles everything necessary to run this game.
 * 
 * @author 165094
 *
 */
public class Game extends PApplet {
	
	/**
	 * Draws the start up screen and sets the 2 Players in the proper positions.
	 */
	public void setup(){
		
	}
	
	/**
	 * Runs the draw methods on all objects in the game
	 */
	public void draw(){
		//update;
	}
	
	/**
	 * Runs whenever a key is pressed
	 * Tells players when specific keys are pressed
	 */
	public void keyPressed(){
		
	}
	
	/**
	 * Updates bullets, mines, player locations, potential player deaths,
	 * power-up spawning, power-up consumption, etc
	 */
	public void update(){
		//
	}
	
	/**
	 * Checks the hitboxes of all objects in the game
	 * (part of update)
	 */
	public void checkCollisions(){
		
	}
	
	/**
	 * Completes player actions
	 * (part of update)
	 */
	public void runPlayerActions(){
	
	}
	
	/**
	 * Restarts the round with players in standard spawn positions
	 * and all mines reset and power ups cleared
	 */
	public void restartRound(){
		
	}
	
	/**
	 * Checks if game has end (when a player reaches a score of 20)
	 * @return True if a player has won with a score of 20, otherwise false
	 */
	public boolean gameOver(){
		return false;
	}
}
