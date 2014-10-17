package test;

import game.Hitbox;

/**
 * Tests the Hitbox class
 * @author 165094
 *
 */
public class HitboxTester {

	public static void main(String[] args) {
		int[] x1 = {0, 0, 5, 5};
		int[] y1 = {0, 5, 5, 0};
		int[] x2 = {4, 4, 10, 10};
		int[] y2 = {4, 10, 10, 5};
		
		Hitbox h = new Hitbox(x1,y1, 4);
		Hitbox h2 = new Hitbox(x2,y2, 4);
		
		System.out.println(h.intersects(h2));
		
		h.move(100, 100);
		x1 = h.getXPoints(); y1 = h.getYPoints();
		for (int i = 0; i < 4; i++)
			System.out.println(x1[i] + ", " + y1[i]);
	}

}
