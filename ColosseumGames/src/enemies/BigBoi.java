package enemies;

import characters.Enemy;
import processing.core.PImage;

/**
 * Creates a high level enemy
 * 
 * @author ?
 * @version 2.0
 *
 */
public class BigBoi extends Enemy {

	/**
	 * Creates an Enemy
	 * @param spriteImage the image of the character
	 * @param speed how fast the enemy moves
	 * @param atkSpeed how fast the enemy attacks
	 * @param HP how much damage a enemy can take before dying
	 * @param range the distance a enemy can cover with their weapon
	 * @param damage the amount of damage the enemy can do with their weapon
	 * @param x the x position of the enemy
	 * @param y the x position of the enemy
	 * @param w how wide the enemy is
	 * @param h how tall the enemy is
	 */
	public BigBoi(PImage spriteImage, double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super(spriteImage, speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

}
