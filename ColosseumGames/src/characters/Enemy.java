package characters;

import characters.Character;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * 
 * @author Richard, Rithvik, Aditya
 *
 */
public abstract class Enemy extends Character {
	
	/**
	 * Creates an Enemy
	 * @param spriteFile the image/looks of the enemy
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
	public Enemy(PImage spriteImage, double speed, double atkSpeed, double HP, double range, double damage, int x, int y,
			int w, int h) {
		super(spriteImage, speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Dictates how an enemy will behave
	 * @param c character the enemy wants to kill
	 * @param marker draws the enemy
	 * @param enemyType the type of enemy
	 */
	public void behave(Character c) {
		int vx = 0;
		int vy = 0;
		

	}
	public int getDirectionAwayFromPlayer(Character c, double distance)
	{
		int directionAway = 0;
		if(Math.abs(this.x - c.getX()) < distance) {
			if(this.x - c.getX() < 0) {
				directionAway = 1;
			}
			else {
				directionAway = 3;
			}
		}
		if(Math.abs(this.y - c.getY()) < distance) {
			if(this.y - c.getY() < 0) {
				directionAway = 4;
			}
			else {
				directionAway = 2;
			}
		}
		if(Math.abs(this.y - c.getY()) < distance + 10 || Math.abs(this.x - c.getX()) < distance + 10) {
			
			directionAway = 5;
		}
		return directionAway;
		
	}
	public int getDirectionToPlayer(Character c) {
		int directionToPlayer = 0;
		
		if(this.y - c.getY() < 0) {
			directionToPlayer = 2;
		}
		if(this.y - c.getY() > 0) {
			directionToPlayer = 4;
		}
		if(this.x - c.getX() > 0) {
			directionToPlayer = 3; 
		}
		if(this.x - c.getX() < 0) {
			directionToPlayer =  1;
		}
		if(this.x - c.getX() == 0 && this.y - c.getY() == 0) {
			directionToPlayer = 5;
		}
		return directionToPlayer;
	}
		
	
}

