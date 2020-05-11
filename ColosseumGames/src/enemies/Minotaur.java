package enemies;

import characters.Enemy;
import processing.core.PApplet;
import processing.core.PImage;
import characters.Character;

/**
 * Creates a medium level enemy
 * 
 * @author ?
 *
 */
public class Minotaur extends Enemy {
	int reset = 0;
	long chargePlayer = System.currentTimeMillis();
	long seePlayer = 0;
	/**
	 * Creates an Enemy
	 *@param spriteImage the image of the character
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
	public Minotaur(PImage spriteImage, double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super(spriteImage, speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * tells Minotaur objects how to attack the Hero objects
	 * @param c character objects that the Minotaur is targeting
	 * @param marker PApplet object needed to draw
	 */
	public void behave(Character c, PApplet marker) {
		super.behave(c, marker);
		
		if(Math.abs(this.getX() - c.getX()) < 15) {
			this.setVx(0);
			if(this.getY() - c.getY() > 0) {
				this.walk(4);
			}
			else {
				this.walk(2);
			}
		}
		if(Math.abs(this.getY() - c.getY()) < 15) {
			this.setVy(0);
			if(this.getX() - c.getX() > 0) {
				this.walk(3);
			}
			else {
				this.walk(1);
			}
		}
		if(reset == 0) {
			seePlayer = System.currentTimeMillis();
		} 
		else if(chargePlayer/1000 - seePlayer/1000 < 2) {
			chargePlayer = System.currentTimeMillis();
			reset++;

		}
		else {
			reset = 0;
			this.walk(getDirectionToPlayer(c));
		}
		this.shoot(c.getX(), c.getY(), marker, c, this.getX(), this.getY());
		if(c.getVx() == 0 && c.getVy() == 0) {
			this.walk(getDirectionToPlayer(c));
			this.setSpeed(2);
		}
		else {
			this.setSpeed(40);
		}
		
	}

}
